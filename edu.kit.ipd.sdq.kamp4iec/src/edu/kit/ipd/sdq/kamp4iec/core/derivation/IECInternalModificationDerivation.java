package edu.kit.ipd.sdq.kamp4iec.core.derivation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import edu.kit.ipd.sdq.kamp.architecture.ArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp.model.modificationmarks.AbstractModification;
import edu.kit.ipd.sdq.kamp.model.modificationmarks.ChangePropagationStep;
import edu.kit.ipd.sdq.kamp.workplan.AbstractActivityElementType;
import edu.kit.ipd.sdq.kamp.workplan.Activity;
import edu.kit.ipd.sdq.kamp.workplan.BasicActivity;
import edu.kit.ipd.sdq.kamp4iec.core.IECArchitectureVersion;
import edu.kit.ipd.sdq.kamp4iec.core.IECActivityElementType;
import edu.kit.ipd.sdq.kamp4iec.core.IECActivityType;
import edu.kit.ipd.sdq.kamp4iec.core.IECArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.FunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.GlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECComponent;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.AbstractKAMP4IECModificationRepository;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyElement;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyGlobalVariable;

public class IECInternalModificationDerivation {
	
	// Fields should be set by user, but defaults used to prevent NullPointer
	private IECChangePropagationDueToDataDependency changePropagationDueToDataDependency =
			IECModificationmarksFactory.eINSTANCE.createIECChangePropagationDueToDataDependency();
	
	public List<Activity> deriveInternalModifications(IECArchitectureVersion targetVersion) {
		List<Activity> activityList = new ArrayList<Activity>();
		if (targetVersion.getModificationMarkRepository() != null) {
			this.findRelevantPropagationSteps(targetVersion.getModificationMarkRepository());
			this.deriveFunctionBlockModifications(activityList);
			this.deriveGlobalVariableModifications(targetVersion, activityList);
			this.deriveGlobalVariableModifications(activityList);
		}
		return activityList;
	}
	
	/**
	 * Relevant for KAMP+IntBIIS are only propagation because of data dependencies and
	 * business processes (both model elements should only exist once). All other kinds
	 * of steps are handled by the superclass.
	 */
	private void findRelevantPropagationSteps(AbstractKAMP4IECModificationRepository<?> 
			modificationRepository) {
		for (ChangePropagationStep step: modificationRepository.getChangePropagationSteps()) {
			if (step instanceof IECChangePropagationDueToDataDependency) {
				this.setIECChangePropagationDueToDataDependency(
						(IECChangePropagationDueToDataDependency) step);
			}
		}
	}

	private void deriveFunctionBlockModifications(List<Activity> activityList) {
		List<IECModifyFunctionBlock> functionBlockModifications = new ArrayList<IECModifyFunctionBlock>(this.
				getIECChangePropagationDueToDataDependency().getFunctionBlockModifications());
		for (IECModifyFunctionBlock modifyFunctionBlock : functionBlockModifications) {
			activityList.add(IECInternalModificationDerivation.createModificationActivity(
					modifyFunctionBlock, getCausingElementsNames(modifyFunctionBlock), IECActivityElementType.FUNCTIONBLOCK));
		}
	}

	private void deriveGlobalVariableModifications(List<Activity> activityList) {
		List<IECModifyGlobalVariable> globalVariableModifications = new ArrayList<IECModifyGlobalVariable>(this.getIECChangePropagationDueToDataDependency().getGlobalVariableModifications());
		for (IECModifyGlobalVariable modifyGlobalVariable : globalVariableModifications) {
			activityList.add(IECInternalModificationDerivation.createModificationActivity(
					modifyGlobalVariable, getCausingElementsNames(modifyGlobalVariable), IECActivityElementType.GLOBALVARIABLE));
		}
	}
	
	private void deriveGlobalVariableModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyGlobalVariable> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyGlobalVariable.class);
		for (IECModifyGlobalVariable modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.GLOBALVARIABLE);
			activityList.add(componentActivity);
			this.deriveSubActivities(modifyComponent, componentActivity);
		}
	}

	private void deriveSubActivities(IECModifyElement<?> modifyComponent, Activity componentActivity) {
//		for (ISModifyProvidedRole modifyProvidedRole : modifyComponent.getAffectedElement()) {			
//		    Activity providedRoleActivity = addModificationSubActivity(modifyProvidedRole, 
//						ISActivityElementType.PROVIDEDROLE, componentActivity);
//		    for (ISModifySignature modifySignature : modifyProvidedRole.getSignatureModifications()) {	
//				addModificationSubActivity(modifySignature, ISActivityElementType.PROVIDEDOPERATION, 
//							providedRoleActivity);
//			}
//		}
//		for (ISModifyRequiredRole modifyRequiredRole : modifyComponent.getRequiredRoleModifications()) {			
//		    Activity requiredRoleActivity = addModificationSubActivity(modifyRequiredRole, 
//						ISActivityElementType.REQUIREDROLE, componentActivity);
//		    for (ISModifySignature modifySignature : modifyRequiredRole.getSignatureModifications()) {
//				addModificationSubActivity(modifySignature, ISActivityElementType.REQUIREDOPERATION, 
//							requiredRoleActivity);
//			}
//		}
	}

	public static List<String> getCausingElementsNames(AbstractModification<?, ?> modification) {
		List<String> causingElementNames = new LinkedList<String>();
		for (Object causingElement : modification.getCausingElements()) {
			if (causingElement instanceof GlobalVariable) {
				GlobalVariable causingModule = (GlobalVariable) causingElement;
				causingElementNames.add(causingModule.eClass().
						getName() + " \"" + causingModule.getId() + "\"");
			} else if (causingElement instanceof FunctionBlock) {
				FunctionBlock causingInterface = (FunctionBlock) causingElement;
				causingElementNames.add(causingInterface.eClass().
						getName() + " \"" + causingInterface.getId() + "\"");
			} else if (causingElement instanceof IECComponent) {
				IECComponent causingCompoenent = (IECComponent) causingElement;
				causingElementNames.add(causingCompoenent.eClass().
						getName() + " \"" + causingCompoenent.getId() + "\"");
			} 
		}
		return causingElementNames;
	}

	public static Activity createModificationActivity(AbstractModification<?, ?> modification,
			List<String> causingElementNames, AbstractActivityElementType activityElementType) {
		if (modification instanceof IECModifyFunctionBlock){
			IECComponent component = ((IECModifyFunctionBlock) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, component,
					component.getId(), causingElementNames, BasicActivity.MODIFY, "Modify " + component.eClass().getName() + ".");
		}
		if (modification instanceof IECModifyGlobalVariable){
			GlobalVariable globalVariable = ((IECModifyGlobalVariable) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, globalVariable, globalVariable.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + globalVariable.eClass().getName() + ".");
		} else {
			return null;
		}
	}

	public static Activity createModificationActivity(AbstractModification<?, ?> modification,
			AbstractActivityElementType activityElementType) {
		List<String> causingElementNames = getCausingElementsNames(modification);
		return createModificationActivity(modification, causingElementNames, activityElementType);
	}
	
	protected IECChangePropagationDueToDataDependency getIECChangePropagationDueToDataDependency() {
		return changePropagationDueToDataDependency;
	}

	protected void setIECChangePropagationDueToDataDependency(
			IECChangePropagationDueToDataDependency changePropagationDueToDataDependency) {
		this.changePropagationDueToDataDependency = changePropagationDueToDataDependency;
	}
	
}
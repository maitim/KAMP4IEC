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
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Configuration;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Function;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.FunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.GlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECComponent;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECInterface;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECMethod;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECMethodImplementation;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECProperty;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECPropertyImplementation;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.AbstractKAMP4IECModificationRepository;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyConfiguration;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyElement;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyEnum;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunction;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyGlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyInterface;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyMethod;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyMethodImplementation;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyProgram;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyProperty;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyPropertyImplementation;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl.IECModifyPropertyImpl;

public class IECInternalModificationDerivation {
	
	private IECChangePropagationDueToDataDependency changePropagationDueToDataDependency =
			IECModificationmarksFactory.eINSTANCE.createIECChangePropagationDueToDataDependency();
	
	public List<Activity> deriveInternalModifications(IECArchitectureVersion targetVersion) {
		List<Activity> activityList = new ArrayList<Activity>();
		if (targetVersion.getModificationMarkRepository() != null) {
			this.findRelevantPropagationSteps(targetVersion.getModificationMarkRepository());
			this.deriveFunctionBlockModifications(activityList);
			this.deriveGlobalVariableModifications(targetVersion, activityList);
			this.deriveConfigurationModifications(targetVersion, activityList);
			this.deriveProgramModifications(targetVersion, activityList);
			this.deriveFunctionModifications(targetVersion, activityList);
			this.deriveMethodModifications(targetVersion, activityList);
			this.deriveMethodImplementationModifications(targetVersion, activityList);
			this.derivePropertyModifications(targetVersion, activityList);
			this.derivePropertyImplementationModifications(targetVersion, activityList);
			this.deriveInterfaceModifications(targetVersion, activityList);
			this.deriveEnumModifications(targetVersion, activityList);
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
	
	private void deriveGlobalVariableModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyGlobalVariable> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyGlobalVariable.class);
		for (IECModifyGlobalVariable modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.GLOBALVARIABLE);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveConfigurationModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyConfiguration> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyConfiguration.class);
		for (IECModifyConfiguration modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.CONFIGURATION);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveProgramModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyProgram> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyProgram.class);
		for (IECModifyProgram modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.PROGRAM);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveFunctionModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyFunction> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyFunction.class);
		for (IECModifyFunction modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.FUNCTION);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveMethodModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyMethod> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyMethod.class);
		for (IECModifyMethod modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.METHOD);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveMethodImplementationModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyMethodImplementation> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyMethodImplementation.class);
		for (IECModifyMethodImplementation modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.METHODIMPLEMENTATION);
			activityList.add(componentActivity);
		}
	}
	
	private void derivePropertyModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyProperty> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyProperty.class);
		for (IECModifyProperty modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.PROPERTY);
			activityList.add(componentActivity);
		}
	}
	
	private void derivePropertyImplementationModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyPropertyImplementation> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyPropertyImplementation.class);
		for (IECModifyPropertyImplementation modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.PROPERTYIMPLEMENTATION);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveInterfaceModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyInterface> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyInterface.class);
		for (IECModifyInterface modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.INTERFACE);
			activityList.add(componentActivity);
		}
	}
	
	private void deriveEnumModifications(IECArchitectureVersion targetVersion, List<Activity> activityList) {
		Collection<IECModifyEnum> modifyComponents = ArchitectureModelLookup.lookUpAllCalculatedMarksOfAType(targetVersion, IECModifyEnum.class);
		for (IECModifyEnum modifyComponent : modifyComponents) {
			Activity componentActivity = createModificationActivity(modifyComponent, 
					   IECActivityElementType.ENUM);
			activityList.add(componentActivity);
		}
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
			FunctionBlock component = ((IECModifyFunctionBlock) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, component,
					component.getId(), causingElementNames, BasicActivity.MODIFY, "Modify " + component.eClass().getName() + ".");
		} else if (modification instanceof IECModifyGlobalVariable){
			GlobalVariable globalVariable = ((IECModifyGlobalVariable) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, globalVariable, globalVariable.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + globalVariable.eClass().getName() + ".");
		} else if (modification instanceof IECModifyConfiguration){
			Configuration config = ((IECModifyConfiguration) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, config, config.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + config.eClass().getName() + ".");
		} else if (modification instanceof IECModifyFunction){
			Function function = ((IECModifyFunction) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, function, function.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + function.eClass().getName() + ".");
		} else if (modification instanceof IECModifyMethod){
			IECMethod method = ((IECModifyMethod) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, method, method.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + method.eClass().getName() + ".");
		} else if (modification instanceof IECModifyMethodImplementation){
			IECMethodImplementation method = ((IECModifyMethodImplementation) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, method, method.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + method.eClass().getName() + ".");
		} else if (modification instanceof IECModifyProperty){
			IECProperty function = ((IECModifyProperty) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, function, function.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + function.eClass().getName() + ".");
		} else if (modification instanceof IECModifyPropertyImplementation){
			IECPropertyImplementation function = ((IECModifyPropertyImplementation) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, function, function.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + function.eClass().getName() + ".");
		} else if (modification instanceof IECModifyProgram){
			Program program = ((IECModifyProgram) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, program, program.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + program.eClass().getName() + ".");
		} else if (modification instanceof IECModifyInterface){
			IECInterface iecInterface = ((IECModifyInterface) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, iecInterface, iecInterface.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + iecInterface.eClass().getName() + ".");
		} else if (modification instanceof IECModifyEnum){
			edu.kit.ipd.sdq.kamp4iec.model.IECModel.Enum function = ((IECModifyEnum) modification).getAffectedElement();
			return new Activity(IECActivityType.INTERNALMODIFICATIONMARK, activityElementType, function, function.getId(), 
					causingElementNames, BasicActivity.MODIFY, "Modify " + function.eClass().getName() + ".");
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

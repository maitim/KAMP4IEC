package edu.kit.ipd.sdq.kamp4iec.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.kit.ipd.sdq.kamp.architecture.ArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp.model.modificationmarks.AbstractModification;
import edu.kit.ipd.sdq.kamp.model.modificationmarks.ModificationmarksFactory;
import edu.kit.ipd.sdq.kamp.propagation.AbstractChangePropagationAnalysis;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Configuration;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Function;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.FunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.GlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECComponent;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECInterface;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECMethod;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECMethodImplementation;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyConfiguration;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunction;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyMethod;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyProgram;

/**
 * The change propagation analysis of KAPS
 * 1. determines a seed population of affected components (resp. provided roles)
 * 2. calculates in iterations:
 *    a) inter-component propagation
 *    b) intra-component propagation
 * 3. generates internal modification marks for affected elements
 * 
 * - elements which were already part of a seed population are not further investigated
 * 
 * 
 * @author raetz
 *
 */
public class IECChangePropagationAnalysis implements AbstractChangePropagationAnalysis<IECArchitectureVersion> {

	private Collection<IECComponent> markedComponents;
	private IECChangePropagationDueToDataDependency changePropagationDueToDataDependencies;

	@Override
	public void runChangePropagationAnalysis(IECArchitectureVersion version) {
		// Setup
		this.prepareAnalysis(version);
		
		// Calculate
		this.calculateChangePropagationDueToDataDependencies(version);		
			
		// Update

		
	}
	
	private void prepareAnalysis(IECArchitectureVersion version) {
		this.setIECChangePropagationDueToDataDependency(IECModificationmarksFactory.eINSTANCE.
				createIECChangePropagationDueToDataDependency());
		/* Link calculated data dependency propagation steps to propagation steps of version,
		 * so the already marked elements are up to date for all sub-steps of the algorithm*/	
		version.getModificationMarkRepository().getChangePropagationSteps().add(
				this.getIECChangePropagationDueToDataDependencies());
		// Store marked model elements to reduce model traversal in calculation methods
		//double cast to avoid type-mismatch
		this.setMarkedComponents(edu.kit.ipd.sdq.kamp.architecture.ArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, IECComponent.class));
	}
	
	/**
	 * Calculates the DataType-/DataObject-related changes.
	 */
	public void calculateChangePropagationDueToDataDependencies(IECArchitectureVersion version) {
		// Create only one modification mark per element in this propagation step (affects only
		// DataTypes and DataObjects which could be marked by multiple sub-steps)
		Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep = 
				new HashMap<EObject, AbstractModification<?,EObject>>();
		
		// Add seed modifications
		calculateAndMarkGlobalVariableSeedModifications(version);

		// 1 GlobalVariable -> Configuration
		calculateAndMarkGlobalVariableToConfigurationPropagation(version, elementsMarkedInThisStep);
		// 2 GlobalVariable -> Program
		calculateAndMarkGlobalVariableToProgramPropagation(version, elementsMarkedInThisStep);
		// 3 GlobalVariable -> FunctionBlock
		calculateAndMarkGlobalVariableToFunctionBlockPropagation(version, elementsMarkedInThisStep);
		// 4 GlobalVariable -> Method
		calculateAndMarkGlobalVariableToMethodPropagation(version, elementsMarkedInThisStep);
		
		//If no at all changes: remove top-level element from tree
		if (this.getIECChangePropagationDueToDataDependencies().eContents().isEmpty()) {			
			version.getModificationMarkRepository().getChangePropagationSteps().remove(
					this.getIECChangePropagationDueToDataDependencies());	
		}
	}
	
	protected void calculateAndMarkGlobalVariableSeedModifications(IECArchitectureVersion version) {
		markedComponents.addAll(ArchitectureModelLookup.lookUpMarkedObjectsOfATypeInSeedModifications(version, GlobalVariable.class));
	}
	
	//GlobalVariable propagations
	
	protected void calculateAndMarkGlobalVariableToFunctionBlockPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof GlobalVariable) {
				markedGlobalVariables.add((GlobalVariable) marked);
			}
		}
		Map<FunctionBlock, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpFunctionBlocksOfGlobalVariable(version, markedGlobalVariables);

		 for(Map.Entry<FunctionBlock, Set<GlobalVariable>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyFunctionBlock modifyDataType = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
				modifyDataType.setToolderived(true);
				modifyDataType.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modifyDataType.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modifyDataType);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
						add(modifyDataType);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkGlobalVariableToConfigurationPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof GlobalVariable) {
				markedGlobalVariables.add((GlobalVariable) marked);
			}
		}
		Map<Configuration, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpConfigurationOfGlobalVariable(version, markedGlobalVariables);

		 for(Map.Entry<Configuration, Set<GlobalVariable>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyConfiguration modification = IECModificationmarksFactory.eINSTANCE.createIECModifyConfiguration();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getConfigurationModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkGlobalVariableToProgramPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof GlobalVariable) {
				markedGlobalVariables.add((GlobalVariable) marked);
			}
		}
		Map<Program, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpProgramsOfGlobalVariable(version, markedGlobalVariables);

		 for(Map.Entry<Program, Set<GlobalVariable>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkGlobalVariableToMethodPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof GlobalVariable) {
				markedGlobalVariables.add((GlobalVariable) marked);
			}
		}
		Map<IECMethodImplementation, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpMethodsOfGlobalVariable(version, markedGlobalVariables);

		 for(Map.Entry<IECMethodImplementation, Set<GlobalVariable>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getMethodModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	//FunctionBlock propagations
	
	protected void calculateAndMarkFunctionBlockToProgramPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof FunctionBlock) {
				markedFunctionBlocks.add((FunctionBlock) marked);
			}
		}
		Map<Program, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpProgramsOfFunctionBlock(version, markedFunctionBlocks);

		 for(Map.Entry<Program, Set<FunctionBlock>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkFunctionBlockToFunctionPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof FunctionBlock) {
				markedFunctionBlocks.add((FunctionBlock) marked);
			}
		}
		Map<Function, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpFunctionsOfFunctionBlock(version, markedFunctionBlocks);

		 for(Map.Entry<Function, Set<FunctionBlock>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyFunction modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunction();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getFunctionModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkFunctionBlockToMethodPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof FunctionBlock) {
				markedFunctionBlocks.add((FunctionBlock) marked);
			}
		}
		Map<IECMethodImplementation, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpMethodsOfFunctionBlock(version, markedFunctionBlocks);

		 for(Map.Entry<IECMethodImplementation, Set<FunctionBlock>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getMethodModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	//Function propagations
	
	protected void calculateAndMarkFunctionToMethodPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<Function> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof Function) {
				markedFunctionBlocks.add((Function) marked);
			}
		}
		Map<IECMethodImplementation, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpMethodsOfFunction(version, markedFunctionBlocks);

		 for(Map.Entry<IECMethodImplementation, Set<Function>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getMethodModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkFunctionToFunctionBlockPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<Function> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof Function) {
				markedFunctionBlocks.add((Function) marked);
			}
		}
		Map<FunctionBlock, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpFunctionBlocksOfFunction(version, markedFunctionBlocks);

		 for(Map.Entry<FunctionBlock, Set<Function>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkFunctionToProgramPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<Function> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof Function) {
				markedFunctionBlocks.add((Function) marked);
			}
		}
		Map<Program, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpProgramsOfFunction(version, markedFunctionBlocks);

		 for(Map.Entry<Program, Set<Function>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkFunctionToFunctionPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<Function> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof Function) {
				markedFunctionBlocks.add((Function) marked);
			}
		}
		Map<Function, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpFunctionsOfFunction(version, markedFunctionBlocks);

		 for(Map.Entry<Function, Set<Function>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyFunction modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunction();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getFunctionModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	//Interface propagations
	
	protected void calculateAndMarkInterfaceToFunctionBlockPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<IECInterface> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof IECInterface) {
				markedFunctionBlocks.add((IECInterface) marked);
			}
		}
		Map<FunctionBlock, Set<IECInterface>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpFunctionBlocksOfInterface(version, markedFunctionBlocks);

		 for(Map.Entry<FunctionBlock, Set<IECInterface>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	protected void calculateAndMarkInterfaceToProgramPropagation(IECArchitectureVersion version,
			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		List<IECInterface> markedFunctionBlocks = new ArrayList<>();
		for(IECComponent marked : getMarkedComponents()) {
			if(marked instanceof IECInterface) {
				markedFunctionBlocks.add((IECInterface) marked);
			}
		}
		Map<Program, Set<IECInterface>> elementsToBeMarked = IECArchitectureModelLookup.
				lookUpProgramsOfInterface(version, markedFunctionBlocks);

		 for(Map.Entry<Program, Set<IECInterface>> elementsToBeMarkedEntry: 
			 	elementsToBeMarked.entrySet()) {
			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().contains(cause)) {
						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
							getCausingElements().add(cause);	
					}
				}	
			} else {
				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
				modification.setToolderived(true);
				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
				
				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
						add(modification);
				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
			}
		 }
	}
	
	public <T extends IECComponent, S extends IECComponent>void continuePropagation(IECArchitectureVersion version, Map.Entry<T, Set<S>> entry, Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
		if(entry.getKey() instanceof GlobalVariable) {
			calculateAndMarkGlobalVariableToConfigurationPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkGlobalVariableToProgramPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkGlobalVariableToFunctionBlockPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkGlobalVariableToMethodPropagation(version, elementsMarkedInThisStep);
		} else if (entry.getKey() instanceof Function) {
			calculateAndMarkFunctionToProgramPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkFunctionToFunctionBlockPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkFunctionToMethodPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkFunctionToFunctionPropagation(version, elementsMarkedInThisStep);
		} else if (entry.getKey() instanceof FunctionBlock) {
			calculateAndMarkFunctionBlockToProgramPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkFunctionBlockToFunctionPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkFunctionBlockToMethodPropagation(version, elementsMarkedInThisStep);
		} else if (entry.getKey() instanceof IECInterface) {
			calculateAndMarkInterfaceToProgramPropagation(version, elementsMarkedInThisStep);
			calculateAndMarkInterfaceToFunctionBlockPropagation(version, elementsMarkedInThisStep);
		}
	}
	

	protected void setIECChangePropagationDueToDataDependency(IECChangePropagationDueToDataDependency changePropagationDueToDataDependencies) {
		this.changePropagationDueToDataDependencies = changePropagationDueToDataDependencies;
	}
	
	public IECChangePropagationDueToDataDependency getIECChangePropagationDueToDataDependencies() {
		return changePropagationDueToDataDependencies;
	}

	public Collection<IECComponent> getMarkedComponents() {
		return markedComponents;
	}

	public void setMarkedComponents(Collection<IECComponent> markedComponents) {
		this.markedComponents = markedComponents;
	}

	public void setChangePropagationDueToDataDependencies(
			IECChangePropagationDueToDataDependency changePropagationDueToDataDependencies) {
		this.changePropagationDueToDataDependencies = changePropagationDueToDataDependencies;
	}


}
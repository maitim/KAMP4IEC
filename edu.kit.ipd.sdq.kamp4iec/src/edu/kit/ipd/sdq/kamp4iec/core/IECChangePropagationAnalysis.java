package edu.kit.ipd.sdq.kamp4iec.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.kit.ipd.sdq.kamp.architecture.ArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp.model.modificationmarks.AbstractModification;
import edu.kit.ipd.sdq.kamp.propagation.AbstractChangePropagationAnalysis;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Configuration;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Function;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.FunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.GlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractMethod;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractProperty;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECComponent;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECInterface;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECMethod;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECProperty;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyConfiguration;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunction;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyInterface;
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
		
//		// Add seed modifications
//		calculateAndMarkGlobalVariableSeedModifications(version);
//
//		// 1 GlobalVariable -> Configuration
//		calculateAndMarkGlobalVariableToConfigurationPropagation(version, elementsMarkedInThisStep);
//		// 2 GlobalVariable -> Program
//		calculateAndMarkGlobalVariableToProgramPropagation(version, elementsMarkedInThisStep);
//		// 3 GlobalVariable -> FunctionBlock
//		calculateAndMarkGlobalVariableToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//		// 4 GlobalVariable -> Method
//		calculateAndMarkGlobalVariableToMethodPropagation(version, elementsMarkedInThisStep);
		
		//If no at all changes: remove top-level element from tree
		if (this.getIECChangePropagationDueToDataDependencies().eContents().isEmpty()) {			
			version.getModificationMarkRepository().getChangePropagationSteps().remove(
					this.getIECChangePropagationDueToDataDependencies());	
		}
	}
	
	protected void calculateAndMarkGlobalVariableSeedModifications(IECArchitectureVersion version) {
		markedComponents.addAll(ArchitectureModelLookup.lookUpMarkedObjectsOfATypeInSeedModifications(version, GlobalVariable.class));
	}
//	
//	//GlobalVariable propagations
//	
//	protected void calculateAndMarkGlobalVariableToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof GlobalVariable) {
//				markedGlobalVariables.add((GlobalVariable) marked);
//			}
//		}
//		Map<FunctionBlock, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfGlobalVariable(version, markedGlobalVariables);
//
//		 for(Map.Entry<FunctionBlock, Set<GlobalVariable>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modifyDataType = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modifyDataType.setToolderived(true);
//				modifyDataType.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modifyDataType.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modifyDataType);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modifyDataType);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkGlobalVariableToConfigurationPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof GlobalVariable) {
//				markedGlobalVariables.add((GlobalVariable) marked);
//			}
//		}
//		Map<Configuration, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpConfigurationOfGlobalVariable(version, markedGlobalVariables);
//
//		 for(Map.Entry<Configuration, Set<GlobalVariable>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyConfiguration modification = IECModificationmarksFactory.eINSTANCE.createIECModifyConfiguration();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getConfigurationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkGlobalVariableToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof GlobalVariable) {
//				markedGlobalVariables.add((GlobalVariable) marked);
//			}
//		}
//		Map<Program, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfGlobalVariable(version, markedGlobalVariables);
//
//		 for(Map.Entry<Program, Set<GlobalVariable>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkGlobalVariableToMethodPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<GlobalVariable> markedGlobalVariables = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof GlobalVariable) {
//				markedGlobalVariables.add((GlobalVariable) marked);
//			}
//		}
//		Map<IECMethod, Set<GlobalVariable>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpMethodsOfGlobalVariable(version, markedGlobalVariables);
//
//		 for(Map.Entry<IECMethod, Set<GlobalVariable>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getMethodImplementationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//FunctionBlock propagations
//	
//	protected void calculateAndMarkFunctionBlockToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof FunctionBlock) {
//				markedFunctionBlocks.add((FunctionBlock) marked);
//			}
//		}
//		Map<Program, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfFunctionBlock(version, markedFunctionBlocks);
//
//		 for(Map.Entry<Program, Set<FunctionBlock>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkFunctionBlockToMethodPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof FunctionBlock) {
//				markedFunctionBlocks.add((FunctionBlock) marked);
//			}
//		}
//		Map<IECMethod, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpMethodsOfFunctionBlock(version, markedFunctionBlocks);
//
//		 for(Map.Entry<IECMethod, Set<FunctionBlock>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getMethodImplementationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkFunctionBlockToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<FunctionBlock> markedFunctionBlocks = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof FunctionBlock) {
//				markedFunctionBlocks.add((FunctionBlock) marked);
//			}
//		}
//		Map<FunctionBlock, Set<FunctionBlock>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfFunctionBlock(version, markedFunctionBlocks);
//
//		 for(Map.Entry<FunctionBlock, Set<FunctionBlock>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//Function propagations
//	
//	protected void calculateAndMarkFunctionToMethodPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<Function> markedFunctions = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof Function) {
//				markedFunctions.add((Function) marked);
//			}
//		}
//		Map<IECMethod, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpMethodsOfFunction(version, markedFunctions);
//
//		 for(Map.Entry<IECMethod, Set<Function>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getMethodImplementationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkFunctionToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<Function> markedFunctions = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof Function) {
//				markedFunctions.add((Function) marked);
//			}
//		}
//		Map<FunctionBlock, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfFunction(version, markedFunctions);
//
//		 for(Map.Entry<FunctionBlock, Set<Function>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkFunctionToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<Function> markedFunctions = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof Function) {
//				markedFunctions.add((Function) marked);
//			}
//		}
//		Map<Program, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfFunction(version, markedFunctions);
//
//		 for(Map.Entry<Program, Set<Function>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkFunctionToFunctionPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<Function> markedFunctions = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof Function) {
//				markedFunctions.add((Function) marked);
//			}
//		}
//		Map<Function, Set<Function>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionsOfFunction(version, markedFunctions);
//
//		 for(Map.Entry<Function, Set<Function>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunction modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunction();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//Interface propagations
//	
//	protected void calculateAndMarkInterfaceToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECInterface> markedInterfaces = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECInterface) {
//				markedInterfaces.add((IECInterface) marked);
//			}
//		}
//		Map<FunctionBlock, Set<IECInterface>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfInterface(version, markedInterfaces);
//
//		 for(Map.Entry<FunctionBlock, Set<IECInterface>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkInterfaceToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECInterface> markedInterfaces = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECInterface) {
//				markedInterfaces.add((IECInterface) marked);
//			}
//		}
//		Map<Program, Set<IECInterface>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfInterface(version, markedInterfaces);
//
//		 for(Map.Entry<Program, Set<IECInterface>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//Propagation of Interface-parts
//	
//	protected void calculateAndMarkMethodToInterfacePropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECAbstractMethod> markedMethods = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECAbstractMethod) {
//				markedMethods.add((IECAbstractMethod) marked);
//			}
//		}
//		Map<IECInterface, Set<IECAbstractMethod>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpInterfaceOfMethod(version, markedMethods);
//
//		 for(Map.Entry<IECInterface, Set<IECAbstractMethod>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyInterface modification = IECModificationmarksFactory.eINSTANCE.createIECModifyInterface();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getInterfaceModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkPropertyToInterfacePropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECAbstractProperty> properties = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECAbstractProperty) {
//				properties.add((IECAbstractProperty) marked);
//			}
//		}
//		Map<IECInterface, Set<IECAbstractProperty>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpInterfaceOfProperty(version, properties);
//
//		 for(Map.Entry<IECInterface, Set<IECAbstractProperty>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyInterface modification = IECModificationmarksFactory.eINSTANCE.createIECModifyInterface();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getInterfaceModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//Program propagation
//	
//	protected void calculateAndMarkProgramToConfigurationPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<Program> markedPrograms = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof Program) {
//				markedPrograms.add((Program) marked);
//			}
//		}
//		Map<Configuration, Set<Program>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpConfigurationOfProgram(version, markedPrograms);
//
//		 for(Map.Entry<Configuration, Set<Program>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyConfiguration modification = IECModificationmarksFactory.eINSTANCE.createIECModifyConfiguration();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getConfigurationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	//MethodImplementation propagation
//	
//	protected void calculateAndMarkMethodImplementationToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECMethod> markedMethods = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECMethod) {
//				markedMethods.add((IECMethod) marked);
//			}
//		}
//		Map<FunctionBlock, Set<IECMethod>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfMethodImplementation(version, markedMethods);
//
//		 for(Map.Entry<FunctionBlock, Set<IECMethod>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkMethodImplementationToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECMethod> markedMethods = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECMethod) {
//				markedMethods.add((IECMethod) marked);
//			}
//		}
//		Map<Program, Set<IECMethod>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfMethodImplementation(version, markedMethods);
//
//		 for(Map.Entry<Program, Set<IECMethod>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkMethodImplementationToMethodPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECMethod> markedMethods = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECMethod) {
//				markedMethods.add((IECMethod) marked);
//			}
//		}
//		Map<IECMethod, Set<IECMethod>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpMethodsOfMethodImplementation(version, markedMethods);
//
//		 for(Map.Entry<IECMethod, Set<IECMethod>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getMethodImplementationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//
//	//PropertyImplementation propagation
//	
//	protected void calculateAndMarkPropertyImplementationToMethodPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECProperty> markedProperties = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECProperty) {
//				markedProperties.add((IECProperty) marked);
//			}
//		}
//		Map<IECMethod, Set<IECProperty>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpMethodImplementaionsOfPropertyImplementation(version, markedProperties);
//
//		 for(Map.Entry<IECMethod, Set<IECProperty>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyMethod modification = IECModificationmarksFactory.eINSTANCE.createIECModifyMethod();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getMethodImplementationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkPropertyImplementationToFunctionBlockPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECProperty> markedProperties = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECProperty) {
//				markedProperties.add((IECProperty) marked);
//			}
//		}
//		Map<FunctionBlock, Set<IECProperty>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpFunctionBlocksOfPropertyImplementation(version, markedProperties);
//
//		 for(Map.Entry<FunctionBlock, Set<IECProperty>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyFunctionBlock modification = IECModificationmarksFactory.eINSTANCE.createIECModifyFunctionBlock();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getFunctionBlockModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkPropertyImplementationToConfigurationPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECProperty> markedProperties = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECProperty) {
//				markedProperties.add((IECProperty) marked);
//			}
//		}
//		Map<Configuration, Set<IECProperty>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpConfigurationsOfPropertyImplementation(version, markedProperties);
//
//		 for(Map.Entry<Configuration, Set<IECProperty>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyConfiguration modification = IECModificationmarksFactory.eINSTANCE.createIECModifyConfiguration();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getConfigurationModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	protected void calculateAndMarkPropertyImplementationToProgramPropagation(IECArchitectureVersion version,
//			Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		List<IECProperty> markedProperties = new ArrayList<>();
//		for(IECComponent marked : getMarkedComponents()) {
//			if(marked instanceof IECProperty) {
//				markedProperties.add((IECProperty) marked);
//			}
//		}
//		Map<Program, Set<IECProperty>> elementsToBeMarked = IECArchitectureModelLookup.
//				lookUpProgramsOfPropertyImplementation(version, markedProperties);
//
//		 for(Map.Entry<Program, Set<IECProperty>> elementsToBeMarkedEntry: 
//			 	elementsToBeMarked.entrySet()) {
//			if (elementsMarkedInThisStep.containsKey(elementsToBeMarkedEntry.getKey())) {
//				for(IECComponent cause: elementsToBeMarkedEntry.getValue()) {
//					if (!elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().contains(cause)) {
//						elementsMarkedInThisStep.get(elementsToBeMarkedEntry.getKey()).
//							getCausingElements().add(cause);	
//					}
//				}	
//			} else {
//				IECModifyProgram modification = IECModificationmarksFactory.eINSTANCE.createIECModifyProgram();
//				modification.setToolderived(true);
//				modification.setAffectedElement(elementsToBeMarkedEntry.getKey());
//				modification.getCausingElements().addAll(elementsToBeMarkedEntry.getValue());
//				
//				elementsMarkedInThisStep.put(elementsToBeMarkedEntry.getKey(), modification);
//				this.getMarkedComponents().add(elementsToBeMarkedEntry.getKey());
//				this.getIECChangePropagationDueToDataDependencies().getProgramModifications().
//						add(modification);
//				continuePropagation(version, elementsToBeMarkedEntry, elementsMarkedInThisStep);
//			}
//		 }
//	}
//	
//	public <T extends IECComponent, S extends IECComponent>void continuePropagation(IECArchitectureVersion version, Map.Entry<T, Set<S>> entry, Map<EObject, AbstractModification<?,EObject>> elementsMarkedInThisStep) {
//		if(entry.getKey() instanceof GlobalVariable) {
//			calculateAndMarkGlobalVariableToConfigurationPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkGlobalVariableToProgramPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkGlobalVariableToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkGlobalVariableToMethodPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof Function) {
//			calculateAndMarkFunctionToProgramPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkFunctionToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkFunctionToMethodPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkFunctionToFunctionPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof FunctionBlock) {
//			calculateAndMarkFunctionBlockToProgramPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkFunctionBlockToMethodPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkFunctionBlockToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof IECInterface) {
//			calculateAndMarkInterfaceToProgramPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkInterfaceToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof IECMethod) {
//			calculateAndMarkMethodToInterfacePropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof IECProperty) {
//			calculateAndMarkPropertyToInterfacePropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof IECMethod) {
//			calculateAndMarkMethodImplementationToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkMethodImplementationToMethodPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkMethodImplementationToProgramPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof IECProperty) {
//			calculateAndMarkPropertyImplementationToFunctionBlockPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkPropertyImplementationToMethodPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkPropertyImplementationToProgramPropagation(version, elementsMarkedInThisStep);
//			calculateAndMarkPropertyImplementationToConfigurationPropagation(version, elementsMarkedInThisStep);
//		} else if (entry.getKey() instanceof Program) {
//			calculateAndMarkProgramToConfigurationPropagation(version, elementsMarkedInThisStep);
//		}
//	}
//	

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

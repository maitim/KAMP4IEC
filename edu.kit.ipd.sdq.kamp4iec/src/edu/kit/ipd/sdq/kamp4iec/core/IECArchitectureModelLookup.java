package edu.kit.ipd.sdq.kamp4iec.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp.util.MapUtil;
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

public class IECArchitectureModelLookup {

//	/**
//	 * Looks up all {@link Program}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link IECInterface}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param interfaces The {@link IECInterface}s to look up.
//	 * @return A map of all {@link Program}s and which {@link IECInterface}s they are accessing.
//	 */
//	public static Map<Program, Set<IECInterface>> lookUpProgramsOfInterface(
//			IECArchitectureVersion version, Collection<IECInterface> interfaces) {
//		Map<Program, Set<IECInterface>> results = new HashMap<Program, Set<IECInterface>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for(IECInterface accessed : program.getImplementsInterface()) {
//				for(IECInterface interf : interfaces) {
//					putOrAddToMap(results, program, accessed, interf);
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link IECInterface} which implement the given {@link IECInterface}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param interfaces The {@link IECInterface}s to look up.
//	 * @return A map of all {@link FunctionBlock}s and which {@link IECInterface}s they are implementing.
//	 */
//	public static Map<FunctionBlock, Set<IECInterface>> lookUpFunctionBlocksOfInterface(
//			IECArchitectureVersion version, Collection<IECInterface> interfaces) {
//		Map<FunctionBlock, Set<IECInterface>> results = new HashMap<FunctionBlock, Set<IECInterface>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for(FunctionBlock functionBlock : program.getDeclaresFunctionBlock()) {
//				for(IECInterface accessed : functionBlock.getImplements()) {
//					for(IECInterface interf : interfaces) {
//						putOrAddToMap(results, functionBlock, accessed, interf);
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link Program}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link FunctionBlock}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functionBlocks The {@link FunctionBlock}s to look up.
//	 * @return A map of all {@link Program}s and which {@link FunctionBlock}s they are accessing.
//	 */
//	public static Map<Program, Set<FunctionBlock>> lookUpProgramsOfFunctionBlock(
//			IECArchitectureVersion version, Collection<FunctionBlock> functionBlocks) {
//		Map<Program, Set<FunctionBlock>> results = new HashMap<Program, Set<FunctionBlock>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for(FunctionBlock functionBlock : functionBlocks) {
//				for(FunctionBlock accessed : program.getDeclaresFunctionBlock()) {
//					putOrAddToMap(results, program, accessed, functionBlock);
//				}
//				for(FunctionBlock accessed : program.getCallsFunctionBlock()) {
//					putOrAddToMap(results, program, accessed, functionBlock);
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link IECMethodImplementation}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link FunctionBlock}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functionBlocks The {@link FunctionBlock}s to look up.
//	 * @return A map of all {@link IECMethodImplementation}s and which {@link FunctionBlock}s they are accessing.
//	 */
//	public static Map<IECMethod, Set<FunctionBlock>> lookUpMethodsOfFunctionBlock(
//			IECArchitectureVersion version, Collection<FunctionBlock> functionBlocks) {
//		Map<IECMethod, Set<FunctionBlock>> results = new HashMap<IECMethod, Set<FunctionBlock>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency dependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(FunctionBlock functionBlock : functionBlocks) {
//					if(dependency.getProvidedFunctionBlock().getId().equals(functionBlock.getId())) {
//						if(dependency.getRequiredResource() instanceof IECMethod) {
//							putOrAddToMap(results, (IECMethod) dependency.getRequiredResource(), dependency.getProvidedFunctionBlock(), functionBlock);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link FunctionBlock}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functionBlocks The {@link FunctionBlock}s to look up.
//	 * @return A map of all {@link FunctionBlock}s and which {@link FunctionBlock}s they are accessing.
//	 */
//	public static Map<FunctionBlock, Set<FunctionBlock>> lookUpFunctionBlocksOfFunctionBlock(
//			IECArchitectureVersion version, Collection<FunctionBlock> functionBlocks) {
//		Map<FunctionBlock, Set<FunctionBlock>> results = new HashMap<FunctionBlock, Set<FunctionBlock>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency dependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(FunctionBlock functionBlock : functionBlocks) {
//					if(dependency.getProvidedFunctionBlock().getId().equals(functionBlock.getId())) {
//						if(dependency.getRequiredResource() instanceof FunctionBlock) {
//							putOrAddToMap(results, (FunctionBlock) dependency.getRequiredResource(), dependency.getProvidedFunctionBlock(), functionBlock);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link IECMethodImplementation}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link Function}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functions The {@link Function}s to look up.
//	 * @return A map of all {@link IECMethodImplementation}s and which {@link Function}s they are accessing.
//	 */
//	public static Map<IECMethod, Set<Function>> lookUpMethodsOfFunction(
//			IECArchitectureVersion version, Collection<Function> functions) {
//		Map<IECMethod, Set<Function>> results = new HashMap<IECMethod, Set<Function>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for (FunctionBlock functionBlock : program.getDeclaresFunctionBlock()) {
//				for(IECMethod method : functionBlock.getHasMethod()) {
//					for(Function function : functions) {
//						for(Function accessed : method.getCallsFunction()) {
//							putOrAddToMap(results, method, accessed, function);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link Function}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functions The {@link Function}s to look up.
//	 * @return A map of all {@link FunctionBlock}s and which {@link Function}s they are accessing.
//	 */
//	public static Map<FunctionBlock, Set<Function>> lookUpFunctionBlocksOfFunction(
//			IECArchitectureVersion version, Collection<Function> functions) {
//		Map<FunctionBlock, Set<Function>> results = new HashMap<FunctionBlock, Set<Function>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for (FunctionBlock functionBlock : program.getDeclaresFunctionBlock()) {
//				for(Function function : functions) {
//					for(Function accessed : functionBlock.getCallsFunction()) {
//						putOrAddToMap(results, functionBlock, accessed, function);
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link Program}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link Function}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functions The {@link Function}s to look up.
//	 * @return A map of all {@link Program}s and which {@link Function}s they are accessing.
//	 */
//	public static Map<Program, Set<Function>> lookUpProgramsOfFunction(
//			IECArchitectureVersion version, Collection<Function> functions) {
//		Map<Program, Set<Function>> results = new HashMap<Program, Set<Function>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for(Function function : functions) {
//				for(Function accessed : program.getCallsFunction()) {
//					putOrAddToMap(results, program, accessed, function);
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link Function}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link Function}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param functions The {@link Function}s to look up.
//	 * @return A map of all {@link Function}s and which {@link Function}s they are accessing.
//	 */
//	public static Map<Function, Set<Function>> lookUpFunctionsOfFunction(
//			IECArchitectureVersion version, Collection<Function> functions) {
//		Map<Function, Set<Function>> results = new HashMap<Function, Set<Function>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for(Function callingFunction : program.getCallsFunction()) {
//				for(Function function : functions) {
//					for(Function accessed : callingFunction.getCallsFunction()) {
//						putOrAddToMap(results, callingFunction, accessed, function);
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link IECMethodImplementation}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link GlobalVariable}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param globalVariables The {@link GlobalVariable}s to look up.
//	 * @return A map of all {@link IECMethodImplementation}s and which {@link GlobalVariable}s they are accessing.
//	 */
//	public static Map<IECMethod, Set<GlobalVariable>> lookUpMethodsOfGlobalVariable(
//			IECArchitectureVersion version, Collection<GlobalVariable> globalVariables) {
//		Map<IECMethod, Set<GlobalVariable>> results = new HashMap<IECMethod, Set<GlobalVariable>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for (FunctionBlock functionBlock : program.getDeclaresFunctionBlock()) {
//				for(IECMethod method : functionBlock.getHasMethod()) {
//					for(GlobalVariable globVar : globalVariables) {
//						for(GlobalVariable accessed : method.getAccessesGlobalVariable()) {
//							putOrAddToMap(results, method, accessed, globVar);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link IECInterface} which access the given {@link GlobalVariable}s.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param globalVariables The {@link GlobalVariable}s to look up.
//	 * @return A map of all {@link FunctionBlock}s and which {@link GlobalVariable}s they are accessing.
//	 */
//	public static Map<FunctionBlock, Set<GlobalVariable>> lookUpFunctionBlocksOfGlobalVariable(
//			IECArchitectureVersion version, Collection<GlobalVariable> globalVariables) {
//		Map<FunctionBlock, Set<GlobalVariable>> results = new HashMap<FunctionBlock, Set<GlobalVariable>>();
//		for (Program program : version.getConfiguration().getContainsProgram()) {
//			for (FunctionBlock functionBlock : program.getDeclaresFunctionBlock()) {
//				for(GlobalVariable globVar : globalVariables) {
//					for(GlobalVariable accessed : functionBlock.getAccessesGlobalVariable()) {
//						putOrAddToMap(results, functionBlock, accessed, globVar);
//					}
//				}
//			} 
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up the {@link Program}s of the {@link IECArchitectureVersion} which access the given {@link GlobalVariable}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param globalVariables The {@link GlobalVariable}s to look up.
//	 * @return The {@link Program}s which access the {@link GlobalVariable}s in a Map.
//	 */
//	public static Map<Program, Set<GlobalVariable>> lookUpProgramsOfGlobalVariable(
//			IECArchitectureVersion version, Collection<GlobalVariable> globalVariables) {
//		Map<Program, Set<GlobalVariable>> results = new HashMap<Program, Set<GlobalVariable>>();
//		for(Program prog : version.getConfiguration().getContainsProgram()) {
//			for(GlobalVariable toCompare : globalVariables) {
//				for(GlobalVariable accessed : prog.getAccessesGlobalVariable()) {
//					putOrAddToMap(results, prog, accessed, toCompare);
//				}
//				for(GlobalVariable declared : prog.getDeclaresGlobalVariable()) {
//					putOrAddToMap(results, prog, declared, toCompare);
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up the {@link Configuration} of the {@link IECArchitectureVersion} which access the given {@link GlobalVariable}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param globalVariables The {@link GlobalVariable}s to look up.
//	 * @return The {@link Configuration} which accesses the {@link GlobalVariable}s in a Map.
//	 */
//	public static Map<Configuration, Set<GlobalVariable>> lookUpConfigurationOfGlobalVariable(
//			IECArchitectureVersion version, Collection<GlobalVariable> globalVariables) {
//		Map<Configuration, Set<GlobalVariable>> results = new HashMap<Configuration, Set<GlobalVariable>>();
//		Configuration config = version.getConfiguration();
//		for(GlobalVariable toCompare : globalVariables) {
//			for(GlobalVariable accesed : config.getAccessesGlobalVariable()) {
//				putOrAddToMap(results, config, accesed, toCompare);
//			}
//			for(GlobalVariable declared : config.getDeclaresGlobalVariable()) {
//				putOrAddToMap(results, config, declared, toCompare);
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up the {@link IECInterface} of the {@link IECArchitectureVersion} which access the given {@link IECMethod}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param method The {@link IECMethod}s to look up.
//	 * @return The {@link IECInterface}s which access the {@link IECMethod}s in a Map.
//	 */
//	public static Map<IECInterface, Set<IECAbstractMethod>> lookUpInterfaceOfMethod(
//			IECArchitectureVersion version, Collection<IECAbstractMethod> methods) {
//		Map<IECInterface, Set<IECAbstractMethod>> results = new HashMap<IECInterface, Set<IECAbstractMethod>>();
//		for(IECInterface iecInterface : version.getConfiguration().getInterfaces().getContainsInterface()) {
//			for(IECAbstractMethod toCompare: methods) {
//				for(IECAbstractMethod method: iecInterface.getHasMethod()) {
//					putOrAddToMap(results, iecInterface, method, toCompare);
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up the {@link IECInterface} of the {@link IECArchitectureVersion} which access the given {@link IECMethod}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param method The {@link IECMethod}s to look up.
//	 * @return The {@link IECInterface}s which access the {@link IECMethod}s in a Map.
//	 */
//	public static Map<IECInterface, Set<IECAbstractProperty>> lookUpInterfaceOfProperty(
//			IECArchitectureVersion version, Collection<IECAbstractProperty> properties) {
//		Map<IECInterface, Set<IECAbstractProperty>> results = new HashMap<IECInterface, Set<IECAbstractProperty>>();
//		for(IECInterface iecInterface : version.getConfiguration().getInterfaces().getContainsInterface()) {
//			for(IECAbstractProperty toCompare: properties) {
//				for(IECAbstractProperty property: iecInterface.getHasProperty()) {
//					putOrAddToMap(results, iecInterface, property, toCompare);
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link FunctionBlock} which access the given {@link IECMethodImplementation}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param methods The {@link IECMethodImplementation}s to look up.
//	 * @return A map of all {@link FunctionBlock}s and which {@link IECMethodImplementation}s they are accessing.
//	 */
//	public static Map<FunctionBlock, Set<IECMethod>> lookUpFunctionBlocksOfMethodImplementation(
//			IECArchitectureVersion version, Collection<IECMethod> methods) {
//		Map<FunctionBlock, Set<IECMethod>> results = new HashMap<FunctionBlock, Set<IECMethod>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency fbDependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(IECMethod compared : methods) {
//					if(fbDependency.getRequiredResource() instanceof IECMethod) {
//						putOrAddToMap(results, fbDependency.getProvidedFunctionBlock(), (IECMethod)fbDependency.getRequiredResource(), compared);
//					}
//				}
//			}
//		}
//		return results;
//	}
//
//	/**
//	 * Looks up all {@link IECMethodImplementation}s of the {@link IECArchitectureVersion}s {@link IECMethodImplementation} which access the given {@link IECMethodImplementation}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param methods The {@link IECMethodImplementation}s to look up.
//	 * @return A map of all {@link IECMethodImplementation}s and which {@link IECMethodImplementation}s they are accessing.
//	 */
//	public static Map<IECMethod, Set<IECMethod>> lookUpMethodsOfMethodImplementation(
//			IECArchitectureVersion version, Collection<IECMethod> methods) {
//		Map<IECMethod, Set<IECMethod>> results = new HashMap<IECMethod, Set<IECMethod>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency fbDependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(MethodDependency methodDependency : fbDependency.getHasMethodDependency()) {
//					for(IECMethod compared : methods) {
//						if(methodDependency.getRequiredResource() instanceof IECMethod) {
//							putOrAddToMap(results, methodDependency.getProvidedMethod(), (IECMethod)fbDependency.getRequiredResource(), compared);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up the {@link Program} of the {@link IECArchitectureVersion} which access the given {@link IECMethodImplementation}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param method The {@link IECMethodImplementation}s to look up.
//	 * @return The {@link Program}s which access the {@link IECMethodImplementation}s in a Map.
//	 */
//	public static Map<Program, Set<IECMethod>> lookUpProgramsOfMethodImplementation(
//			IECArchitectureVersion version, Collection<IECMethod> methods) {
//		Map<Program, Set<IECMethod>> results = new HashMap<Program, Set<IECMethod>>();
//		for(Program prog : version.getConfiguration().getContainsProgram()) {
//			for(IECMethod toCompare: methods) {
//				for(IECMethod property: prog.getCallsMethod()) {
//					putOrAddToMap(results, prog, property, toCompare);
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up all {@link IECMethodImplementation}s of the {@link IECArchitectureVersion}s {@link IECMethodImplementation} which access the given {@link IECPropertyImplementation}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param properties The {@link IECPropertyImplementation}s to look up.
//	 * @return The {@link IECMethodImplementation}s which access the {@link IECPropertyImplementation}s in a Map.
//	 */
//	public static Map<IECMethod, Set<IECProperty>> lookUpMethodImplementaionsOfPropertyImplementation(
//			IECArchitectureVersion version, Collection<IECProperty> properties) {
//		Map<IECMethod, Set<IECProperty>> results = new HashMap<IECMethod, Set<IECProperty>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency fbDependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(MethodDependency methodDependency : fbDependency.getHasMethodDependency()) {
//					for(IECProperty compared : properties) {
//						if(methodDependency.getRequiredResource() instanceof IECMethod) {
//							putOrAddToMap(results, methodDependency.getProvidedMethod(), (IECProperty)fbDependency.getRequiredResource(), compared);
//						}
//					}
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up all {@link FunctionBlock}s of the {@link IECArchitectureVersion}s {@link IECMethodImplementation} which access the given {@link IECPropertyImplementation}s via ComponentInternalDependencies.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param properties The {@link IECPropertyImplementation}s to look up.
//	 * @return The {@link FunctionBlock}s which access the {@link IECPropertyImplementation}s in a Map.
//	 */
//	public static Map<FunctionBlock, Set<IECProperty>> lookUpFunctionBlocksOfPropertyImplementation(
//			IECArchitectureVersion version, Collection<IECProperty> properties) {
//		Map<FunctionBlock, Set<IECProperty>> results = new HashMap<FunctionBlock, Set<IECProperty>>();
//		if(version.getComponentInternalDependencyRepository() != null) {
//			for(FunctionblockDependency fbDependency : version.getComponentInternalDependencyRepository().getHasFunctionblockDependency()) {
//				for(IECProperty compared : properties) {
//					if(fbDependency.getRequiredResource() instanceof IECMethod) {
//						putOrAddToMap(results, fbDependency.getProvidedFunctionBlock(), (IECProperty)fbDependency.getRequiredResource(), compared);
//					}
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up the {@link Program} of the {@link IECArchitectureVersion} which access the given {@link IECMethodImplementation}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param method The {@link IECMethodImplementation}s to look up.
//	 * @return The {@link Program}s which access the {@link IECMethodImplementation}s in a Map.
//	 */
//	public static Map<Program, Set<IECProperty>> lookUpProgramsOfPropertyImplementation(
//			IECArchitectureVersion version, Collection<IECProperty> properties) {
//		Map<Program, Set<IECProperty>> results = new HashMap<Program, Set<IECProperty>>();
//		for(Program prog : version.getConfiguration().getContainsProgram()) {
//			for(IECProperty toCompare: properties) {
//				for(IECProperty property: prog.getAccessesProperty()) {
//					putOrAddToMap(results, prog, property, toCompare);
//				}
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up the {@link Configuration} of the {@link IECArchitectureVersion} which access the given {@link IECMethodImplementation}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param method The {@link IECMethodImplementation}s to look up.
//	 * @return The {@link Configuration} which accesses the {@link IECMethodImplementation}s in a Map.
//	 */
//	public static Map<Configuration, Set<IECProperty>> lookUpConfigurationsOfPropertyImplementation(
//			IECArchitectureVersion version, Collection<IECProperty> properties) {
//		Map<Configuration, Set<IECProperty>> results = new HashMap<Configuration, Set<IECProperty>>();
//		for(IECProperty toCompare: properties) {
//			for(IECProperty property: version.getConfiguration().getAccessesProperty()) {
//				putOrAddToMap(results, version.getConfiguration(), property, toCompare);
//			}
//		}
//		return results;
//	}
//	
//	/**
//	 * Looks up the {@link Configuration} of the {@link IECArchitectureVersion} which access the given {@link Program}s and lists it in a Map.
//	 * @param version The current {@link IECArchitectureVersion}.
//	 * @param programs The {@link Program}s to look up.
//	 * @return The {@link Configuration} which accesses the {@link Program}s in a Map.
//	 */
//	public static Map<Configuration, Set<Program>> lookUpConfigurationOfProgram(
//			IECArchitectureVersion version, Collection<Program> programs) {
//		Map<Configuration, Set<Program>> results = new HashMap<Configuration, Set<Program>>();
//		for(Program toCompare: programs) {
//			for(Program property: version.getConfiguration().getContainsProgram()) {
//				putOrAddToMap(results, version.getConfiguration(), property, toCompare);
//			}
//		}
//		return results;
//	}
//	
//	private static <X extends IECComponent, Y extends IECComponent> void putOrAddToMap(Map<X, Set<Y>> map, X key, Y accessedValue, Y comparedValue) {
//		if (accessedValue.getId().equals(comparedValue.getId())) {
//			MapUtil.putOrAddToMap(map, key, comparedValue);
//		}
//	}
//	
//	private static <X extends IECComponent, Y extends IECComponent> void addToMap(Map<X, Set<Y>> map, X key, Y accessedValue, Y comparedValue) {
//		if (accessedValue.getId().equals(comparedValue.getId())) {
//			Set<Y> markedGlobalVariables = results.get(key);
//			if((markedGlobalVariables != null) && !markedGlobalVariables.isEmpty()) {
//				markedGlobalVariables.add(accessedValue);
//				MapUtil.putOrAddToMap(map, key, markedGlobalVariables);
//			} else {
//				MapUtil.putOrAddToMap(map, key, comparedValue);
//			}
//		}
//	}
}

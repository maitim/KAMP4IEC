/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.modificationmarks;

import edu.kit.ipd.sdq.kamp.model.modificationmarks.ChangePropagationStep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEC Change Propagation Due To Data Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getFunctionBlockModifications <em>Function Block Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getGlobalVariableModifications <em>Global Variable Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getFunctionModifications <em>Function Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getInterfaceModifications <em>Interface Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getMethodModifications <em>Method Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getPropertyModifications <em>Property Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getProgramModifications <em>Program Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getConfigurationModifications <em>Configuration Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECChangePropagationDueToDataDependency#getEnumModifications <em>Enum Modifications</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency()
 * @model
 * @generated
 */
public interface IECChangePropagationDueToDataDependency extends ChangePropagationStep {
	/**
	 * Returns the value of the '<em><b>Function Block Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Block Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Block Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_FunctionBlockModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyFunctionBlock> getFunctionBlockModifications();

	/**
	 * Returns the value of the '<em><b>Global Variable Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyGlobalVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Variable Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Variable Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_GlobalVariableModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyGlobalVariable> getGlobalVariableModifications();

	/**
	 * Returns the value of the '<em><b>Function Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_FunctionModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyFunction> getFunctionModifications();

	/**
	 * Returns the value of the '<em><b>Interface Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_InterfaceModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyInterface> getInterfaceModifications();

	/**
	 * Returns the value of the '<em><b>Method Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_MethodModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyMethod> getMethodModifications();

	/**
	 * Returns the value of the '<em><b>Property Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_PropertyModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyProperty> getPropertyModifications();

	/**
	 * Returns the value of the '<em><b>Program Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyProgram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Program Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Program Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_ProgramModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyProgram> getProgramModifications();

	/**
	 * Returns the value of the '<em><b>Configuration Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_ConfigurationModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyConfiguration> getConfigurationModifications();

	/**
	 * Returns the value of the '<em><b>Enum Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECChangePropagationDueToDataDependency_EnumModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyEnum> getEnumModifications();

} // IECChangePropagationDueToDataDependency
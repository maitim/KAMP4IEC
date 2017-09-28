/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.modificationmarks;

import edu.kit.ipd.sdq.kamp.model.modificationmarks.AbstractSeedModifications;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEC Seed Modifications</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getGlobalVariableModifications <em>Global Variable Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getInterfaceModifications <em>Interface Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getAbstractMethodModifications <em>Abstract Method Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getAbstractPropertyModifications <em>Abstract Property Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getFunctionBlockModifications <em>Function Block Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getMethodModifications <em>Method Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications#getPropertyModifications <em>Property Modifications</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications()
 * @model
 * @generated
 */
public interface IECSeedModifications extends AbstractSeedModifications {
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
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_GlobalVariableModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyGlobalVariable> getGlobalVariableModifications();

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
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_InterfaceModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyInterface> getInterfaceModifications();

	/**
	 * Returns the value of the '<em><b>Abstract Method Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyAbstractMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Method Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Method Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_AbstractMethodModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyAbstractMethod> getAbstractMethodModifications();

	/**
	 * Returns the value of the '<em><b>Abstract Property Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyAbstractProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Property Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Property Modifications</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_AbstractPropertyModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyAbstractProperty> getAbstractPropertyModifications();

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
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_FunctionBlockModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyFunctionBlock> getFunctionBlockModifications();

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
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_MethodModifications()
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
	 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage#getIECSeedModifications_PropertyModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECModifyProperty> getPropertyModifications();

} // IECSeedModifications

/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Staff Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getPersonList <em>Person List</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getRoleList <em>Role List</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getStaffSpecification()
 * @model
 * @generated
 */
public interface StaffSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsRepository#getStaffSpecification <em>Staff Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(FieldOfActivityAnnotationsRepository)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getStaffSpecification_Parent()
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsRepository#getStaffSpecification
	 * @model opposite="staffSpecification" required="true" transient="false"
	 * @generated
	 */
	FieldOfActivityAnnotationsRepository getParent();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(FieldOfActivityAnnotationsRepository value);

	/**
	 * Returns the value of the '<em><b>Person List</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.PersonList#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person List</em>' containment reference.
	 * @see #setPersonList(PersonList)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getStaffSpecification_PersonList()
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.PersonList#getParent
	 * @model opposite="parent" containment="true" required="true"
	 * @generated
	 */
	PersonList getPersonList();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getPersonList <em>Person List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person List</em>' containment reference.
	 * @see #getPersonList()
	 * @generated
	 */
	void setPersonList(PersonList value);

	/**
	 * Returns the value of the '<em><b>Role List</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.RoleList#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role List</em>' containment reference.
	 * @see #setRoleList(RoleList)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getStaffSpecification_RoleList()
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.RoleList#getParent
	 * @model opposite="parent" containment="true" required="true"
	 * @generated
	 */
	RoleList getRoleList();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.StaffSpecification#getRoleList <em>Role List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role List</em>' containment reference.
	 * @see #getRoleList()
	 * @generated
	 */
	void setRoleList(RoleList value);

} // StaffSpecification

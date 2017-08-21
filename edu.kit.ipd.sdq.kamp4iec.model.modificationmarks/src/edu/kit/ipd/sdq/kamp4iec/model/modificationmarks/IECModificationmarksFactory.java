/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.modificationmarks;

import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECComponent;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage
 * @generated
 */
public interface IECModificationmarksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IECModificationmarksFactory eINSTANCE = edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl.IECModificationmarksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>IEC Modification Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modification Repository</em>'.
	 * @generated
	 */
	IECModificationRepository createIECModificationRepository();

	/**
	 * Returns a new object of class '<em>IEC Seed Modifications</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Seed Modifications</em>'.
	 * @generated
	 */
	IECSeedModifications createIECSeedModifications();

	/**
	 * Returns a new object of class '<em>IEC Change Propagation Due To Data Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Change Propagation Due To Data Dependency</em>'.
	 * @generated
	 */
	IECChangePropagationDueToDataDependency createIECChangePropagationDueToDataDependency();

	/**
	 * Returns a new object of class '<em>IEC Modify Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Element</em>'.
	 * @generated
	 */
	<T extends IECComponent> IECModifyElement<T> createIECModifyElement();

	/**
	 * Returns a new object of class '<em>IEC Modify Global Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Global Variable</em>'.
	 * @generated
	 */
	IECModifyGlobalVariable createIECModifyGlobalVariable();

	/**
	 * Returns a new object of class '<em>IEC Modify Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Function Block</em>'.
	 * @generated
	 */
	IECModifyFunctionBlock createIECModifyFunctionBlock();

	/**
	 * Returns a new object of class '<em>IEC Modify Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Function</em>'.
	 * @generated
	 */
	IECModifyFunction createIECModifyFunction();

	/**
	 * Returns a new object of class '<em>IEC Modify Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Interface</em>'.
	 * @generated
	 */
	IECModifyInterface createIECModifyInterface();

	/**
	 * Returns a new object of class '<em>IEC Modify Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Method</em>'.
	 * @generated
	 */
	IECModifyMethod createIECModifyMethod();

	/**
	 * Returns a new object of class '<em>IEC Modify Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Property</em>'.
	 * @generated
	 */
	IECModifyProperty createIECModifyProperty();

	/**
	 * Returns a new object of class '<em>IEC Modify Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Program</em>'.
	 * @generated
	 */
	IECModifyProgram createIECModifyProgram();

	/**
	 * Returns a new object of class '<em>IEC Modify Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Enum</em>'.
	 * @generated
	 */
	IECModifyEnum createIECModifyEnum();

	/**
	 * Returns a new object of class '<em>IEC Modify Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IEC Modify Configuration</em>'.
	 * @generated
	 */
	IECModifyConfiguration createIECModifyConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IECModificationmarksPackage getIECModificationmarksPackage();

} //IECModificationmarksFactory
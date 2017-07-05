/**
 */
package Modifikationmarks.impl;

import Modifikationmarks.*;

import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Element;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifikationmarksFactoryImpl extends EFactoryImpl implements ModifikationmarksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifikationmarksFactory init() {
		try {
			ModifikationmarksFactory theModifikationmarksFactory = (ModifikationmarksFactory)EPackage.Registry.INSTANCE.getEFactory(ModifikationmarksPackage.eNS_URI);
			if (theModifikationmarksFactory != null) {
				return theModifikationmarksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifikationmarksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifikationmarksFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModifikationmarksPackage.KAMP4IEC_MODIFICATION_REPOSITORY: return createKAMP4IECModificationRepository();
			case ModifikationmarksPackage.KAMP4IEC_SEED_MODIFICATIONS: return createKAMP4IECSeedModifications();
			case ModifikationmarksPackage.CHANGE_PROPAGATION_DUE_TO_DATA_DEPLOY: return createChangePropagationDueToDataDeploy();
			case ModifikationmarksPackage.MODIFY_ELEMENT: return createModifyElement();
			case ModifikationmarksPackage.MODIFY_GLOBAL_VARIABLE: return createModifyGlobalVariable();
			case ModifikationmarksPackage.MODIFY_FUNCTION_BLOCK: return createModifyFunctionBlock();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KAMP4IECModificationRepository createKAMP4IECModificationRepository() {
		KAMP4IECModificationRepositoryImpl kamp4IECModificationRepository = new KAMP4IECModificationRepositoryImpl();
		return kamp4IECModificationRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KAMP4IECSeedModifications createKAMP4IECSeedModifications() {
		KAMP4IECSeedModificationsImpl kamp4IECSeedModifications = new KAMP4IECSeedModificationsImpl();
		return kamp4IECSeedModifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePropagationDueToDataDeploy createChangePropagationDueToDataDeploy() {
		ChangePropagationDueToDataDeployImpl changePropagationDueToDataDeploy = new ChangePropagationDueToDataDeployImpl();
		return changePropagationDueToDataDeploy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Element> ModifyElement<T> createModifyElement() {
		ModifyElementImpl<T> modifyElement = new ModifyElementImpl<T>();
		return modifyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifyGlobalVariable createModifyGlobalVariable() {
		ModifyGlobalVariableImpl modifyGlobalVariable = new ModifyGlobalVariableImpl();
		return modifyGlobalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifyFunctionBlock createModifyFunctionBlock() {
		ModifyFunctionBlockImpl modifyFunctionBlock = new ModifyFunctionBlockImpl();
		return modifyFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifikationmarksPackage getModifikationmarksPackage() {
		return (ModifikationmarksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifikationmarksPackage getPackage() {
		return ModifikationmarksPackage.eINSTANCE;
	}

} //ModifikationmarksFactoryImpl

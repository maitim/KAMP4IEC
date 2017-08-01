/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl;

import edu.kit.ipd.sdq.kamp.model.modificationmarks.impl.AbstractSeedModificationsImpl;

import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyFunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyGlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECSeedModifications;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IEC Seed Modifications</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl.IECSeedModificationsImpl#getGlobalVariableModifications <em>Global Variable Modifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl.IECSeedModificationsImpl#getFunctionblockModifications <em>Functionblock Modifications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IECSeedModificationsImpl extends AbstractSeedModificationsImpl implements IECSeedModifications {
	/**
	 * The cached value of the '{@link #getGlobalVariableModifications() <em>Global Variable Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalVariableModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<IECModifyGlobalVariable> globalVariableModifications;

	/**
	 * The cached value of the '{@link #getFunctionblockModifications() <em>Functionblock Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionblockModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<IECModifyFunctionBlock> functionblockModifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECSeedModificationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IECModificationmarksPackage.Literals.IEC_SEED_MODIFICATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IECModifyGlobalVariable> getGlobalVariableModifications() {
		if (globalVariableModifications == null) {
			globalVariableModifications = new EObjectContainmentEList<IECModifyGlobalVariable>(IECModifyGlobalVariable.class, this, IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS);
		}
		return globalVariableModifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IECModifyFunctionBlock> getFunctionblockModifications() {
		if (functionblockModifications == null) {
			functionblockModifications = new EObjectContainmentEList<IECModifyFunctionBlock>(IECModifyFunctionBlock.class, this, IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS);
		}
		return functionblockModifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS:
				return ((InternalEList<?>)getGlobalVariableModifications()).basicRemove(otherEnd, msgs);
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS:
				return ((InternalEList<?>)getFunctionblockModifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS:
				return getGlobalVariableModifications();
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS:
				return getFunctionblockModifications();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS:
				getGlobalVariableModifications().clear();
				getGlobalVariableModifications().addAll((Collection<? extends IECModifyGlobalVariable>)newValue);
				return;
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS:
				getFunctionblockModifications().clear();
				getFunctionblockModifications().addAll((Collection<? extends IECModifyFunctionBlock>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS:
				getGlobalVariableModifications().clear();
				return;
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS:
				getFunctionblockModifications().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__GLOBAL_VARIABLE_MODIFICATIONS:
				return globalVariableModifications != null && !globalVariableModifications.isEmpty();
			case IECModificationmarksPackage.IEC_SEED_MODIFICATIONS__FUNCTIONBLOCK_MODIFICATIONS:
				return functionblockModifications != null && !functionblockModifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IECSeedModificationsImpl

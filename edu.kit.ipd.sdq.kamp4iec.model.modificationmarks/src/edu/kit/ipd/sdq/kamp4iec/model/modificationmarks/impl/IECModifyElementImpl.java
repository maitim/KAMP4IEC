/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.impl;

import edu.kit.ipd.sdq.kamp.model.modificationmarks.impl.AbstractModificationImpl;

import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECComponent;

import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModificationmarksPackage;
import edu.kit.ipd.sdq.kamp4iec.model.modificationmarks.IECModifyElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IEC Modify Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class IECModifyElementImpl<T extends IECComponent> extends AbstractModificationImpl<T, EObject> implements IECModifyElement<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECModifyElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IECModificationmarksPackage.Literals.IEC_MODIFY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setAffectedElement(T newAffectedElement) {
		super.setAffectedElement(newAffectedElement);
	}

} //IECModifyElementImpl
/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl;

import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.AcceptanceTestCase;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.AcceptanceTestCaseAggregation;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCase;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.TestSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.UnitTestCase;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.UnitTestCaseAggregation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getUnitTestCases <em>Unit Test Cases</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getAcceptanceTestCases <em>Acceptance Test Cases</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getIntegrationTestCases <em>Integration Test Cases</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getUnitTestCaseAggregations <em>Unit Test Case Aggregations</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getAcceptanceTestCaseAggregations <em>Acceptance Test Case Aggregations</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.TestSpecificationImpl#getIntegrationTestCaseAggregations <em>Integration Test Case Aggregations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSpecificationImpl extends MinimalEObjectImpl.Container implements TestSpecification {
	/**
	 * The cached value of the '{@link #getUnitTestCases() <em>Unit Test Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitTestCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitTestCase> unitTestCases;

	/**
	 * The cached value of the '{@link #getAcceptanceTestCases() <em>Acceptance Test Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptanceTestCases()
	 * @generated
	 * @ordered
	 */
	protected EList<AcceptanceTestCase> acceptanceTestCases;

	/**
	 * The cached value of the '{@link #getIntegrationTestCases() <em>Integration Test Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrationTestCases()
	 * @generated
	 * @ordered
	 */
	protected EList<IntegrationTestCase> integrationTestCases;

	/**
	 * The cached value of the '{@link #getUnitTestCaseAggregations() <em>Unit Test Case Aggregations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitTestCaseAggregations()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitTestCaseAggregation> unitTestCaseAggregations;

	/**
	 * The cached value of the '{@link #getAcceptanceTestCaseAggregations() <em>Acceptance Test Case Aggregations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptanceTestCaseAggregations()
	 * @generated
	 * @ordered
	 */
	protected EList<AcceptanceTestCaseAggregation> acceptanceTestCaseAggregations;

	/**
	 * The cached value of the '{@link #getIntegrationTestCaseAggregations() <em>Integration Test Case Aggregations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrationTestCaseAggregations()
	 * @generated
	 * @ordered
	 */
	protected EList<IntegrationTestCaseAggregation> integrationTestCaseAggregations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FieldOfActivityAnnotationsPackage.Literals.TEST_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldOfActivityAnnotationsRepository getParent() {
		if (eContainerFeatureID() != FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT) return null;
		return (FieldOfActivityAnnotationsRepository)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(FieldOfActivityAnnotationsRepository newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(FieldOfActivityAnnotationsRepository newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FieldOfActivityAnnotationsPackage.FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION, FieldOfActivityAnnotationsRepository.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitTestCase> getUnitTestCases() {
		if (unitTestCases == null) {
			unitTestCases = new EObjectContainmentWithInverseEList<UnitTestCase>(UnitTestCase.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES, FieldOfActivityAnnotationsPackage.UNIT_TEST_CASE__PARENT);
		}
		return unitTestCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AcceptanceTestCase> getAcceptanceTestCases() {
		if (acceptanceTestCases == null) {
			acceptanceTestCases = new EObjectContainmentWithInverseEList<AcceptanceTestCase>(AcceptanceTestCase.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES, FieldOfActivityAnnotationsPackage.ACCEPTANCE_TEST_CASE__PARENT);
		}
		return acceptanceTestCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegrationTestCase> getIntegrationTestCases() {
		if (integrationTestCases == null) {
			integrationTestCases = new EObjectContainmentWithInverseEList<IntegrationTestCase>(IntegrationTestCase.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES, FieldOfActivityAnnotationsPackage.INTEGRATION_TEST_CASE__PARENT);
		}
		return integrationTestCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitTestCaseAggregation> getUnitTestCaseAggregations() {
		if (unitTestCaseAggregations == null) {
			unitTestCaseAggregations = new EObjectContainmentWithInverseEList<UnitTestCaseAggregation>(UnitTestCaseAggregation.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS, FieldOfActivityAnnotationsPackage.UNIT_TEST_CASE_AGGREGATION__PARENT);
		}
		return unitTestCaseAggregations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AcceptanceTestCaseAggregation> getAcceptanceTestCaseAggregations() {
		if (acceptanceTestCaseAggregations == null) {
			acceptanceTestCaseAggregations = new EObjectContainmentWithInverseEList<AcceptanceTestCaseAggregation>(AcceptanceTestCaseAggregation.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS, FieldOfActivityAnnotationsPackage.ACCEPTANCE_TEST_CASE_AGGREGATION__PARENT);
		}
		return acceptanceTestCaseAggregations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegrationTestCaseAggregation> getIntegrationTestCaseAggregations() {
		if (integrationTestCaseAggregations == null) {
			integrationTestCaseAggregations = new EObjectContainmentWithInverseEList<IntegrationTestCaseAggregation>(IntegrationTestCaseAggregation.class, this, FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS, FieldOfActivityAnnotationsPackage.INTEGRATION_TEST_CASE_AGGREGATION__PARENT);
		}
		return integrationTestCaseAggregations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((FieldOfActivityAnnotationsRepository)otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnitTestCases()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAcceptanceTestCases()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntegrationTestCases()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnitTestCaseAggregations()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAcceptanceTestCaseAggregations()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIntegrationTestCaseAggregations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				return basicSetParent(null, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				return ((InternalEList<?>)getUnitTestCases()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				return ((InternalEList<?>)getAcceptanceTestCases()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				return ((InternalEList<?>)getIntegrationTestCases()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<?>)getUnitTestCaseAggregations()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<?>)getAcceptanceTestCaseAggregations()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				return ((InternalEList<?>)getIntegrationTestCaseAggregations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				return eInternalContainer().eInverseRemove(this, FieldOfActivityAnnotationsPackage.FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION, FieldOfActivityAnnotationsRepository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				return getParent();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				return getUnitTestCases();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				return getAcceptanceTestCases();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				return getIntegrationTestCases();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				return getUnitTestCaseAggregations();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				return getAcceptanceTestCaseAggregations();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				return getIntegrationTestCaseAggregations();
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
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				setParent((FieldOfActivityAnnotationsRepository)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				getUnitTestCases().clear();
				getUnitTestCases().addAll((Collection<? extends UnitTestCase>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				getAcceptanceTestCases().clear();
				getAcceptanceTestCases().addAll((Collection<? extends AcceptanceTestCase>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				getIntegrationTestCases().clear();
				getIntegrationTestCases().addAll((Collection<? extends IntegrationTestCase>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				getUnitTestCaseAggregations().clear();
				getUnitTestCaseAggregations().addAll((Collection<? extends UnitTestCaseAggregation>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				getAcceptanceTestCaseAggregations().clear();
				getAcceptanceTestCaseAggregations().addAll((Collection<? extends AcceptanceTestCaseAggregation>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				getIntegrationTestCaseAggregations().clear();
				getIntegrationTestCaseAggregations().addAll((Collection<? extends IntegrationTestCaseAggregation>)newValue);
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
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				setParent((FieldOfActivityAnnotationsRepository)null);
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				getUnitTestCases().clear();
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				getAcceptanceTestCases().clear();
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				getIntegrationTestCases().clear();
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				getUnitTestCaseAggregations().clear();
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				getAcceptanceTestCaseAggregations().clear();
				return;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				getIntegrationTestCaseAggregations().clear();
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
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__PARENT:
				return getParent() != null;
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASES:
				return unitTestCases != null && !unitTestCases.isEmpty();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASES:
				return acceptanceTestCases != null && !acceptanceTestCases.isEmpty();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASES:
				return integrationTestCases != null && !integrationTestCases.isEmpty();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__UNIT_TEST_CASE_AGGREGATIONS:
				return unitTestCaseAggregations != null && !unitTestCaseAggregations.isEmpty();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__ACCEPTANCE_TEST_CASE_AGGREGATIONS:
				return acceptanceTestCaseAggregations != null && !acceptanceTestCaseAggregations.isEmpty();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION__INTEGRATION_TEST_CASE_AGGREGATIONS:
				return integrationTestCaseAggregations != null && !integrationTestCaseAggregations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestSpecificationImpl
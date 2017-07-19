/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl;

import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECBuildSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECDeploymentSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECDesignPatternSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECDevelopmentArtefactSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECFieldOfActivityAnnotationsPackage;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECFieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECReleaseSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECStaffSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECTechnologySpecification;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECTestSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getDevelopmentArtefactSpecification <em>Development Artefact Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getBuildSpecification <em>Build Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getTestSpecification <em>Test Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getReleaseSpecification <em>Release Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getDeploymentSpecification <em>Deployment Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getStaffSpecification <em>Staff Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getTechnologySpecification <em>Technology Specification</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.impl.IECFieldOfActivityAnnotationsRepositoryImpl#getDesignPatternSpecification <em>Design Pattern Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IECFieldOfActivityAnnotationsRepositoryImpl extends MinimalEObjectImpl.Container implements IECFieldOfActivityAnnotationsRepository {
	/**
	 * The cached value of the '{@link #getDevelopmentArtefactSpecification() <em>Development Artefact Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevelopmentArtefactSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECDevelopmentArtefactSpecification developmentArtefactSpecification;

	/**
	 * The cached value of the '{@link #getBuildSpecification() <em>Build Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECBuildSpecification buildSpecification;

	/**
	 * The cached value of the '{@link #getTestSpecification() <em>Test Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECTestSpecification testSpecification;

	/**
	 * The cached value of the '{@link #getReleaseSpecification() <em>Release Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECReleaseSpecification releaseSpecification;

	/**
	 * The cached value of the '{@link #getDeploymentSpecification() <em>Deployment Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECDeploymentSpecification deploymentSpecification;

	/**
	 * The cached value of the '{@link #getStaffSpecification() <em>Staff Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaffSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECStaffSpecification staffSpecification;

	/**
	 * The cached value of the '{@link #getTechnologySpecification() <em>Technology Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnologySpecification()
	 * @generated
	 * @ordered
	 */
	protected IECTechnologySpecification technologySpecification;

	/**
	 * The cached value of the '{@link #getDesignPatternSpecification() <em>Design Pattern Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignPatternSpecification()
	 * @generated
	 * @ordered
	 */
	protected IECDesignPatternSpecification designPatternSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECFieldOfActivityAnnotationsRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IECFieldOfActivityAnnotationsPackage.Literals.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECDevelopmentArtefactSpecification getDevelopmentArtefactSpecification() {
		return developmentArtefactSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDevelopmentArtefactSpecification(IECDevelopmentArtefactSpecification newDevelopmentArtefactSpecification, NotificationChain msgs) {
		IECDevelopmentArtefactSpecification oldDevelopmentArtefactSpecification = developmentArtefactSpecification;
		developmentArtefactSpecification = newDevelopmentArtefactSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION, oldDevelopmentArtefactSpecification, newDevelopmentArtefactSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevelopmentArtefactSpecification(IECDevelopmentArtefactSpecification newDevelopmentArtefactSpecification) {
		if (newDevelopmentArtefactSpecification != developmentArtefactSpecification) {
			NotificationChain msgs = null;
			if (developmentArtefactSpecification != null)
				msgs = ((InternalEObject)developmentArtefactSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT, IECDevelopmentArtefactSpecification.class, msgs);
			if (newDevelopmentArtefactSpecification != null)
				msgs = ((InternalEObject)newDevelopmentArtefactSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT, IECDevelopmentArtefactSpecification.class, msgs);
			msgs = basicSetDevelopmentArtefactSpecification(newDevelopmentArtefactSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION, newDevelopmentArtefactSpecification, newDevelopmentArtefactSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECBuildSpecification getBuildSpecification() {
		return buildSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuildSpecification(IECBuildSpecification newBuildSpecification, NotificationChain msgs) {
		IECBuildSpecification oldBuildSpecification = buildSpecification;
		buildSpecification = newBuildSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION, oldBuildSpecification, newBuildSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildSpecification(IECBuildSpecification newBuildSpecification) {
		if (newBuildSpecification != buildSpecification) {
			NotificationChain msgs = null;
			if (buildSpecification != null)
				msgs = ((InternalEObject)buildSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_BUILD_SPECIFICATION__PARENT, IECBuildSpecification.class, msgs);
			if (newBuildSpecification != null)
				msgs = ((InternalEObject)newBuildSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_BUILD_SPECIFICATION__PARENT, IECBuildSpecification.class, msgs);
			msgs = basicSetBuildSpecification(newBuildSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION, newBuildSpecification, newBuildSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECTestSpecification getTestSpecification() {
		return testSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestSpecification(IECTestSpecification newTestSpecification, NotificationChain msgs) {
		IECTestSpecification oldTestSpecification = testSpecification;
		testSpecification = newTestSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION, oldTestSpecification, newTestSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestSpecification(IECTestSpecification newTestSpecification) {
		if (newTestSpecification != testSpecification) {
			NotificationChain msgs = null;
			if (testSpecification != null)
				msgs = ((InternalEObject)testSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_TEST_SPECIFICATION__PARENT, IECTestSpecification.class, msgs);
			if (newTestSpecification != null)
				msgs = ((InternalEObject)newTestSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_TEST_SPECIFICATION__PARENT, IECTestSpecification.class, msgs);
			msgs = basicSetTestSpecification(newTestSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION, newTestSpecification, newTestSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECReleaseSpecification getReleaseSpecification() {
		return releaseSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReleaseSpecification(IECReleaseSpecification newReleaseSpecification, NotificationChain msgs) {
		IECReleaseSpecification oldReleaseSpecification = releaseSpecification;
		releaseSpecification = newReleaseSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION, oldReleaseSpecification, newReleaseSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReleaseSpecification(IECReleaseSpecification newReleaseSpecification) {
		if (newReleaseSpecification != releaseSpecification) {
			NotificationChain msgs = null;
			if (releaseSpecification != null)
				msgs = ((InternalEObject)releaseSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_RELEASE_SPECIFICATION__PARENT, IECReleaseSpecification.class, msgs);
			if (newReleaseSpecification != null)
				msgs = ((InternalEObject)newReleaseSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_RELEASE_SPECIFICATION__PARENT, IECReleaseSpecification.class, msgs);
			msgs = basicSetReleaseSpecification(newReleaseSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION, newReleaseSpecification, newReleaseSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECDeploymentSpecification getDeploymentSpecification() {
		return deploymentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeploymentSpecification(IECDeploymentSpecification newDeploymentSpecification, NotificationChain msgs) {
		IECDeploymentSpecification oldDeploymentSpecification = deploymentSpecification;
		deploymentSpecification = newDeploymentSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION, oldDeploymentSpecification, newDeploymentSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeploymentSpecification(IECDeploymentSpecification newDeploymentSpecification) {
		if (newDeploymentSpecification != deploymentSpecification) {
			NotificationChain msgs = null;
			if (deploymentSpecification != null)
				msgs = ((InternalEObject)deploymentSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_DEPLOYMENT_SPECIFICATION__PARENT, IECDeploymentSpecification.class, msgs);
			if (newDeploymentSpecification != null)
				msgs = ((InternalEObject)newDeploymentSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_DEPLOYMENT_SPECIFICATION__PARENT, IECDeploymentSpecification.class, msgs);
			msgs = basicSetDeploymentSpecification(newDeploymentSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION, newDeploymentSpecification, newDeploymentSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECStaffSpecification getStaffSpecification() {
		return staffSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaffSpecification(IECStaffSpecification newStaffSpecification, NotificationChain msgs) {
		IECStaffSpecification oldStaffSpecification = staffSpecification;
		staffSpecification = newStaffSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION, oldStaffSpecification, newStaffSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaffSpecification(IECStaffSpecification newStaffSpecification) {
		if (newStaffSpecification != staffSpecification) {
			NotificationChain msgs = null;
			if (staffSpecification != null)
				msgs = ((InternalEObject)staffSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_STAFF_SPECIFICATION__PARENT, IECStaffSpecification.class, msgs);
			if (newStaffSpecification != null)
				msgs = ((InternalEObject)newStaffSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_STAFF_SPECIFICATION__PARENT, IECStaffSpecification.class, msgs);
			msgs = basicSetStaffSpecification(newStaffSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION, newStaffSpecification, newStaffSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECTechnologySpecification getTechnologySpecification() {
		return technologySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTechnologySpecification(IECTechnologySpecification newTechnologySpecification, NotificationChain msgs) {
		IECTechnologySpecification oldTechnologySpecification = technologySpecification;
		technologySpecification = newTechnologySpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION, oldTechnologySpecification, newTechnologySpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnologySpecification(IECTechnologySpecification newTechnologySpecification) {
		if (newTechnologySpecification != technologySpecification) {
			NotificationChain msgs = null;
			if (technologySpecification != null)
				msgs = ((InternalEObject)technologySpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_TECHNOLOGY_SPECIFICATION__PARENT, IECTechnologySpecification.class, msgs);
			if (newTechnologySpecification != null)
				msgs = ((InternalEObject)newTechnologySpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_TECHNOLOGY_SPECIFICATION__PARENT, IECTechnologySpecification.class, msgs);
			msgs = basicSetTechnologySpecification(newTechnologySpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION, newTechnologySpecification, newTechnologySpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECDesignPatternSpecification getDesignPatternSpecification() {
		return designPatternSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDesignPatternSpecification(IECDesignPatternSpecification newDesignPatternSpecification, NotificationChain msgs) {
		IECDesignPatternSpecification oldDesignPatternSpecification = designPatternSpecification;
		designPatternSpecification = newDesignPatternSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION, oldDesignPatternSpecification, newDesignPatternSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesignPatternSpecification(IECDesignPatternSpecification newDesignPatternSpecification) {
		if (newDesignPatternSpecification != designPatternSpecification) {
			NotificationChain msgs = null;
			if (designPatternSpecification != null)
				msgs = ((InternalEObject)designPatternSpecification).eInverseRemove(this, IECFieldOfActivityAnnotationsPackage.IEC_DESIGN_PATTERN_SPECIFICATION__PARENT, IECDesignPatternSpecification.class, msgs);
			if (newDesignPatternSpecification != null)
				msgs = ((InternalEObject)newDesignPatternSpecification).eInverseAdd(this, IECFieldOfActivityAnnotationsPackage.IEC_DESIGN_PATTERN_SPECIFICATION__PARENT, IECDesignPatternSpecification.class, msgs);
			msgs = basicSetDesignPatternSpecification(newDesignPatternSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION, newDesignPatternSpecification, newDesignPatternSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				if (developmentArtefactSpecification != null)
					msgs = ((InternalEObject)developmentArtefactSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION, null, msgs);
				return basicSetDevelopmentArtefactSpecification((IECDevelopmentArtefactSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				if (buildSpecification != null)
					msgs = ((InternalEObject)buildSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION, null, msgs);
				return basicSetBuildSpecification((IECBuildSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				if (testSpecification != null)
					msgs = ((InternalEObject)testSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION, null, msgs);
				return basicSetTestSpecification((IECTestSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				if (releaseSpecification != null)
					msgs = ((InternalEObject)releaseSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION, null, msgs);
				return basicSetReleaseSpecification((IECReleaseSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				if (deploymentSpecification != null)
					msgs = ((InternalEObject)deploymentSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION, null, msgs);
				return basicSetDeploymentSpecification((IECDeploymentSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				if (staffSpecification != null)
					msgs = ((InternalEObject)staffSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION, null, msgs);
				return basicSetStaffSpecification((IECStaffSpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				if (technologySpecification != null)
					msgs = ((InternalEObject)technologySpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION, null, msgs);
				return basicSetTechnologySpecification((IECTechnologySpecification)otherEnd, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				if (designPatternSpecification != null)
					msgs = ((InternalEObject)designPatternSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION, null, msgs);
				return basicSetDesignPatternSpecification((IECDesignPatternSpecification)otherEnd, msgs);
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
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				return basicSetDevelopmentArtefactSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				return basicSetBuildSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				return basicSetTestSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				return basicSetReleaseSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				return basicSetDeploymentSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				return basicSetStaffSpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				return basicSetTechnologySpecification(null, msgs);
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				return basicSetDesignPatternSpecification(null, msgs);
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
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				return getDevelopmentArtefactSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				return getBuildSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				return getTestSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				return getReleaseSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				return getDeploymentSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				return getStaffSpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				return getTechnologySpecification();
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				return getDesignPatternSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				setDevelopmentArtefactSpecification((IECDevelopmentArtefactSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				setBuildSpecification((IECBuildSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				setTestSpecification((IECTestSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				setReleaseSpecification((IECReleaseSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				setDeploymentSpecification((IECDeploymentSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				setStaffSpecification((IECStaffSpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				setTechnologySpecification((IECTechnologySpecification)newValue);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				setDesignPatternSpecification((IECDesignPatternSpecification)newValue);
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
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				setDevelopmentArtefactSpecification((IECDevelopmentArtefactSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				setBuildSpecification((IECBuildSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				setTestSpecification((IECTestSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				setReleaseSpecification((IECReleaseSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				setDeploymentSpecification((IECDeploymentSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				setStaffSpecification((IECStaffSpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				setTechnologySpecification((IECTechnologySpecification)null);
				return;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				setDesignPatternSpecification((IECDesignPatternSpecification)null);
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
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION:
				return developmentArtefactSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__BUILD_SPECIFICATION:
				return buildSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TEST_SPECIFICATION:
				return testSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__RELEASE_SPECIFICATION:
				return releaseSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEPLOYMENT_SPECIFICATION:
				return deploymentSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__STAFF_SPECIFICATION:
				return staffSpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__TECHNOLOGY_SPECIFICATION:
				return technologySpecification != null;
			case IECFieldOfActivityAnnotationsPackage.IEC_FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DESIGN_PATTERN_SPECIFICATION:
				return designPatternSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //IECFieldOfActivityAnnotationsRepositoryImpl

/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl;

import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.DevelopmentArtefactSpecification;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.MetadataFile;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.MetadataFileAggregation;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.SourceFile;
import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.SourceFileAggregation;

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
 * An implementation of the model object '<em><b>Development Artefact Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.DevelopmentArtefactSpecificationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.DevelopmentArtefactSpecificationImpl#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.DevelopmentArtefactSpecificationImpl#getSourceFileAggregations <em>Source File Aggregations</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.DevelopmentArtefactSpecificationImpl#getMetadataFiles <em>Metadata Files</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl.DevelopmentArtefactSpecificationImpl#getMetadataFileAggregations <em>Metadata File Aggregations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DevelopmentArtefactSpecificationImpl extends MinimalEObjectImpl.Container implements DevelopmentArtefactSpecification {
	/**
	 * The cached value of the '{@link #getSourceFiles() <em>Source Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceFile> sourceFiles;

	/**
	 * The cached value of the '{@link #getSourceFileAggregations() <em>Source File Aggregations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFileAggregations()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceFileAggregation> sourceFileAggregations;

	/**
	 * The cached value of the '{@link #getMetadataFiles() <em>Metadata Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadataFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<MetadataFile> metadataFiles;

	/**
	 * The cached value of the '{@link #getMetadataFileAggregations() <em>Metadata File Aggregations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadataFileAggregations()
	 * @generated
	 * @ordered
	 */
	protected EList<MetadataFileAggregation> metadataFileAggregations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DevelopmentArtefactSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FieldOfActivityAnnotationsPackage.Literals.DEVELOPMENT_ARTEFACT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldOfActivityAnnotationsRepository getParent() {
		if (eContainerFeatureID() != FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT) return null;
		return (FieldOfActivityAnnotationsRepository)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(FieldOfActivityAnnotationsRepository newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(FieldOfActivityAnnotationsRepository newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FieldOfActivityAnnotationsPackage.FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION, FieldOfActivityAnnotationsRepository.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceFile> getSourceFiles() {
		if (sourceFiles == null) {
			sourceFiles = new EObjectContainmentWithInverseEList<SourceFile>(SourceFile.class, this, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES, FieldOfActivityAnnotationsPackage.SOURCE_FILE__PARENT);
		}
		return sourceFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceFileAggregation> getSourceFileAggregations() {
		if (sourceFileAggregations == null) {
			sourceFileAggregations = new EObjectContainmentWithInverseEList<SourceFileAggregation>(SourceFileAggregation.class, this, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS, FieldOfActivityAnnotationsPackage.SOURCE_FILE_AGGREGATION__PARENT);
		}
		return sourceFileAggregations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetadataFile> getMetadataFiles() {
		if (metadataFiles == null) {
			metadataFiles = new EObjectContainmentWithInverseEList<MetadataFile>(MetadataFile.class, this, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES, FieldOfActivityAnnotationsPackage.METADATA_FILE__PARENT);
		}
		return metadataFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetadataFileAggregation> getMetadataFileAggregations() {
		if (metadataFileAggregations == null) {
			metadataFileAggregations = new EObjectContainmentWithInverseEList<MetadataFileAggregation>(MetadataFileAggregation.class, this, FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS, FieldOfActivityAnnotationsPackage.METADATA_FILE_AGGREGATION__PARENT);
		}
		return metadataFileAggregations;
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((FieldOfActivityAnnotationsRepository)otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceFiles()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceFileAggregations()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetadataFiles()).basicAdd(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetadataFileAggregations()).basicAdd(otherEnd, msgs);
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				return basicSetParent(null, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				return ((InternalEList<?>)getSourceFiles()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				return ((InternalEList<?>)getSourceFileAggregations()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				return ((InternalEList<?>)getMetadataFiles()).basicRemove(otherEnd, msgs);
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				return ((InternalEList<?>)getMetadataFileAggregations()).basicRemove(otherEnd, msgs);
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				return eInternalContainer().eInverseRemove(this, FieldOfActivityAnnotationsPackage.FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY__DEVELOPMENT_ARTEFACT_SPECIFICATION, FieldOfActivityAnnotationsRepository.class, msgs);
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				return getParent();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				return getSourceFiles();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				return getSourceFileAggregations();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				return getMetadataFiles();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				return getMetadataFileAggregations();
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				setParent((FieldOfActivityAnnotationsRepository)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				getSourceFiles().clear();
				getSourceFiles().addAll((Collection<? extends SourceFile>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				getSourceFileAggregations().clear();
				getSourceFileAggregations().addAll((Collection<? extends SourceFileAggregation>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				getMetadataFiles().clear();
				getMetadataFiles().addAll((Collection<? extends MetadataFile>)newValue);
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				getMetadataFileAggregations().clear();
				getMetadataFileAggregations().addAll((Collection<? extends MetadataFileAggregation>)newValue);
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				setParent((FieldOfActivityAnnotationsRepository)null);
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				getSourceFiles().clear();
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				getSourceFileAggregations().clear();
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				getMetadataFiles().clear();
				return;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				getMetadataFileAggregations().clear();
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
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__PARENT:
				return getParent() != null;
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILES:
				return sourceFiles != null && !sourceFiles.isEmpty();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__SOURCE_FILE_AGGREGATIONS:
				return sourceFileAggregations != null && !sourceFileAggregations.isEmpty();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILES:
				return metadataFiles != null && !metadataFiles.isEmpty();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION__METADATA_FILE_AGGREGATIONS:
				return metadataFileAggregations != null && !metadataFileAggregations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DevelopmentArtefactSpecificationImpl
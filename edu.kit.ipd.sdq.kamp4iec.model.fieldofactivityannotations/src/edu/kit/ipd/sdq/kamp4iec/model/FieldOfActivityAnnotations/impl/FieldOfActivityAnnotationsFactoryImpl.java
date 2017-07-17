/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.impl;

import edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class FieldOfActivityAnnotationsFactoryImpl extends EFactoryImpl implements FieldOfActivityAnnotationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FieldOfActivityAnnotationsFactory init() {
		try {
			FieldOfActivityAnnotationsFactory theFieldOfActivityAnnotationsFactory = (FieldOfActivityAnnotationsFactory)EPackage.Registry.INSTANCE.getEFactory(FieldOfActivityAnnotationsPackage.eNS_URI);
			if (theFieldOfActivityAnnotationsFactory != null) {
				return theFieldOfActivityAnnotationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FieldOfActivityAnnotationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldOfActivityAnnotationsFactoryImpl() {
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
			case FieldOfActivityAnnotationsPackage.FIELD_OF_ACTIVITY_ANNOTATIONS_REPOSITORY: return createFieldOfActivityAnnotationsRepository();
			case FieldOfActivityAnnotationsPackage.DEVELOPMENT_ARTEFACT_SPECIFICATION: return createDevelopmentArtefactSpecification();
			case FieldOfActivityAnnotationsPackage.SOURCE_FILE: return createSourceFile();
			case FieldOfActivityAnnotationsPackage.SOURCE_FILE_AGGREGATION: return createSourceFileAggregation();
			case FieldOfActivityAnnotationsPackage.METADATA_FILE: return createMetadataFile();
			case FieldOfActivityAnnotationsPackage.METADATA_FILE_AGGREGATION: return createMetadataFileAggregation();
			case FieldOfActivityAnnotationsPackage.BUILD_SPECIFICATION: return createBuildSpecification();
			case FieldOfActivityAnnotationsPackage.BUILD_CONFIGURATION: return createBuildConfiguration();
			case FieldOfActivityAnnotationsPackage.THIRD_PARTY_COMPONENT_OR_LIBRARY: return createThirdPartyComponentOrLibrary();
			case FieldOfActivityAnnotationsPackage.TEST_SPECIFICATION: return createTestSpecification();
			case FieldOfActivityAnnotationsPackage.RELEASE_SPECIFICATION: return createReleaseSpecification();
			case FieldOfActivityAnnotationsPackage.RELEASE_CONFIGURATION: return createReleaseConfiguration();
			case FieldOfActivityAnnotationsPackage.DEPLOYMENT_SPECIFICATION: return createDeploymentSpecification();
			case FieldOfActivityAnnotationsPackage.RUNTIME_INSTANCE: return createRuntimeInstance();
			case FieldOfActivityAnnotationsPackage.RUNTIME_INSTANCE_AGGREGATION: return createRuntimeInstanceAggregation();
			case FieldOfActivityAnnotationsPackage.UNIT_TEST_CASE: return createUnitTestCase();
			case FieldOfActivityAnnotationsPackage.ACCEPTANCE_TEST_CASE: return createAcceptanceTestCase();
			case FieldOfActivityAnnotationsPackage.INTEGRATION_TEST_CASE: return createIntegrationTestCase();
			case FieldOfActivityAnnotationsPackage.UNIT_TEST_CASE_AGGREGATION: return createUnitTestCaseAggregation();
			case FieldOfActivityAnnotationsPackage.ACCEPTANCE_TEST_CASE_AGGREGATION: return createAcceptanceTestCaseAggregation();
			case FieldOfActivityAnnotationsPackage.INTEGRATION_TEST_CASE_AGGREGATION: return createIntegrationTestCaseAggregation();
			case FieldOfActivityAnnotationsPackage.STAFF_SPECIFICATION: return createStaffSpecification();
			case FieldOfActivityAnnotationsPackage.PERSON_LIST: return createPersonList();
			case FieldOfActivityAnnotationsPackage.PERSON: return createPerson();
			case FieldOfActivityAnnotationsPackage.ROLE_LIST: return createRoleList();
			case FieldOfActivityAnnotationsPackage.DEVELOPER: return createDeveloper();
			case FieldOfActivityAnnotationsPackage.BUILD_CONFIGURATOR: return createBuildConfigurator();
			case FieldOfActivityAnnotationsPackage.TEST_DEVELOPER: return createTestDeveloper();
			case FieldOfActivityAnnotationsPackage.TESTER: return createTester();
			case FieldOfActivityAnnotationsPackage.RELEASE_CONFIGURATOR: return createReleaseConfigurator();
			case FieldOfActivityAnnotationsPackage.DEPLOYER: return createDeployer();
			case FieldOfActivityAnnotationsPackage.DESIGN_PATTERN_SPECIFICATION: return createDesignPatternSpecification();
			case FieldOfActivityAnnotationsPackage.DESIGN_PATTERN_ROLE: return createDesignPatternRole();
			case FieldOfActivityAnnotationsPackage.TECHNOLOGY_SPECIFICATION: return createTechnologySpecification();
			case FieldOfActivityAnnotationsPackage.TECHNOLOGICAL_CORRESPONDENCE: return createTechnologicalCorrespondence();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FieldOfActivityAnnotationsPackage.TECHNOLOGICAL_CORRESPONDENCE_TYPES:
				return createTechnologicalCorrespondenceTypesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FieldOfActivityAnnotationsPackage.TECHNOLOGICAL_CORRESPONDENCE_TYPES:
				return convertTechnologicalCorrespondenceTypesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldOfActivityAnnotationsRepository createFieldOfActivityAnnotationsRepository() {
		FieldOfActivityAnnotationsRepositoryImpl fieldOfActivityAnnotationsRepository = new FieldOfActivityAnnotationsRepositoryImpl();
		return fieldOfActivityAnnotationsRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DevelopmentArtefactSpecification createDevelopmentArtefactSpecification() {
		DevelopmentArtefactSpecificationImpl developmentArtefactSpecification = new DevelopmentArtefactSpecificationImpl();
		return developmentArtefactSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFile createSourceFile() {
		SourceFileImpl sourceFile = new SourceFileImpl();
		return sourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileAggregation createSourceFileAggregation() {
		SourceFileAggregationImpl sourceFileAggregation = new SourceFileAggregationImpl();
		return sourceFileAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataFile createMetadataFile() {
		MetadataFileImpl metadataFile = new MetadataFileImpl();
		return metadataFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataFileAggregation createMetadataFileAggregation() {
		MetadataFileAggregationImpl metadataFileAggregation = new MetadataFileAggregationImpl();
		return metadataFileAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildSpecification createBuildSpecification() {
		BuildSpecificationImpl buildSpecification = new BuildSpecificationImpl();
		return buildSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildConfiguration createBuildConfiguration() {
		BuildConfigurationImpl buildConfiguration = new BuildConfigurationImpl();
		return buildConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThirdPartyComponentOrLibrary createThirdPartyComponentOrLibrary() {
		ThirdPartyComponentOrLibraryImpl thirdPartyComponentOrLibrary = new ThirdPartyComponentOrLibraryImpl();
		return thirdPartyComponentOrLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSpecification createTestSpecification() {
		TestSpecificationImpl testSpecification = new TestSpecificationImpl();
		return testSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseSpecification createReleaseSpecification() {
		ReleaseSpecificationImpl releaseSpecification = new ReleaseSpecificationImpl();
		return releaseSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseConfiguration createReleaseConfiguration() {
		ReleaseConfigurationImpl releaseConfiguration = new ReleaseConfigurationImpl();
		return releaseConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentSpecification createDeploymentSpecification() {
		DeploymentSpecificationImpl deploymentSpecification = new DeploymentSpecificationImpl();
		return deploymentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeInstance createRuntimeInstance() {
		RuntimeInstanceImpl runtimeInstance = new RuntimeInstanceImpl();
		return runtimeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeInstanceAggregation createRuntimeInstanceAggregation() {
		RuntimeInstanceAggregationImpl runtimeInstanceAggregation = new RuntimeInstanceAggregationImpl();
		return runtimeInstanceAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitTestCase createUnitTestCase() {
		UnitTestCaseImpl unitTestCase = new UnitTestCaseImpl();
		return unitTestCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcceptanceTestCase createAcceptanceTestCase() {
		AcceptanceTestCaseImpl acceptanceTestCase = new AcceptanceTestCaseImpl();
		return acceptanceTestCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrationTestCase createIntegrationTestCase() {
		IntegrationTestCaseImpl integrationTestCase = new IntegrationTestCaseImpl();
		return integrationTestCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitTestCaseAggregation createUnitTestCaseAggregation() {
		UnitTestCaseAggregationImpl unitTestCaseAggregation = new UnitTestCaseAggregationImpl();
		return unitTestCaseAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcceptanceTestCaseAggregation createAcceptanceTestCaseAggregation() {
		AcceptanceTestCaseAggregationImpl acceptanceTestCaseAggregation = new AcceptanceTestCaseAggregationImpl();
		return acceptanceTestCaseAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrationTestCaseAggregation createIntegrationTestCaseAggregation() {
		IntegrationTestCaseAggregationImpl integrationTestCaseAggregation = new IntegrationTestCaseAggregationImpl();
		return integrationTestCaseAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaffSpecification createStaffSpecification() {
		StaffSpecificationImpl staffSpecification = new StaffSpecificationImpl();
		return staffSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonList createPersonList() {
		PersonListImpl personList = new PersonListImpl();
		return personList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleList createRoleList() {
		RoleListImpl roleList = new RoleListImpl();
		return roleList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Developer createDeveloper() {
		DeveloperImpl developer = new DeveloperImpl();
		return developer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildConfigurator createBuildConfigurator() {
		BuildConfiguratorImpl buildConfigurator = new BuildConfiguratorImpl();
		return buildConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDeveloper createTestDeveloper() {
		TestDeveloperImpl testDeveloper = new TestDeveloperImpl();
		return testDeveloper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tester createTester() {
		TesterImpl tester = new TesterImpl();
		return tester;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseConfigurator createReleaseConfigurator() {
		ReleaseConfiguratorImpl releaseConfigurator = new ReleaseConfiguratorImpl();
		return releaseConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployer createDeployer() {
		DeployerImpl deployer = new DeployerImpl();
		return deployer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignPatternSpecification createDesignPatternSpecification() {
		DesignPatternSpecificationImpl designPatternSpecification = new DesignPatternSpecificationImpl();
		return designPatternSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignPatternRole createDesignPatternRole() {
		DesignPatternRoleImpl designPatternRole = new DesignPatternRoleImpl();
		return designPatternRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnologySpecification createTechnologySpecification() {
		TechnologySpecificationImpl technologySpecification = new TechnologySpecificationImpl();
		return technologySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnologicalCorrespondence createTechnologicalCorrespondence() {
		TechnologicalCorrespondenceImpl technologicalCorrespondence = new TechnologicalCorrespondenceImpl();
		return technologicalCorrespondence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnologicalCorrespondenceTypes createTechnologicalCorrespondenceTypesFromString(EDataType eDataType, String initialValue) {
		TechnologicalCorrespondenceTypes result = TechnologicalCorrespondenceTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTechnologicalCorrespondenceTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldOfActivityAnnotationsPackage getFieldOfActivityAnnotationsPackage() {
		return (FieldOfActivityAnnotationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FieldOfActivityAnnotationsPackage getPackage() {
		return FieldOfActivityAnnotationsPackage.eINSTANCE;
	}

} //FieldOfActivityAnnotationsFactoryImpl
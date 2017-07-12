/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations;

import org.palladiosimulator.pcm.core.composition.AssemblyConnector;

import org.palladiosimulator.pcm.repository.OperationProvidedRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integration Test Case Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getParent <em>Parent</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getProvidedrole <em>Providedrole</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getAssemblyConnector <em>Assembly Connector</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getIntegrationTestCaseAggregation()
 * @model
 * @generated
 */
public interface IntegrationTestCaseAggregation extends TestCaseAggregation {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.TestSpecification#getIntegrationTestCaseAggregations <em>Integration Test Case Aggregations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TestSpecification)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getIntegrationTestCaseAggregation_Parent()
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.TestSpecification#getIntegrationTestCaseAggregations
	 * @model opposite="integrationTestCaseAggregations" required="true" transient="false"
	 * @generated
	 */
	TestSpecification getParent();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TestSpecification value);

	/**
	 * Returns the value of the '<em><b>Providedrole</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providedrole</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providedrole</em>' reference.
	 * @see #setProvidedrole(OperationProvidedRole)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getIntegrationTestCaseAggregation_Providedrole()
	 * @model
	 * @generated
	 */
	OperationProvidedRole getProvidedrole();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getProvidedrole <em>Providedrole</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providedrole</em>' reference.
	 * @see #getProvidedrole()
	 * @generated
	 */
	void setProvidedrole(OperationProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Connector</em>' reference.
	 * @see #setAssemblyConnector(AssemblyConnector)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.FieldOfActivityAnnotationsPackage#getIntegrationTestCaseAggregation_AssemblyConnector()
	 * @model
	 * @generated
	 */
	AssemblyConnector getAssemblyConnector();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.FieldOfActivityAnnotations.IntegrationTestCaseAggregation#getAssemblyConnector <em>Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Connector</em>' reference.
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	void setAssemblyConnector(AssemblyConnector value);

} // IntegrationTestCaseAggregation

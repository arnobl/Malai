/**
 */
package org.malai.interactiveSystem;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.malai.interactiveSystem.InteractiveSystemFactory
 * @model kind="package"
 * @generated
 */
public interface InteractiveSystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "interactiveSystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.malai.interactiveSystem/1_0_0//org/malai/interactiveSystem";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org_malai_interactiveSystem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InteractiveSystemPackage eINSTANCE = org.malai.interactiveSystem.impl.InteractiveSystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.malai.interactiveSystem.impl.interactiveSystemImpl <em>interactive System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.malai.interactiveSystem.impl.interactiveSystemImpl
	 * @see org.malai.interactiveSystem.impl.InteractiveSystemPackageImpl#getinteractiveSystem()
	 * @generated
	 */
	int INTERACTIVE_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Instruments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM__INSTRUMENTS = 0;

	/**
	 * The feature id for the '<em><b>Interactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM__INTERACTIONS = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM__ACTIONS = 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM__EVENTS = 3;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM__WIDGETS = 4;

	/**
	 * The number of structural features of the '<em>interactive System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIVE_SYSTEM_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.malai.interactiveSystem.interactiveSystem <em>interactive System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>interactive System</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem
	 * @generated
	 */
	EClass getinteractiveSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.malai.interactiveSystem.interactiveSystem#getInstruments <em>Instruments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instruments</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem#getInstruments()
	 * @see #getinteractiveSystem()
	 * @generated
	 */
	EReference getinteractiveSystem_Instruments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.malai.interactiveSystem.interactiveSystem#getInteractions <em>Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interactions</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem#getInteractions()
	 * @see #getinteractiveSystem()
	 * @generated
	 */
	EReference getinteractiveSystem_Interactions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.malai.interactiveSystem.interactiveSystem#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem#getActions()
	 * @see #getinteractiveSystem()
	 * @generated
	 */
	EReference getinteractiveSystem_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.malai.interactiveSystem.interactiveSystem#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem#getEvents()
	 * @see #getinteractiveSystem()
	 * @generated
	 */
	EReference getinteractiveSystem_Events();

	/**
	 * Returns the meta object for the containment reference list '{@link org.malai.interactiveSystem.interactiveSystem#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.malai.interactiveSystem.interactiveSystem#getWidgets()
	 * @see #getinteractiveSystem()
	 * @generated
	 */
	EReference getinteractiveSystem_Widgets();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InteractiveSystemFactory getInteractiveSystemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.malai.interactiveSystem.impl.interactiveSystemImpl <em>interactive System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.malai.interactiveSystem.impl.interactiveSystemImpl
		 * @see org.malai.interactiveSystem.impl.InteractiveSystemPackageImpl#getinteractiveSystem()
		 * @generated
		 */
		EClass INTERACTIVE_SYSTEM = eINSTANCE.getinteractiveSystem();

		/**
		 * The meta object literal for the '<em><b>Instruments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIVE_SYSTEM__INSTRUMENTS = eINSTANCE.getinteractiveSystem_Instruments();

		/**
		 * The meta object literal for the '<em><b>Interactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIVE_SYSTEM__INTERACTIONS = eINSTANCE.getinteractiveSystem_Interactions();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIVE_SYSTEM__ACTIONS = eINSTANCE.getinteractiveSystem_Actions();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIVE_SYSTEM__EVENTS = eINSTANCE.getinteractiveSystem_Events();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIVE_SYSTEM__WIDGETS = eINSTANCE.getinteractiveSystem_Widgets();

	}

} //InteractiveSystemPackage

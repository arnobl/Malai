/**
 */
package org.malai.interactiveSystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.malai.action.ActionPackage;

import org.malai.action.impl.ActionPackageImpl;

import org.malai.event.EventPackage;

import org.malai.event.impl.EventPackageImpl;

import org.malai.instrument.InstrumentPackage;

import org.malai.instrument.impl.InstrumentPackageImpl;

import org.malai.interaction.InteractionPackage;

import org.malai.interaction.impl.InteractionPackageImpl;

import org.malai.interactiveSystem.InteractiveSystemFactory;
import org.malai.interactiveSystem.InteractiveSystemPackage;
import org.malai.interactiveSystem.interactiveSystem;

import org.malai.widget.WidgetPackage;

import org.malai.widget.impl.WidgetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractiveSystemPackageImpl extends EPackageImpl implements InteractiveSystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactiveSystemEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InteractiveSystemPackageImpl() {
		super(eNS_URI, InteractiveSystemFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link InteractiveSystemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InteractiveSystemPackage init() {
		if (isInited) return (InteractiveSystemPackage)EPackage.Registry.INSTANCE.getEPackage(InteractiveSystemPackage.eNS_URI);

		// Obtain or create and register package
		InteractiveSystemPackageImpl theInteractiveSystemPackage = (InteractiveSystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InteractiveSystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InteractiveSystemPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		InstrumentPackageImpl theInstrumentPackage = (InstrumentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InstrumentPackage.eNS_URI) instanceof InstrumentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InstrumentPackage.eNS_URI) : InstrumentPackage.eINSTANCE);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) instanceof ActionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) : ActionPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		WidgetPackageImpl theWidgetPackage = (WidgetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WidgetPackage.eNS_URI) instanceof WidgetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WidgetPackage.eNS_URI) : WidgetPackage.eINSTANCE);
		InteractionPackageImpl theInteractionPackage = (InteractionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI) instanceof InteractionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI) : InteractionPackage.eINSTANCE);

		// Create package meta-data objects
		theInteractiveSystemPackage.createPackageContents();
		theInstrumentPackage.createPackageContents();
		theActionPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theWidgetPackage.createPackageContents();
		theInteractionPackage.createPackageContents();

		// Initialize created meta-data
		theInteractiveSystemPackage.initializePackageContents();
		theInstrumentPackage.initializePackageContents();
		theActionPackage.initializePackageContents();
		theEventPackage.initializePackageContents();
		theWidgetPackage.initializePackageContents();
		theInteractionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInteractiveSystemPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InteractiveSystemPackage.eNS_URI, theInteractiveSystemPackage);
		return theInteractiveSystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinteractiveSystem() {
		return interactiveSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinteractiveSystem_Instruments() {
		return (EReference)interactiveSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinteractiveSystem_Interactions() {
		return (EReference)interactiveSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinteractiveSystem_Actions() {
		return (EReference)interactiveSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinteractiveSystem_Events() {
		return (EReference)interactiveSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinteractiveSystem_Widgets() {
		return (EReference)interactiveSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractiveSystemFactory getInteractiveSystemFactory() {
		return (InteractiveSystemFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		interactiveSystemEClass = createEClass(INTERACTIVE_SYSTEM);
		createEReference(interactiveSystemEClass, INTERACTIVE_SYSTEM__INSTRUMENTS);
		createEReference(interactiveSystemEClass, INTERACTIVE_SYSTEM__INTERACTIONS);
		createEReference(interactiveSystemEClass, INTERACTIVE_SYSTEM__ACTIONS);
		createEReference(interactiveSystemEClass, INTERACTIVE_SYSTEM__EVENTS);
		createEReference(interactiveSystemEClass, INTERACTIVE_SYSTEM__WIDGETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InstrumentPackage theInstrumentPackage = (InstrumentPackage)EPackage.Registry.INSTANCE.getEPackage(InstrumentPackage.eNS_URI);
		InteractionPackage theInteractionPackage = (InteractionPackage)EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI);
		ActionPackage theActionPackage = (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);
		EventPackage theEventPackage = (EventPackage)EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI);
		WidgetPackage theWidgetPackage = (WidgetPackage)EPackage.Registry.INSTANCE.getEPackage(WidgetPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(interactiveSystemEClass, interactiveSystem.class, "interactiveSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getinteractiveSystem_Instruments(), theInstrumentPackage.getInstrument(), null, "instruments", null, 0, -1, interactiveSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinteractiveSystem_Interactions(), theInteractionPackage.getInteraction(), null, "interactions", null, 0, -1, interactiveSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinteractiveSystem_Actions(), theActionPackage.getAction(), null, "actions", null, 0, -1, interactiveSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinteractiveSystem_Events(), theEventPackage.getEvent(), null, "events", null, 0, -1, interactiveSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinteractiveSystem_Widgets(), theWidgetPackage.getWidget(), null, "widgets", null, 0, -1, interactiveSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InteractiveSystemPackageImpl

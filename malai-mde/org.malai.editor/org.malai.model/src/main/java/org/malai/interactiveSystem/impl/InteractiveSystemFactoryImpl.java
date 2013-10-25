/**
 */
package org.malai.interactiveSystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.malai.interactiveSystem.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractiveSystemFactoryImpl extends EFactoryImpl implements InteractiveSystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InteractiveSystemFactory init() {
		try {
			InteractiveSystemFactory theInteractiveSystemFactory = (InteractiveSystemFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.malai.interactiveSystem/1_0_0//org/malai/interactiveSystem"); 
			if (theInteractiveSystemFactory != null) {
				return theInteractiveSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InteractiveSystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractiveSystemFactoryImpl() {
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
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM: return createinteractiveSystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interactiveSystem createinteractiveSystem() {
		interactiveSystemImpl interactiveSystem = new interactiveSystemImpl();
		return interactiveSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractiveSystemPackage getInteractiveSystemPackage() {
		return (InteractiveSystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InteractiveSystemPackage getPackage() {
		return InteractiveSystemPackage.eINSTANCE;
	}

} //InteractiveSystemFactoryImpl

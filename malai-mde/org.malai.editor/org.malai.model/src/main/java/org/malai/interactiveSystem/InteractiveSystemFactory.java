/**
 */
package org.malai.interactiveSystem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.malai.interactiveSystem.InteractiveSystemPackage
 * @generated
 */
public interface InteractiveSystemFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InteractiveSystemFactory eINSTANCE = org.malai.interactiveSystem.impl.InteractiveSystemFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>interactive System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>interactive System</em>'.
	 * @generated
	 */
	interactiveSystem createinteractiveSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InteractiveSystemPackage getInteractiveSystemPackage();

} //InteractiveSystemFactory

/**
 */
package org.malai.interactiveSystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.malai.action.Action;

import org.malai.event.Event;

import org.malai.instrument.Instrument;

import org.malai.interaction.Interaction;
import org.malai.widget.Widget;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>interactive System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.malai.interactiveSystem.interactiveSystem#getInstruments <em>Instruments</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.interactiveSystem#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.interactiveSystem#getActions <em>Actions</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.interactiveSystem#getEvents <em>Events</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.interactiveSystem#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem()
 * @model
 * @generated
 */
public interface interactiveSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Instruments</b></em>' containment reference list.
	 * The list contents are of type {@link org.malai.instrument.Instrument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instruments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instruments</em>' containment reference list.
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem_Instruments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instrument> getInstruments();

	/**
	 * Returns the value of the '<em><b>Interactions</b></em>' containment reference list.
	 * The list contents are of type {@link org.malai.interaction.Interaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interactions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interactions</em>' containment reference list.
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem_Interactions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interaction> getInteractions();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.malai.action.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.malai.event.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.malai.widget.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.malai.interactiveSystem.InteractiveSystemPackage#getinteractiveSystem_Widgets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

} // interactiveSystem

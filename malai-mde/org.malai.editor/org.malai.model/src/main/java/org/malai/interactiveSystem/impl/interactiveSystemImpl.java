/**
 */
package org.malai.interactiveSystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.malai.action.Action;

import org.malai.event.Event;

import org.malai.instrument.Instrument;

import org.malai.interaction.Interaction;
import org.malai.interactiveSystem.InteractiveSystemPackage;
import org.malai.interactiveSystem.interactiveSystem;

import org.malai.widget.Widget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>interactive System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.malai.interactiveSystem.impl.interactiveSystemImpl#getInstruments <em>Instruments</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.impl.interactiveSystemImpl#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.impl.interactiveSystemImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.impl.interactiveSystemImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.malai.interactiveSystem.impl.interactiveSystemImpl#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class interactiveSystemImpl extends EObjectImpl implements interactiveSystem {
	/**
	 * The cached value of the '{@link #getInstruments() <em>Instruments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstruments()
	 * @generated
	 * @ordered
	 */
	protected EList<Instrument> instruments;

	/**
	 * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractions()
	 * @generated
	 * @ordered
	 */
	protected EList<Interaction> interactions;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getWidgets() <em>Widgets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgets()
	 * @generated
	 * @ordered
	 */
	protected EList<Widget> widgets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected interactiveSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractiveSystemPackage.Literals.INTERACTIVE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instrument> getInstruments() {
		if (instruments == null) {
			instruments = new EObjectContainmentEList<Instrument>(Instrument.class, this, InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS);
		}
		return instruments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interaction> getInteractions() {
		if (interactions == null) {
			interactions = new EObjectContainmentEList<Interaction>(Interaction.class, this, InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS);
		}
		return interactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getWidgets() {
		if (widgets == null) {
			widgets = new EObjectContainmentEList<Widget>(Widget.class, this, InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS);
		}
		return widgets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS:
				return ((InternalEList<?>)getInstruments()).basicRemove(otherEnd, msgs);
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS:
				return ((InternalEList<?>)getInteractions()).basicRemove(otherEnd, msgs);
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS:
				return ((InternalEList<?>)getWidgets()).basicRemove(otherEnd, msgs);
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
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS:
				return getInstruments();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS:
				return getInteractions();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS:
				return getActions();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS:
				return getEvents();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS:
				return getWidgets();
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
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS:
				getInstruments().clear();
				getInstruments().addAll((Collection<? extends Instrument>)newValue);
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS:
				getInteractions().clear();
				getInteractions().addAll((Collection<? extends Interaction>)newValue);
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS:
				getWidgets().clear();
				getWidgets().addAll((Collection<? extends Widget>)newValue);
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
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS:
				getInstruments().clear();
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS:
				getInteractions().clear();
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS:
				getActions().clear();
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS:
				getEvents().clear();
				return;
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS:
				getWidgets().clear();
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
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INSTRUMENTS:
				return instruments != null && !instruments.isEmpty();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__INTERACTIONS:
				return interactions != null && !interactions.isEmpty();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__ACTIONS:
				return actions != null && !actions.isEmpty();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__EVENTS:
				return events != null && !events.isEmpty();
			case InteractiveSystemPackage.INTERACTIVE_SYSTEM__WIDGETS:
				return widgets != null && !widgets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //interactiveSystemImpl

package org.malai.model.mbt.api;

import java.util.HashMap;
import java.util.Map;

import org.malai.interaction.Transition;

/**
 * This class manages the mapping between Transitions from the model and Widgets
 * from the UI
 */
public class Mapper {
	
	Map<Transition,TestedWidget> registeredWidgets;
	
	public Mapper() {
		registeredWidgets = new HashMap<Transition, TestedWidget>();
	}
	
	/**
	 * Register an association of a transition and a testable widget
	 * 
	 * @param ID A transition from the InteractiveSystem model
	 * @param widget A testable widget from the UI
	 * @throws Exception A transition can be associated with only one testable widget
	 */
	public void register(Transition ID, TestedWidget widget) throws Exception{
		if(registeredWidgets.get(ID) != null) throw new Exception("Registration error: "+ID+" is already registered");
		registeredWidgets.put(ID, widget);
	}
	
	/**
	 * Remove the association of this transition from the registry
	 * 
	 * @param ID A transition from the InteractiveSystem model
	 * @throws Exception The transition have to be registered before 
	 */
	public void unregister(Transition ID) throws Exception{
		if(registeredWidgets.get(ID) == null) throw new Exception("Unregistration error: "+ID+" is not yet registered");
		registeredWidgets.remove(ID);
	}
	
	/**
	 * Find the testable widget associated with the transition in the registry
	 * 
	 * @param ID A transition from the InteractiveSystem model
	 * @return A testable widget
	 * @throws Exception The association transition-widget have to be registered
	 */
	public TestedWidget findWidget(Transition ID) throws Exception{
		TestedWidget result = registeredWidgets.get(ID);
		if(result == null) throw new Exception("Find error: "+ID+" is not registered");
		return result;
	}
}

package org.malai.model.mbt.api;

import java.util.HashMap;
import java.util.Map;

/**
 * This class manages the mapping between Transitions from the model and Widgets
 * from the UI
 */
public class Mapper {
	
	Map<String,TestedWidget> registeredWidgets;
	
	public Mapper() {
		registeredWidgets = new HashMap<String, TestedWidget>();
	}
	
	/**
	 * Register a testable widget
	 * 
	 * @param widget A testable widget from the UI
	 * @throws Exception A transition can be associated with only one testable widget
	 */
	public void register(TestedWidget widget) throws Exception{
		if(registeredWidgets.get(widget.getID()) != null) throw new Exception("Registration error: "+widget.getID()+" is already registered");
		registeredWidgets.put(widget.getID(), widget);
	}
	
	/**
	 * Remove this testable widget from the registry
	 * 
	 * @param ID Identifier of a testable widget
	 * @throws Exception The widget have to be registered before 
	 */
	public void unregister(String ID) throws Exception{
		if(registeredWidgets.get(ID) == null) throw new Exception("Unregistration error: "+ID+" is not yet registered");
		registeredWidgets.remove(ID);
	}
	
	/**
	 * Find the testable widget associated in the registry
	 * 
	 * @param ID Identifier of a testable widget
	 * @return A testable widget
	 * @throws Exception The association transition-widget have to be registered
	 */
	public TestedWidget findWidget(String ID) throws Exception{
		TestedWidget result = registeredWidgets.get(ID);
		if(result == null) throw new Exception("Find error: "+ID+" is not registered");
		return result;
	}
}

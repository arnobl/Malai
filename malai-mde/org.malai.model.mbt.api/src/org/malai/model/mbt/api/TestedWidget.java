package org.malai.model.mbt.api;

import java.util.List;
import org.malai.event.Event;

/**
 * This interface defines necessaries methods to get concretes values
 * from a widget for testing
 */
public interface TestedWidget {
	
	/**
	 * Get the identifier of the widget used in the registering process
	 * @return
	 */
	public String getID();
	
	/**
	 * Ask the widget for possibles concretes values for a given Event
	 * in its current state
	 * 
	 * @param event Abstract event defined in the InteractiveSystem model
	 * @return
	 */
	public List<DomainValue> getPossiblesValues(Event event);
	
	/**
	 * Update the state of the widget with concretes values
	 * 
	 * @param event Abstract event defined in the InteractiveSystem model
	 * @param param Values selected from DomainValue given by getPossiblesValues(event)
	 */
	public void execute(Event event, List<Object> param);
}

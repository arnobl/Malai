package org.malai.model.mbt.api;

import java.util.List;

/**
 * This interface define a testable UI
 */
public interface TestedUI {
	
	/**
	 * Get testable widgets of this UI
	 */
	public List<TestedWidget> getWidgets();
}

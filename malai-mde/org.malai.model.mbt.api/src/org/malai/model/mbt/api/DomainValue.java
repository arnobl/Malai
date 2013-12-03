package org.malai.model.mbt.api;

/**
 * This interface represent a range of possibles values and 
 * define how select a concrete value
 */
public interface DomainValue {
	public Object pickup(); //TODO: need a parameterized strategy ?
}

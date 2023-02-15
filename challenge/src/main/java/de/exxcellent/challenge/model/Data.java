package de.exxcellent.challenge.model;

import java.util.List;
import java.util.Map;

public class Data {
	
	private final String identifier;
	private final double value;
	
	
	public Data(String identifier, double value) {
		super();
		this.identifier = identifier;
		this.value = value;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public double getValue() {
		return value;
	}
	
	
		
}

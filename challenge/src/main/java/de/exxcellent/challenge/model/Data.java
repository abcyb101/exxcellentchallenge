package de.exxcellent.challenge.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		final Data other = (Data) obj;
		
		if (!Objects.equals(this.identifier,  other.identifier)) {
			return false;
		}
		
		//two double values can be equal numerically, but can have different bit representations!
		//this is because of the way how floating point numbers are stored in memory (3parts: a sign bit, an exponent, and a mantissa)
		//In general, it's better to use comparison methods that take into account this issue: Double.compare()
		if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
			return false;
		}
		
		return true;
		
	}
	
	//we need to override the hashCode method!
	//the Data object has 2 fields to ensure that objects witrh the same identifier and value produce the same hash hash code
	@Override
	public int hashCode() {
	    int hash = 17; // Start with a prime number to avoid collisions
	    hash = hash * 31 + identifier.hashCode(); // Multiply by a prime number and add the identifier's hash code
	    hash = hash * 31 + Double.hashCode(value); // Multiply by a prime number and add the value's hash code
	    return hash;
	}
		
}

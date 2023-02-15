package de.exxcellent.challenge.model;

import java.util.List;

public class Data {
	
	private final List<double[]> data;
	
	public Data(List<double[]> data) {
		this.data = data;
	}

	public List<double[]> getData() {
		return data;
	}

}

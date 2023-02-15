package de.exxcellent.challenge.model;

public enum InputFormat {
	CSV("csv");
	
	private final String format;
	
	InputFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}

}

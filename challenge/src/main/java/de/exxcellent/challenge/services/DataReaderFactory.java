package de.exxcellent.challenge.services;

public class DataReaderFactory {
	public static DataReader create(String format) {
		switch(format) {
			case "csv":
				return new CsvDataReader();
			//implement other formats here
			default:
				throw new IllegalArgumentException("Unsupported format: " + format);
				
		}
	}

}

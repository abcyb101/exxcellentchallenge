package de.exxcellent.challenge.services;

import de.exxcellent.challenge.model.InputFormat;

public class DataReaderFactory {
	public static DataReader create(InputFormat format) {
		switch(format) {
			case CSV:
				return new CsvDataReader();
			//implement other formats here
			default:
				throw new IllegalArgumentException("Unsupported format: " + format);
				
		}
	}

}

package de.exxcellent.challenge.services;

public class DataReaderFactory {
	public static DataReader create(String format, String filePath, String separator) {
		switch(format) {
			case "csv":
				return new CsvDataReader(filePath, separator);
			//implement other formats here
			default:
				throw new IllegalArgumentException("Unsupported format: " + format);
				
		}
	}

}

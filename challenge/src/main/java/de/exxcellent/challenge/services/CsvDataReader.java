package de.exxcellent.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader implements DataReader {
	
	private String fileName;
	private String separator;
	
	public CsvDataReader(String fileName, String separator) {
		super();
		this.fileName = fileName;
		this.separator = separator;
	}



	@Override
	public List<String[]> readData(String filePath, String format) throws IOException {
		List<String[]> rows = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(separator);
				rows.add(values);
			}
		}
		
		return rows;
	}

}

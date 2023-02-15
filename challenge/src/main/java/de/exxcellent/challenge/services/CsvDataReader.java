package de.exxcellent.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.exxcellent.challenge.model.Data;

public class CsvDataReader implements DataReader {
	
	private static final Logger LOGGER = Logger.getLogger(CsvDataReader.class.getName());

	public CsvDataReader() {
		super();
	}

	@Override
	public List<String> readData(String filePath) throws IOException {
		List<String> rowList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			reader.readLine(); //skip headers
			while ((line = reader.readLine()) != null) {
				rowList.add(line);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error reading data from CSV file: " + e.getMessage());
		}
		LOGGER.log(Level.INFO, "Successfully read data from CSV file.");
		return rowList;
	}

	@Override
	public String getFormat() {
		return "csv";
	}

}

package de.exxcellent.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.exxcellent.challenge.model.Data;

public class CsvDataReader implements DataReader {

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
		}
		return rowList;
	}



	@Override
	public String getFormat() {
		return "csv";
	}

}

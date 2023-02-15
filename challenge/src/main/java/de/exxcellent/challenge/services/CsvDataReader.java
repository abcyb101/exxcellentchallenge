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
	public List<Data> readData(String separator, String filePath, int idColumnIndex, int valueHighColumnIndex, int valueLowColumnIndex) throws IOException {
		List<Data> dataList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			reader.readLine(); //skip headers
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(separator);
				String identifier = values[idColumnIndex];
				double value1 = Double.parseDouble(values[valueHighColumnIndex]);
				double value2 = Double.parseDouble(values[valueLowColumnIndex]);
				double diff = Math.abs(value1 - value2);
				dataList.add(new Data(identifier, diff));
			}
		}
		
		return dataList;
	}



	@Override
	public String getFormat() {
		return "csv";
	}

}

package de.exxcellent.challenge.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.exxcellent.challenge.model.Data;

public class DataEvaluator {
	
	private static final Logger LOGGER = Logger.getLogger(DataEvaluator.class.getName());
	
	private String separator;
	private int idColumnIndex;
	private int valueHighColumnIndex;
	private int valueLowColumnIndex;

	public DataEvaluator(String separator, int idColumnIndex, int valueHighColumnIndex, int valueLowColumnIndex) {
		super();
		this.separator = separator;
		this.idColumnIndex = idColumnIndex;
		this.valueHighColumnIndex = valueHighColumnIndex;
		this.valueLowColumnIndex = valueLowColumnIndex;
	}

	public List<Data> evaluateData(List<String> rowData) throws IOException {
		List<Data> dataList = new ArrayList<>();
		for (String s : rowData) {
			try {
				String[] values = s.split(separator);
				String identifier = values[idColumnIndex];
				double value1 = Double.parseDouble(values[valueHighColumnIndex]);
				double value2 = Double.parseDouble(values[valueLowColumnIndex]);
				double diff = Math.abs(value1 - value2);
				dataList.add(new Data(identifier, diff));
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				LOGGER.log(Level.SEVERE, "Error: " + e.getMessage());
				e.printStackTrace();
			}
		}		
		LOGGER.log(Level.INFO, "Successfully evaluated data");
		return dataList;
	}

}

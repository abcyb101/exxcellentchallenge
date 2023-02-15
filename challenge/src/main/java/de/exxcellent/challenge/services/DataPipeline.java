package de.exxcellent.challenge.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import de.exxcellent.challenge.model.Data;

public class DataPipeline {
	
	private static final Logger LOGGER = Logger.getLogger(DataPipeline.class.getName());
	
	private DataReader dataReader;
	private DataEvaluator dataEvaluator;
	
	public DataPipeline(DataReader dataReader, DataEvaluator dataEvaluator) {
		super();
		this.dataReader = dataReader;
		this.dataEvaluator = dataEvaluator;
	}
	
	public Data getSmallestDifferenceData(String filePath) {
		try {
			List<Data> data = dataEvaluator.evaluateData(dataReader.readData(filePath));
			Data lowestAverageData = null;
			double lowestAverage = Double.MAX_VALUE;
			
			for(Data e : data) {
				if(e.getValue() < lowestAverage) {
					lowestAverage = e.getValue();
					lowestAverageData = e;
				}
			}
			
			LOGGER.log(Level.INFO, "Successfully computed lowest average Data.");
			return lowestAverageData; //consider using streams -> Comparator, orElse, however then we have to return an Optional.
		
		} catch (IOException ex) {	
			LOGGER.log(Level.SEVERE, "Error computing lowest average Data. " + ex.getMessage());
			ex.printStackTrace();
			return new Data("none", -1);
		}
	}
}

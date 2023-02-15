package de.exxcellent.challenge.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.exxcellent.challenge.model.Data;

public class DataPipeline {
	
	private DataReader dataReader;
	private DataEvaluator dataEvaluator;
	
	public DataPipeline(DataReader dataReader, DataEvaluator dataEvaluator) {
		super();
		this.dataReader = dataReader;
		this.dataEvaluator = dataEvaluator;
	}
	
	public Data getSmallestDifferenceData(String filePath) {
		List<Data> data;
		try {
			data = dataEvaluator.readData(dataReader.readData(filePath));
		
		
		Data lowestAverageData = null;
		double lowestAverage = Double.MAX_VALUE;
		
		for(Data e : data) {
			if(e.getValue() < lowestAverage) {
				lowestAverage = e.getValue();
				lowestAverageData = e;
			}
		}
		
		return lowestAverageData;
		
		} catch (IOException e1) {	
			e1.printStackTrace();
			return new Data("none", -1);
		}
	}

}

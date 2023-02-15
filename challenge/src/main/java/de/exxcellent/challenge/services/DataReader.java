package de.exxcellent.challenge.services;

import java.io.IOException;
import java.util.List;

import de.exxcellent.challenge.model.Data;

public interface DataReader {
	
	List<Data> readData(String separator, String filePath, int idColumnIndex, int valueHighColumnIndex,
			int valueLowColumnIndex) throws IOException;
	String getFormat();

}

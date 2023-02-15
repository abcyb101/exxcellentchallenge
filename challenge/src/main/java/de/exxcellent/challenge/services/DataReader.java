package de.exxcellent.challenge.services;

import java.io.IOException;
import java.util.List;

import de.exxcellent.challenge.model.Data;

public interface DataReader {
	String getFormat();
	List<String> readData(String filePath) throws IOException;
}

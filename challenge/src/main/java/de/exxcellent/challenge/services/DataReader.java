package de.exxcellent.challenge.services;

import java.io.IOException;
import java.util.List;

public interface DataReader {
	
	List<String[]> readData(String filePath, String format) throws IOException;

}

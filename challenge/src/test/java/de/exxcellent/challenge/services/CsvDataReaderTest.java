package de.exxcellent.challenge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class CsvDataReaderTest {

	@TempDir
	public File testFolder;
	
	private CsvDataReader csvDataReader;

	@BeforeEach
	public void setUp() {
		csvDataReader = new CsvDataReader();
	}

	@Test
	void testReadData() throws IOException {
		File csvFile = new File(testFolder, "test.csv");
		Path filePath = csvFile.toPath();
		List<String> rows = Arrays.asList("header","a,1,2", "b,3,4", "c,5,6");
		List<String> desiredoutcome = Arrays.asList("a,1,2", "b,3,4", "c,5,6");
		Files.write(filePath, rows);
		List<String> readRows = csvDataReader.readData(filePath.toString());
		assertEquals(desiredoutcome, readRows);
	}

}
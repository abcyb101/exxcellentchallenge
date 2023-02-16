package de.exxcellent.challenge.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.model.Data;

class DataPipelineTest {

	private DataPipeline dataPipeline;

    @BeforeEach
    void setUp() {
        DataReader dataReader = new CsvDataReader();
        DataEvaluator dataEvaluator = new DataEvaluator(",", 0, 1, 2);
        dataPipeline = new DataPipeline(dataReader, dataEvaluator);
    }

    @Test
    void testGetSmallestDifferenceData() throws IOException {
    	System.out.println(System.getProperty("user.dir"));
        String filePath = "src/main/resources/de/exxcellent/challenge/weathertest.csv";
        Data result = dataPipeline.getSmallestDifferenceData(filePath);
        assertNotNull(result);
        assertEquals("2", result.getIdentifier());
        assertEquals(16.0, result.getValue());
    }

}

package de.exxcellent.challenge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.model.Data;

public class DataEvaluatorTest {
	
	private DataEvaluator dataEvaluator;
	
	@BeforeEach
	public void setUp() {
		dataEvaluator = new DataEvaluator(",", 0, 1, 2);
	}
	
	@Test
	public void testEvaluateData() throws IOException {
		List<String> rowData = Arrays.asList("id1,10.0,5.0", "id2,5.0,5.0", "id3,20.0,30.0");
		List<Data> expectedDataList = new ArrayList<>();
		expectedDataList.add(new Data("id1", 5.0));
		expectedDataList.add(new Data("id2", 0.0));
		expectedDataList.add(new Data("id3", 10.0));
		
		List<Data> actualDataList = dataEvaluator.evaluateData(rowData);
		
		assertEquals(expectedDataList, actualDataList);
	}
	
}
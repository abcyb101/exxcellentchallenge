package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.Main;

import de.exxcellent.challenge.model.Data;
import de.exxcellent.challenge.services.DataEvaluator;
import de.exxcellent.challenge.services.DataPipeline;
import de.exxcellent.challenge.services.DataReader;
import de.exxcellent.challenge.services.DataReaderFactory;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
    	String filePathWeather = "src/main/resources/de/exxcellent/challenge/weather.csv";
    	String filePathFootball = "src/main/resources/de/exxcellent/challenge/football.csv";
    	
    	DataReaderFactory dataReaderFactory = new DataReaderFactory();
    	DataReader dataReader = dataReaderFactory.create("csv");
    	
    	DataEvaluator dataEvalWeather = new DataEvaluator(";", 0, 1, 2);
    	DataEvaluator dataEvalFootball = new DataEvaluator(";", 0, 5, 6);
    	
    	DataPipeline dataPipelineWeather = new DataPipeline(dataReader, dataEvalWeather);
    	DataPipeline dataPipelineFootball = new DataPipeline(dataReader, dataEvalFootball);

        String dayWithSmallestTempSpread = dataPipelineWeather.getSmallestDifferenceData(filePathWeather).getIdentifier();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = dataPipelineFootball.getSmallestDifferenceData(filePathFootball).getIdentifier(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}

package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Launch Analytics Project.
 * */
public class Application {
	
	//ATTRIBUTES
	private static final String path = "Project02Eclipse/";
	private static final String fileToRead = "symptoms.txt";
	private static final String fileToWrite = "results.out";
	private static final String completePathOfFileToRead = path + fileToRead;
	private static final String completePathOfFileToWrite = path + fileToWrite;
			
	//METHODS
	/**
	 * Entry point of the application.
	 * */
	public static void main(String[] args) {
		
		initialMethod();//<---- TODO: renommer
		
	}
	
	/**
	 * An example of the execution of the application
	 * 
	 * Using the given reading method GetSymptoms() from ReadSymptomDataFromFile class.
	 * */
	public static void initialMethod() {
		
		// And: Instantiate all necessary objects to read file, count occurrences, display and write file
		ReadSymptomDataFromFile reading = new ReadSymptomDataFromFile(completePathOfFileToRead);
		AnalyticsCounter counting = new AnalyticsCounter();
		DisplaySymptomData displaying = new DisplaySymptomData();
		WriteSymptomDataToFile writing = new WriteSymptomDataToFile(completePathOfFileToWrite);
		
		// Firstly : Read the file to read
		List<String> read = reading.GetSymptoms();
		
		// Then : Generate counting of symptoms occurrences.
		//Map<String, Integer> count = counting.countLineOccurrencesInList(read);
		
		// Then, eventually : Display the symptoms and their occurrences.
		//displaying.displayMap(count);
		
		// Finally : Write this data into the output file.
		//writing.writeFile(count);		
	}

}
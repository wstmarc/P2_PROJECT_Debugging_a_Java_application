package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Launch Analytics Project.
 * */
public class Application {

	//METHODS
	/**
	 * Entry point of the application.
	 * */
	public static void main(String[] args) {
		
		//testPersonalMethods();
		testInitialMethod();
		
	}
	
	/**
	 * Test Game using personal reading method readFile() from ReadSymptomDataFromFile class,
	 * then using personal counting method countLineOccurrencesInStringToArray() from AnalyticsCounter class.
	 * */
	public static void testPersonalMethods() {
		// Before all : Initialize the path and file name variables
		final String path = "Project02Eclipse/";
//		final String fileToRead = "sympt0ms.txt";
		final String fileToRead = "symptoms.txt";
		final String fileToWrite = "result.out";
		final String completePathOfFileToRead = path + fileToRead;
		final String completePathOfFileToWrite = path + fileToWrite;
		
		// And: Instantiate all necessary objects to read file, count occurrences, display and write file
		ReadSymptomDataFromFile reading = new ReadSymptomDataFromFile(completePathOfFileToRead);
		AnalyticsCounter counting = new AnalyticsCounter();
		DisplaySymptomData displaying = new DisplaySymptomData();
		WriteSymptomDataToFile writing = new WriteSymptomDataToFile(completePathOfFileToWrite);
		
		// Firstly : Read the file to read
		String read = reading.readFile();		
		
		// Then : Generate counting of symptoms occurrences.
		Map<String, Integer> count = counting.countLineOccurrencesInStringToArray(read);
		
		// Then, eventually : Display the symptoms and their occurrences.
		displaying.displayMap(count);
		
		// Finally : Write this data into the output file.
		writing.writeFile(count);
	}
	
	/**
	 * Test Game using initial reading method GetSymptoms() from ReadSymptomDataFromFile class,
	 * then using personal counting method countLineOccurrencesInList() from AnalyticsCounter class.
	 * */
	public static void testInitialMethod() {
		// Before all : Initialize the path and file name variables
		final String path = "Project02Eclipse/";
//		final String fileToRead = "sympt0ms.txt";
		final String fileToRead = "symptoms.txt";
		final String fileToWrite = "result.out";
		final String completePathOfFileToRead = path + fileToRead;
		final String completePathOfFileToWrite = path + fileToWrite;
		
		// And: Instantiate all necessary objects to read file, count occurrences, display and write file
		ReadSymptomDataFromFile reading = new ReadSymptomDataFromFile(completePathOfFileToRead);
		AnalyticsCounter counting = new AnalyticsCounter();
		DisplaySymptomData displaying = new DisplaySymptomData();
		WriteSymptomDataToFile writing = new WriteSymptomDataToFile(completePathOfFileToWrite);
		
		// Firstly : Read the file to read
		List<String> read = reading.GetSymptoms();
		
		// Then : Generate counting of symptoms occurrences.
		Map<String, Integer> count = counting.countLineOccurrencesInList(read);
		
		// Then, eventually : Display the symptoms and their occurrences.
		displaying.displayMap(count);
		
		// Finally : Write this data into the output file.
		writing.writeFile(count);		
	}

}
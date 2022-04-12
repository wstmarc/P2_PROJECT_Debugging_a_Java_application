package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Launch Analytics Project.
 * */
public class Application {

	/**
	 * Entry point of the application.
	 * */
	public static void main(String[] args) {
				
		//Instantiate analysis
		AnalyticsCounter analytics = new AnalyticsCounter();
		
		AnalyticsCounter.file = "symptoms.txt";
		
		final String completePath = AnalyticsCounter.path + AnalyticsCounter.file;
		
		// firstly : Read the file.		
		String reading = analytics.readFile(completePath);
		
		// then : Generate counting of occurrences.
		Map<String, Integer> counting = analytics.countLineOccurrencesStringToArray(reading);
		
		// then, eventually : Display the symptoms and their occurrences.
		analytics.displayMap(counting);
		
		// finally : Write this data into the output file.
		analytics.writeFile(counting);

	}

}
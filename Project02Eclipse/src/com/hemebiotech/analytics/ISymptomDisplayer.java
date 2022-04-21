package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will display symptom data into the console.
 */
public interface ISymptomDisplayer {

	/**
     * Displays, into the console, each couple key-value of the Map<String, Integer> "mapToDisplay", containing symptoms and their occurrences.
     * 
     * @param mapToDisplay : The Map<String, Integer> whose content is to be displayed.
     */
	void displayMap(Map<String, Integer> mapToDisplay);

}
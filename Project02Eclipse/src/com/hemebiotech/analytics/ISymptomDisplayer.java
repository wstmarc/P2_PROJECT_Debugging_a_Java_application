package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will display symptom data into the console.
 */
public interface ISymptomDisplayer {

	/**
     * Displays, into the console, each element of the List<String> "listToDisplay", containing symptoms.
     * 
     * @param listToDisplay : The List<String> whose content is to be displayed.
     */
	void display(List<String> listToDisplay);
	
	/**
     * Displays, into the console, each couple key-value of the Map<String, Integer> "mapToDisplay", containing symptoms and their occurrences.
     * 
     * @param mapToDisplay : The Map<String, Integer> whose content is to be displayed.
     */
	void display(Map<String, Integer> mapToDisplay);

}
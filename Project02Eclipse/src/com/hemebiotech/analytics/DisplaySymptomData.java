package com.hemebiotech.analytics;

import java.util.Map;

public class DisplaySymptomData {

	// -------------------- METHODS --------------------
	/**
     * Displays, into the console, each couple key-value of the Map<String, Integer> "mapToDisplay", containing symptoms and their occurrences.
     * If the map is empty, it displays an error message in the error output of the console.
     * 
     * @param mapToDisplay : The Map<String, Integer> whose content is to be displayed.
     */
    public void displayMap(Map<String, Integer> mapToDisplay) {
    	if(!mapToDisplay.isEmpty()) {
    		for(Map.Entry<String, Integer> entry : mapToDisplay.entrySet()) {
        		System.out.print(entry.getValue());
        		System.out.println("=" + entry.getKey());
        	}
    	} else {
    		System.err.println("No line to display.");
    	}
    }
	
}

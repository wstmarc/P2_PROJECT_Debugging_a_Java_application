package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will display symptom data into the console.
 */
public interface ISymptomDisplayer {

	void displayMap(Map<String, Integer> mapToDisplay);
	
}
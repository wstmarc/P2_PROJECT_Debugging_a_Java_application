package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count number of occurrence of symptom data.
 * */
public interface ISymptomCounter {

	Map<String, Integer> countLineOccurrencesInList(List<String> listOfStrings);
	
	Map<String, Integer> countLineOccurrencesInStringToArray(String string);
	
}
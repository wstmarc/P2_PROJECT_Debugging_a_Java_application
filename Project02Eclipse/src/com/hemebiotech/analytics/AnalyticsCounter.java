package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
//import java.util.HashMap;
import java.util.TreeMap;

/**
 * Manages the counting of occurrences of symptoms.
 * */
public class AnalyticsCounter implements ISymptomCounter {
	
	// -------------------- METHODS --------------------
	@Override
	public Map<String, Integer> countLineOccurrencesInList(List<String> reading) {
		Map<String, Integer> occurrences = new TreeMap<String, Integer>();//A TreeMap object naturally (automatically) manages the sorting of its keys (by alphabetical order).
		
		for(String line : reading) {
			occurrences.putIfAbsent(line, 0);
			occurrences.put(line, occurrences.get(line) + 1);
		}
		return occurrences;
	}
	
	@Override
	public Map<String, Integer> countLineOccurrencesInStringToArray(String reading) {
		Map<String, Integer> occurrences = new TreeMap<String, Integer>();//A TreeMap object naturally (automatically) manages the sorting of its keys (by alphabetical order).
		
		String[] arrayOfSymptoms = reading.split("\n");//truncates at each line break the String reading, then stores each part in an Array of String listOfSymptoms.
		
		for(String line : arrayOfSymptoms) {
			occurrences.putIfAbsent(line, 0);
			occurrences.put(line, occurrences.get(line) + 1);
		}
		return occurrences;
	}
	
}
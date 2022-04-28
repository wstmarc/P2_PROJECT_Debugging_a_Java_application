package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manages the counting of occurrences of symptoms.
 * */
public class CountSymptomData implements ISymptomCounter {
	
	// -------------------- METHODS --------------------
	@Override
	public Map<String, Integer> countLineOccurrences(List<String> reading) {
		Map<String, Integer> occurrences = new TreeMap<>();
		
		if(!reading.isEmpty()) {
			
			reading.forEach( (K) -> {
				occurrences.putIfAbsent(K, 0);
				occurrences.put(K, occurrences.get(K) + 1);
			} );
			
		} else System.err.println("The list of symptoms is empty !!!");
		return occurrences;
	}
	
	@Override
	public Map<String, Integer> countLineOccurrences(String reading) {
		Map<String, Integer> occurrences = new TreeMap<>();
		
		String[] arrayOfSymptoms = reading.split("\n");//truncates at each line break the String reading, then stores each part in an Array of String listOfSymptoms. 
		
		if(!(arrayOfSymptoms.length == 0)) {
			
			for(String element : arrayOfSymptoms) {				
				occurrences.putIfAbsent(element, 0);
				occurrences.put(element, occurrences.get(element) + 1);
			}
			
		} else System.err.println("The list of symptoms is empty !!!");
		return occurrences;
	}
	
}
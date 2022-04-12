package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
//import java.util.HashMap;
import java.util.TreeMap;

/**
 * Manages the counting of occurrences of symptoms.
 * */
public class AnalyticsCounter {
	
	// -------------------- METHODS --------------------
	/**
	 * Counts the number of occurrence of each symptom in the List of Strings "reading", corresponding to the reading of the file containing the symptom lines.
	 * While the counting, the symptoms and their number of occurrence are stocked into a TreeMap<String, Integer>, which sorts automatically the data by natural order (alphabetical order).
	 * 
	 * The input is a List of Strings containing several symptoms.
	 * All unique lines are stocked into a Map<String, Integer> "occurrences", and their number of occurrence too, which is calculated into a loop, while reading each element of the Array of Strings.
	 * Finally, the Map<String, Integer> "occurrences", filled with symptoms and their number of occurrence, is returned.
	 * 
	 * @param reading : A List of Strings containing all the lines of the file being read.
	 * @return occurrences : A Map<String, Integer> containing as keys the symptoms, and as values the number of occurrence for each symptom.
	 * */
	public Map<String, Integer> countLineOccurrencesInList(List<String> reading) {
		Map<String, Integer> occurrences = new TreeMap<String, Integer>();//A TreeMap object naturally (automatically) manages the sorting of its keys (by alphabetical order).
		
		for(String line : reading) {
			occurrences.putIfAbsent(line, 0);
			occurrences.put(line, occurrences.get(line) + 1);
		}
		return occurrences;
	}
	
	/**
	 * Counts the number of occurrence of each symptom in the String "reading", corresponding to the reading of the file containing the symptom lines.
	 * While the counting, the symptoms and their number of occurrence are stocked into a TreeMap<String, Integer>, which sorts automatically the data by natural order (alphabetical order).
	 * 
	 * The input is a String containing several lines, each ended by a line feed "\n" .
	 * All the lines are stocked into an Array of Strings "arrayOfSymptoms".
	 * All unique lines are stocked into a Map<String, Integer> "occurrences", and their number of occurrence too, which is calculated into a loop, while reading each element of the Array of Strings.
	 * Finally, the Map<String, Integer> "occurrences", filled with symptoms and their number of occurrence, is returned. 
	 * 
	 * @param reading : A String containing all the lines of the file being read.
	 * @return occurrences : A Map<String, Integer> containing as keys the symptoms, and as values the number of occurrence for each symptom.
	 * */
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
package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count number of occurrence of symptom data.
 * */
public interface ISymptomCounter {

	/**
	 * Counts the number of occurrence for each symptom in the List of Strings "reading", provided as a parameter, corresponding to the reading of the file containing the symptom lines.
	 * While the counting, the symptoms and their number of occurrence are stocked into a TreeMap<String, Integer>, which sorts automatically the data by natural order (alphabetical order).
	 * 
	 * @param reading : A List of Strings containing all the lines of the file being read.
	 * @return occurrences : A Map<String, Integer> containing as keys the symptoms, and as values the number of occurrence for each symptom.
	 * */
	Map<String, Integer> countLineOccurrences(List<String> listOfStrings);
	
	/**
	 * Counts the number of occurrence for each symptom in the String "reading", provided as a parameter, corresponding to the reading of the file containing the symptom lines.
	 * While the counting, the symptoms and their number of occurrence are stocked into a TreeMap<String, Integer>, which sorts automatically the data by natural order (alphabetical order).
	 * 
	 * @param reading : A String containing all the lines of the file being read.
	 * @return occurrences : A Map<String, Integer> containing as keys the symptoms, and as values the number of occurrence for each symptom.
	 * */
	Map<String, Integer> countLineOccurrences(String string);
	
}
package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom data into a file.
 */
public interface ISymptomWriter {

	/**
	 * Writes couples key-value contained into a Map<String, Integer> "mapToWrite", provided as a parameter, into a file.
	 *  
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @exception FileNotFoundException : Signals that, for the specified path, the file has not been found.
	 * @param mapToWrite : A Map<String, Integer> containing, as keys the symptoms, and, as values the number of occurrence for each symptom.
	 * */
	void writeFile(Map<String, Integer> mapToWrite) throws IOException ;
	
}
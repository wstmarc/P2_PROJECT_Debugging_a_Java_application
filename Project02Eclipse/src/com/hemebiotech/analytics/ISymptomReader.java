package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source file.
 */
public interface ISymptomReader {
	//TODO : check the relevance of Javadoc comments.
	/**
	 * If no data is available, return an empty List.
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable.
	 */
	List<String> GetSymptoms ();
	
	String readFile();
}
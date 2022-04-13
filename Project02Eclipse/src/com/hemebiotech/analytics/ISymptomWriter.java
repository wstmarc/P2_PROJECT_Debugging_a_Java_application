package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data into a file.
 */
public interface ISymptomWriter {

	void writeFile(Map<String, Integer> mapStringInteger);
	
}
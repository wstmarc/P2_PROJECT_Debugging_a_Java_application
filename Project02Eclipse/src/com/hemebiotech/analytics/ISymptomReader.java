package com.hemebiotech.analytics;

import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Anything that will read symptom data from a source file.
 */
public interface ISymptomReader {
	
	/**
	 * Reads the whole text of a file, and returns an ArrayList of Strings "reading", containing all its lines (the symptoms into it).
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @exception FileNotFoundException : Signals that, for the specified path, the file has not been found.
	 * @return reading : An ArrayList of Strings that contains all the lines of text in the file being read.
	 * */
	List<String> GetSymptoms();
	
	/**
	 * Reads the whole text of a file, and returns a String "reading", containing all its lines.
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @exception FileNotFoundException : Signals that, for the specified path, the file has not been found.
	 * @return reading : A more or less long String that contains all the lines of text in the file being read.
	 * */
	String readFile();
	
}
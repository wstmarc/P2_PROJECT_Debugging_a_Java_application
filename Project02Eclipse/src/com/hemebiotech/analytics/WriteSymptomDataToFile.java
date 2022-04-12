package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	// -------------------- ATTRIBUTES --------------------
	private String filepath;
	
	// -------------------- ACCESSORS AND MUTATORS --------------------
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	// -------------------- METHODS --------------------
	/**
	 * Constructor
	 * @param filepath : A full or partial path to file where to write symptom strings and their number of occurrence (one per line)
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Writes couples key-value contained into a Map<String, Integer> "mapToWrite", provided as a parameter, into a file.
	 * The String part, which is the couple key, concerns the symptom to be written.
	 * The Integer part, which is the couple value, concerns the number of occurrence of this symptom.
	 * The lines are written as follows : symptom=numberOfOccurrenceOfIt .
	 * If any issue is encountered during writing process, an exception of Input/Output "IOException" is thrown, and it displays an error message in the error output of the console.
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @param mapToWrite : A Map<String, Integer> containing, as keys the symptoms, and, as values the number of occurrence for each symptom.
	 * */
	public void writeFile(Map<String, Integer> mapToWrite) {
		try {
			FileWriter writer = new FileWriter (this.getFilepath());
//			FileWriter writer = new FileWriter (path + "result.out");
			
		// DONE : Refactor the writing method.
			int tailleMap = mapToWrite.values().size();
			int i = 0;
			
			for(Map.Entry<String, Integer> entry : mapToWrite.entrySet()) {
				i += 1;
				String line = entry.getKey() + "=" + entry.getValue();
				
			// DONE : manage case where we are at last element of entrySet, not to add the line feed '\n' at the end of the line
				if(i != tailleMap) {
					writer.write(line + "\n");
				} else {
					writer.write(line);
				}
			}
			writer.close();
		}
	// DONE : Manage more precisely Exceptions.
		catch(IOException e) {
			System.err.println("An error occured during I/O process !!!\n");
			e.printStackTrace();
		}
	}
	
}

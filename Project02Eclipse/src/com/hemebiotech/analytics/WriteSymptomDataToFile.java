package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Manages the writing of symptom data into a file.
 * */
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
	
	@Override
	public void writeFile(Map<String, Integer> mapToWrite) throws IOException {
		try {
			FileWriter writer = new FileWriter (this.getFilepath());
			
			int tailleMap = mapToWrite.values().size();
			int i = 0;
			
			for(Map.Entry<String, Integer> entry : mapToWrite.entrySet()) {
				i += 1;
				String line = entry.getKey() + "=" + entry.getValue();
				
				if(i != tailleMap) {
					writer.write(line + "\n");
				} else {
					writer.write(line);
				}
			}
			writer.close();
		}
//		catch(IOException e) {
//			System.err.println("An error occured during I/O process !!!\n" + e.getMessage());
//		}
		catch(FileNotFoundException e) {
			System.err.println("The file has not been found !!!\n" + e.getMessage());
		}
	}
	
}

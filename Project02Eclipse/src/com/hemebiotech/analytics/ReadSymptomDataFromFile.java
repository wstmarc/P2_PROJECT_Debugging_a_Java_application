package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages reading and displaying of symptom data from a source.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

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
	 * @param filepath : A full or partial path to file with symptom strings in it (one per line)
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	public List<String> GetSymptoms() {
		ArrayList<String> reading = new ArrayList<String>();
		
		if (this.getFilepath() != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.getFilepath()));
				String line = reader.readLine();// One line of the file being read (first symptom of it).
				
				while (line != null) {
					reading.add(line);
					line = reader.readLine();// Get another line of the file being read (another symptom).
				}
				reader.close();
				System.out.println(reading);
			}
			catch(FileNotFoundException e) {
				System.err.println("The file has not been found !!!\n" + e.getMessage());
			}
			catch(IOException e) {
				System.err.println("An error occured during I/O process !!!\n" + e.getMessage());
			}
		}
		return reading;
	}
	
	@Override
	public String readFile() {
		String reading = "";
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(this.getFilepath()));
			String line = reader.readLine();// One line of the file being read (first symptom of it).
			
			while (line != null) {
				reading += line + '\n';// A line break must be added at the end of the line otherwise all lines read are concatenated into one.
				line = reader.readLine();// Get another line of the file being read (another symptom).
			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("The file has not been found !!!\n" + e.getMessage());
		}
		catch(IOException e) {
			System.err.println("An error occured during I/O process !!!\n" + e.getMessage());
		}
		return reading;
	}

}
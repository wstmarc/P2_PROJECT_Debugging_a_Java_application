package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages reading and displaying of symptom data from a source.
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications. 
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
	
	/**
	 * Reads the whole text of a file, and returns an ArrayList of Strings "result", containing all its lines (the symptoms into it).
	 * 
	 * If any issue is encountered during reading process, an exception of Input/Output "IOException" is thrown, and it displays an error message in the error output of the console.
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @return result : A List of Strings that contains all the lines of text in the file being read.
	 * */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (this.getFilepath() != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.getFilepath()));
				String line = reader.readLine();// One line of the file being read (first symptom of it).
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();// Get another line of the file being read (another symptom).
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("An error occured during I/O process !!!\n");
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	/**
	 * Reads the whole text of a file, and returns a String "reading", containing all its lines.
	 * 
	 * If any issue is encountered during reading process, an exception of Input/Output "IOException" is thrown, and it displays an error message in the error output of the console.
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @return reading : A more or less long String that contains all the lines of text in the file being read.
	 * */
	@Override
	public String readFile() {
		String reading = "";
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(this.getFilepath()));
			// Warning: readLine() method reads a line of text.
			// A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
			// a carriage return followed immediately by a line feed, or by reaching the end-of-file (EOF).
			String line = reader.readLine();// One line of the file being read (first symptom of it).
			
			while (line != null) {
				//System.out.println("symptom from file: " + line); // DEBUG
				
				reading += line + '\n';// A line break must be added at the end of the line otherwise all lines read are concatenated into one.
				line = reader.readLine();// Get another line of the file being read (another symptom).
			}
			//System.out.println(reading); // DEBUG
			reader.close();
		}
	// DONE : Manage more precisely Exceptions.
		catch(IOException e) {
			System.err.println("An error occured during I/O process !!!\n");
			e.printStackTrace();
		}
		return reading;
	}

}
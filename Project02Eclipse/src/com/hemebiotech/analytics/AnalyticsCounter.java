package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
//import java.util.HashMap;
import java.util.TreeMap;

/**
 * Manages the counting of occurrences of symptoms.
 * */
public class AnalyticsCounter {
	
	private static final String path = "Project02Eclipse/";
//	public String file = "sympt0ms.txt";
	public static String file = "symptoms.txt";
	
	/**
	 * Entry point of the application.
	 * */
	public static void main(String args[]) throws Exception {
		//Instantiate analysis
		AnalyticsCounter analytics = new AnalyticsCounter();
		
		file = "symptoms.txt";
		
		final String completePath = path + file;
		
		// firstly : Read the file.		
		String reading = analytics.readFile(completePath);
		
		// then : Generate counting of occurrences.
		Map<String, Integer> counting = analytics.countLineOccurrencesStringToArray(reading);
		
		// then : Display the symptoms and their occurrences.
		analytics.displayMap(counting);
		
		// finally : Write this data into the output file.
		analytics.writeFile(counting);
	}
	
	/**
	 * Reads the whole text of a file, and returns a String containing its content.
	 * The full path of access to the file is provided as a parameter.
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @param pathOfFileToRead : The full path of the file to read.
	 * @return reading : A more or less long String that contains all the lines of text in the file being read.
	 * */
	public String readFile(String pathOfFileToRead) {
		String reading = "";
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(pathOfFileToRead));
			// Warning: readLine() method reads a line of text.
			// A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
			// a carriage return followed immediately by a line feed, or by reaching the end-of-file (EOF).
			String line = reader.readLine();//one line of the file being read (first symptom of it).
			
			while (line != null) {
				//System.out.println("symptom from file: " + line); // DEBUG
				
				reading += line + '\n';// A line break must be added at the end of the line otherwise all lines read are concatenated into one.
				line = reader.readLine();// Get another line of the file being read (another symptom).
			}
			//System.out.println(lecture); // DEBUG
			reader.close();
		}
	// DONE : Manage more precisely Exceptions.
		catch(IOException e) {
			System.err.println("An error occured during I/O process !!!\n");
			e.printStackTrace();
		}
		return reading;
	}
	
	/**
	 * Counts the number of occurrence of each symptom in the String, corresponding to the reading of the file containing the symptom lines.
	 * While the counting, the symptoms and their number of occurrence are stocked into a TreeMap, which sorts automatically the data by natural order (alphabetical order).
	 * 
	 * The input is a String containing several lines, each ended by a line feed "\n" .
	 * All the lines are stocked into an Array of Strings.
	 * All unique lines are stocked into a Map<String, Integer>, and their number of occurrence too, which is calculated into a loop, while reading each element of the Array of Strings.
	 * Finally, the Map<String, Integer> of symptoms and occurrences, is returned. 
	 * 
	 * @param reading : A string containing all the lines of the file being read.
	 * @return occurrences : A Map<String, Integer> containing as keys the symptoms, and as values the number of occurrence for each symptom.
	 * */
	public Map<String, Integer> countLineOccurrencesStringToArray(String reading) {
		Map<String, Integer> occurrences = new TreeMap<String, Integer>();//A TreeMap object naturally (automatically) manages the sorting of its keys (by alphabetical order).
		
		String[] arrayOfSymptoms = reading.split("\n");//truncates at each line break the String reading, then stores each part in an Array of String listOfSymptoms.
		
		for(String line : arrayOfSymptoms) {
			occurrences.putIfAbsent(line, 0);
			occurrences.put(line, occurrences.get(line) + 1);
		}
		return occurrences;
	}
	
	/**
     * Displays, into the console, each couple key-value of the Map<String, Integer>, containing symptoms and their occurrences.
     * If the map is empty, displays an error message in the error output of the console.
     * 
     * @param mapToDisplay : The Map itself.
     */
    public void displayMap(Map<String, Integer> mapToDisplay) {
    	if(!mapToDisplay.isEmpty()) {
    		for(Map.Entry<String, Integer> entry : mapToDisplay.entrySet()) {
        		System.out.print(entry.getValue());
        		System.out.println("=" + entry.getKey());
        	}
    	} else {
    		System.err.println("No line to display.");
    	}
    }
	
	/**
	 * Writes couples key-value contained into a Map<String, Integer> mapToWrite, provided as a parameter, into a file.
	 * The String part, which is the couple key, concerns the symptom to be written.
	 * The Integer part, which is the couple value, concerns the number of occurrence of this symptom.
	 * The lines are written as follows : symptom=numberOfOccurrenceOfIt .
	 * 
	 * @exception IOException : Signals that an I/O exception of some sort has occurred.
	 * @param mapToWrite : A Map<String, Integer> containing, as keys the symptoms, and, as values the number of occurrence for each symptom.
	 * */
	public void writeFile(Map<String, Integer> mapToWrite) {
		try {
			FileWriter writer = new FileWriter (path + "result.out");
			
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
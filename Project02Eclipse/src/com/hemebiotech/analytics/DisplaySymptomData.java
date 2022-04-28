package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Manages the displaying of symptom data and their number of occurrence, for each symptom, into the console.
 * */
public class DisplaySymptomData implements ISymptomDisplayer {

	// -------------------- METHODS --------------------
	@Override
    public void display(List<String> listToDisplay) {
		if(!listToDisplay.isEmpty()) {
			listToDisplay.forEach( K -> System.out.println(K) );//clés de la list
    	} else System.err.println("No line to display !!!");
	}
	
	@Override
    public void display(Map<String, Integer> mapToDisplay) {
		if(!mapToDisplay.isEmpty()) {
			mapToDisplay.entrySet().forEach( K -> System.out.println(K.getKey() + " " + K.getValue()) );//clés et valeurs de la map
    	} else System.err.println("No line to display !!!");
	}
	
}
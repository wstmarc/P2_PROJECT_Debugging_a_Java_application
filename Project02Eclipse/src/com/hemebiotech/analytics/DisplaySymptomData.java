package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Manages the displaying of symptom data and their number of occurrence, for each symptom, into the console.
 * */
public class DisplaySymptomData implements ISymptomDisplayer {

	// -------------------- METHODS --------------------
	@Override
    public void displayMap(Map<String, Integer> mapToDisplay) {
		mapToDisplay.keySet().forEach( K -> System.out.println(mapToDisplay.get(K)) );//valeurs
		mapToDisplay.entrySet().forEach( K -> System.out.println(K.getKey() + " " + K.getValue()) );//clés et valeurs de la map
//		if(!mapToDisplay.isEmpty()) {
//    		for(Map.Entry<String, Integer> entry : mapToDisplay.entrySet()) {
//        		System.out.print(entry.getValue());
//        		System.out.println("=" + entry.getKey());
//        	}
//    	} else {
//    		System.err.println("No line to display.");
//    	}
    }
	
}

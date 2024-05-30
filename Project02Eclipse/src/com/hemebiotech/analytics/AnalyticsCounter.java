package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AnalyticsCounter {

	public static void main(String args[]) {
		
		try {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		// list of symptoms
		ArrayList<String> symptomData = new ArrayList<String>();
		while (line != null) {
			symptomData.add(line); // add symptoms in listArrayList symptomData 
			line = reader.readLine();	// get another symptom
		}
		reader.close();
		
		// map <symptom,number of symptom found in symptomData >
		Map<String, Integer> symptomAndNumber = new HashMap<>();
        for (String symptom : symptomData) { // loop for each value in the list
            if (symptomAndNumber.containsKey(symptom)) { //if the symptom is already added to the collection we increment it by 1 else i add the symptom to the collection
            	symptomAndNumber.put(symptom, symptomAndNumber.get(symptom) + 1);
            } else {
            	symptomAndNumber.put(symptom, 1);
            }
        }
        
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		
        for (Map.Entry<String, Integer> entry : symptomAndNumber.entrySet()) { // loop that reads the entire collection
            writer.write(entry.getKey() + " : " + entry.getValue()+ "\n");
        }
		writer.close();
		
		}catch  (FileNotFoundException e) {
		    System.err.println("Fichier introuvable : " + e.getMessage());
		} catch (IOException e) {
		    System.err.println("Erreur de lecture du fichier : " + e.getMessage());
		} catch (Exception e) {
		    System.err.println("Erreur inattendue : " + e.getMessage());
		}
	}
}

	

	

package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/** 
 * This class defines a method that counts the number of occurrences of each symptom and a method that sorts symptoms alphabetically.
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/** 
	 * Create a constructor with an ISymptomReader object and an ISymptomWriter object as parameters.
	 * 
	 * Assign the values of these two parameters to two class attributes.
	 */
	public  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer= writer;
	}
	
	/** 
	 * Recovers the list of entries in the file using the ISymptomReader instance.
	 */
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
	/**
	 * Counts the occurrences of each symptom in the list.
	 * @param symptoms is the list of symptoms
	 * @return countSymptoms is a MAP that contains the symptom as a key and the number of occurrences of that symptom as a value.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> countSymptoms = new HashMap<>();
		for (String symptom :  symptoms) { 
			if (countSymptoms.containsKey(symptom)) { 
				countSymptoms.put(symptom, countSymptoms.get(symptom) + 1);
			} else {
				countSymptoms.put(symptom, 1);
			}
		}
		return countSymptoms;
	}
	
	/**
	 * Sorts symptoms and their occurrences alphabetically.
	 * @param symptoms is a MAP that contains the symptom as a key and the number of occurrences of that symptom as a value
	 * @return sortSymptoms is a MAP that contains the symptom as a key and the number of occurrences of that symptom as a value
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortSymptoms = new TreeMap<>(symptoms);
		return sortSymptoms; 
	}
	
	/**
	 * Writes the result to the output file using the ISymptomWriter instance.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
}
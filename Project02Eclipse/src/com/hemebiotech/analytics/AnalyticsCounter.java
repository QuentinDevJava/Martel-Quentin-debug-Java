package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer= writer;
	}
	
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
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
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortSymptoms = new TreeMap<>(symptoms);
		Map<String, Integer> sortSymptoms1 = new HashMap<String, Integer>();
		List<String> keys = new ArrayList<>(symptoms.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			sortSymptoms1.put(key , symptoms.get(key));
		}	
		return sortSymptoms; 
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
}












package com.hemebiotech.analytics;

import java.util.Map;
/**
 * The important part is the input MAP.
 * 
 * The "MAP" must contain the keys (symptoms sorted alphabetically) and values (number of occurrences of the symptom)
 * for writing the file named result.out.
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return an empty file result.out.
	 *  
	 * Writes all MAP keys and values in to file named result.out. One per line (keys : values).
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}


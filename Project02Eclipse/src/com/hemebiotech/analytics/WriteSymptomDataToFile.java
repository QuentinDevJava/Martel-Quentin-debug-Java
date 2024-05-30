package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile  implements ISymptomWriter{

	private String filepath;

	/**
	 * 
	 * @param filepath a complete or partial path to the output file
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;	
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter (filepath);
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { 
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

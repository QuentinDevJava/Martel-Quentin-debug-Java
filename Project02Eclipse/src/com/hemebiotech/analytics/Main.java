package com.hemebiotech.analytics;


public class Main {

	public static void main(String args[]){
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("Result.out");
		AnalyticsCounter analyticscounter = new AnalyticsCounter(reader , writer);
		analyticscounter.writeSymptoms(analyticscounter.sortSymptoms(analyticscounter.countSymptoms(analyticscounter.getSymptoms())));
	}
}

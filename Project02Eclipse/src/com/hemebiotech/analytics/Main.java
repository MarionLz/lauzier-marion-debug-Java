package com.hemebiotech.analytics;

/**
 * Main entry point for the application.
 * Reads symptom data from a file, counts occurrences, and writes the results to another file.
 */
public class Main {

	public static void main(String[] args) {

		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("resultat.out");
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
			
		analyticsCounter.writeSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
	}
}
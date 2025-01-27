package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Handles symptom data processing: reading, counting, and writing.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	/**
	 * Initializes with a reader and writer for symptom data.
	 * @param reader reads symptoms from a source
	 * @param writer writes symptoms and counts to a destination
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Reads symptoms from the source.
	 * @return a list of symptoms
	 */
	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}
	
	/**
	 * Counts occurrences of each symptom in a list.
	 * @param symptoms a list of symptoms
	 * @return a sorted map of symptoms and their counts
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> listSymptomsAndCount = new TreeMap<>();
		for (String symptom : symptoms) {
			listSymptomsAndCount.merge(symptom, 1, Integer::sum);
		}
		return listSymptomsAndCount;
	}
	
	/*
	 * Method to sort symptoms is commented out because the sort is already implemented in countSymptoms.
	 * 
	 * public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
	 *     return new TreeMap<>(symptoms);
	 * }
	 */
	
	/**
	 * Writes symptoms and their counts to the destination.
	 * @param symptoms a map of symptoms and counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		this.writer.writeSymptoms(symptoms);
	}
}


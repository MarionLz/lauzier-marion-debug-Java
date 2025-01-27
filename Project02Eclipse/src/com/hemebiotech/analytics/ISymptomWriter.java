package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data and their counts to a destination.
 */
public interface ISymptomWriter {

	/**
	 * Writes symptoms and their counts to a destination.
	 * @param symptoms a map where the key is the symptom name and the value is the count of occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
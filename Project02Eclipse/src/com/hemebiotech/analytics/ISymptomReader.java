package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptom data from a source.
 */
public interface ISymptomReader {

	/**
	 * Reads symptoms from a source.
	 * @return a list of symptoms, where each symptom is a string
	 */
	List<String> GetSymptoms();
}
package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data and their counts to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	/**
	 * Initializes the file writer with the specified file path.
	 * @param filepath the path to the file where symptom data will be written
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Writes symptoms and their counts to the specified file, one entry per line.
	 * Each line follows the format: "symptom, count".
	 * 
	 * @param symptoms a map of symptoms and their counts
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (FileWriter writer = new FileWriter(this.filepath)) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			    writer.write(entry.getKey() + ", " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

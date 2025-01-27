package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a file, each line representing a symptom.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Initializes the file reader with the specified file path.
	 * @param filepath the path to the file containing symptom data
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Reads symptoms from the file and returns them as a list.
	 * @return a list of symptoms, one per line in the file
	 */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter (this.filepath);
				
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			    String symptom = entry.getKey();
			    Integer nbOccurrence = entry.getValue();
			    writer.write(symptom + nbOccurrence + "\n");
			}
			
			//symptoms.forEach((symptom, nbOccurrence) -> {writer.write(symptom + nbOccurrence + "\n");});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

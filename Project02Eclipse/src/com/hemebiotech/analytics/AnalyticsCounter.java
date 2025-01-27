package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private static ISymptomReader reader;
	private static ISymptomWriter writer;
	
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() { 
		return this.reader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> listSymptomsAndCount = new TreeMap<String, Integer>();
		for(String symptom : symptoms) {
			listSymptomsAndCount.merge(symptom, 1, Integer::sum);
		}
		return listSymptomsAndCount;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		Map<String, Integer> sortedsymptoms = new TreeMap<String, Integer>(symptoms);
		return  sortedsymptoms;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		this.writer.writeSymptoms(symptoms);
	}
	
	public static void main(String args[]) throws Exception {
		
		/*
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}

package edu.csupomona.cs480.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvParser {

	public static String mapAll(){
		
		File folder = new File("src/main/resources/static/data/parks");
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			
		      if (listOfFiles[i].isFile()) {
		    	  run(listOfFiles[i].getPath());
		      } 
		      
		    }
		
		return "hello";
	}
	
  public static void run(String filename) {

		String csvFile = filename;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		Map<String, String[]> parkMap = new HashMap<String, String[]>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] month = line.split(cvsSplitBy);
				String key = month[1].concat(month[2]).concat(month[3]);
				parkMap.put(key, month);
			}
			
			for (Map.Entry<String, String[]> entry : parkMap.entrySet()) {
				System.out.printf(entry.getKey() + ": ");
				System.out.printf(entry.getValue()[5] + "\n");
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
  }
}

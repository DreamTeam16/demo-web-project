package edu.csupomona.cs480.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser {
	
	public static ArrayList<ParkData> parseAll(){
				
		File folder = new File("src/main/resources/static/data/parks");
		File[] listOfFiles = folder.listFiles();
		ArrayList<ParkData> parks = new ArrayList<ParkData>();
		
		//parse each file in data/parks folder
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  run(parks, listOfFiles[i].getPath());
		      }       
		}
		
		for (int i = 0; i < parks.size(); i++) {
			System.out.println(parks.get(i).getName());
			System.out.println(parks.get(i).getRecVisitors()[4]);
		}
		
		return parks;
	}
	
  public static void run(ArrayList<ParkData> parks, String filename) {

		String csvFile = filename;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ParkData park = new ParkData();	
		int numYears = 10;
		int counter = 0;
		int[] recVisitors = new int[13]; 
		
		for(int i = 0; i < 13; i++){
			recVisitors[i] = 0;
		}
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			//parse park csv data line by line
			while ((line = br.readLine()) != null) {
				String[] month = line.split(cvsSplitBy);
				
				if(counter == 0)					
					park.setName(month[1]);
				
				//generate totals for each category for each month
				switch(month[3]) 
				{
					case "January" :
						recVisitors[1] += Integer.parseInt(month[4]);
						break;
						
					case "February" :
						recVisitors[2] += Integer.parseInt(month[4]);
						break; 
						
					case "March" :
						recVisitors[3] += Integer.parseInt(month[4]);
						break;
						
					case "April" :
						recVisitors[4] += Integer.parseInt(month[4]);
						break;
						
					case "May" :
						recVisitors[5] += Integer.parseInt(month[4]);
						break;
						
					case "June" :
						recVisitors[6] += Integer.parseInt(month[4]);
						break;
						
					case "July" :
						recVisitors[7] += Integer.parseInt(month[4]);
						break;
						
					case "August" :
						recVisitors[8] += Integer.parseInt(month[4]);
						break;
						
					case "September" :
						recVisitors[9] += Integer.parseInt(month[4]);
						break;
						
					case "October" :
						recVisitors[10] += Integer.parseInt(month[4]);
						break;
						
					case "November" :
						recVisitors[11] += Integer.parseInt(month[4]);
						break;
						
					case "December" :
						recVisitors[12] += Integer.parseInt(month[4]);
						break;
				}
								
				
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
		
		//generate averages for each month for each category
		for(int i = 0; i < 13; i++){
			recVisitors[i] = recVisitors[i] / numYears;
		}
		
		//add park object to arrayList
		park.setRecVisitors(recVisitors);
		parks.add(park);
		
  }
}

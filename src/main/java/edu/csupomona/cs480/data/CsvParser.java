package edu.csupomona.cs480.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser {
	
	//generates all CSV files for charts
	public static void generateAllCSV(ArrayList<ParkData> parks) {
		for (int i = 0; i < parks.size(); i++) {
			generateCSV(parks, i);
		}
	}
	
	//generate single CSV file for chart
	public static void generateCSV(ArrayList<ParkData> parks, int index){
		
		for (int i = 0; i < parks.size(); i++) {
			System.out.println("park name: " + parks.get(i).getName());
			System.out.println("visitors in april: " + parks.get(i).getRecVisitors()[4]);
		} 
		
		String fileName = "src/main/resources/static/data/parks/chart-data/visitor-data/";
		fileName = fileName.concat(parks.get(index).getName()).concat(".csv");			
		
		System.out.println(parks.get(index).getName());
		System.out.println(fileName);
		
		try {
			FileWriter writer = new FileWriter(fileName);
			System.out.println("success");
			
			writer.append("Average Monthly Visitors\n");
			writer.append("null\n");
			
			for(int i = 1; i < 13; i++) {
				writer.append(Integer.toString(parks.get(index).getRecVisitors()[i]));
				if(i != 12)
					writer.append("\n");
			}

			writer.flush();
			writer.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}
	
	public static ArrayList<ParkData> parseAll(){
				
		File folder = new File("src/main/resources/static/data/parks");
		File[] listOfFiles = folder.listFiles();
		ArrayList<ParkData> parks = new ArrayList<ParkData>();
		
		//parse each file in data/parks folder
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  parsePark(parks, listOfFiles[i].getPath());
		      }       
		}
		
		for (int i = 0; i < parks.size(); i++) {
			System.out.println(parks.get(i).getName());
			System.out.println(parks.get(i).getRecVisitors()[4]);
		}
		
		return parks;
	}
	
  public static void parsePark(ArrayList<ParkData> parks, String filename) {

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

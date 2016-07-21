package edu.csupomona.cs480.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherParser {
	
	//public static void main(String[] args) {
	//	parseParkWeather("Arches National Park");
	//}
	
	public static  void parseParkWeather(ParkData park) {
		
		int[] highs = new int[12];
		int[] lows = new int[12];
		String parkName= park.getName();
		String line = "";
		
		BufferedReader br = null;

		String csvFile = "src/main/resources/static/data/parks/chart-data/weather-data/" + parkName + ".csv";
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			for(int i = 0; i < 1; ++i) 
				  br.readLine();
			
			int i = 0;
			while ((line = br.readLine()) != null) {
					String[] temp = line.split(",");
					highs[i] = Integer.parseInt(temp[0]);
					lows[i] = Integer.parseInt(temp[1].trim());
				//	System.out.println("High: " + highs[i] + " Lows: " + lows[i]);
					i++;	
			}
			
			park.setHighWeather(highs);
			park.setLowWeather(lows);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
/*
	public static void OlympicWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/port-angeles/washington/united-states/uswa0346").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Olympic National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void PetrifiedForestWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/petrified-forest/arizona/united-states/usaz0164").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Petrified Forest National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void PinnaclesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/king-city/california/united-states/usca0544").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Pinnacles National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void RedwoodWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/crescent-city/california/united-states/usca1878").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Redwood National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void RockyMountainWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/estes-park/colorado/united-states/usco0130").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Rocky Mountain National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void SaguaroWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/tucson/arizona/united-states/usaz0247").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Saguaro National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void SequoiaWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/three-rivers/california/united-states/usca1555").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Sequoia National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ShenandoahWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/luray/virginia/united-states/usva0451").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Shenandoah National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void TheodoreRooseveltWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/medora/north-dakota/united-states/usnd0234").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Theodore Roosevelt National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void VirginIslandsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/miami/florida/united-states/usfl0316").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Virgin Islands National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void VoyageursWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/international-falls/minnesota/united-states/usmn0376").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Voyageurs National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WindCaveWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/hot-springs/south-dakota/united-states/ussd0156").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Wind Cave National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WrangellWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/wrangell/alaska/united-states/usak0268").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Wrangell St. Elias National Park and Preserve.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void YellowstoneWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/yellowstone-national-park/wyoming/united-states/uswy0292").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Yellowstone National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ZionWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/hurricane/utah/united-states/usut0343").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Zion National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Acadia,badlands, biscayne, black canyon, bryce canyon, canyonlands,  weather not available on usclimatedata site
	
	public static void GrandCanyonWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/grand-canyon/arizona/united-states/usaz0088").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Grand Canyon National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GrandTetonWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/moose/wyoming/united-states/uswy0122").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Grand Teton National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GreatBasinWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/garrison/utah/united-states/usut0088").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Great Basin National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GreatSandDunesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/blanca/colorado/united-states/usco0452").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Great Sand Dunes National Park and Preserve.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GreatSmokyMountainsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/gatlinburg/tennessee/united-states/ustn0196").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Great Smoky Mountains National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GuadalupeMountainsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/dell-city/texas/united-states/ustx0349").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Guadalupe Mountains National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void HaleakalaWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/haleakala/hawaii/united-states/ushi0103").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Haleakala National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void HawaiiVolcanoesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/hawaii-natl-park/hawaii/united-states/ushi0019").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Hawaii Volcanoes National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void HotSpringsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/malvern/arkansas/united-states/usar0352").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Hot Springs National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void IsleRoyaleWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/copper-harbor/michigan/united-states/usmi1249").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Isle Royale National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void KatmaiWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/iliamna/alaska/united-states/usak0114").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Katmai National Park and Preserve.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void KenaiFjordsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/seward/alaska/united-states/usak0216").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Kenai Fjords National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void KingsCanyonWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/three-rivers/california/united-states/usca1555").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Kings Canyon National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void KobukValleyWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/kotzebue/alaska/united-states/usak0135").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Kobuk Valley National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void LakeClarkWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/iliamna/alaska/united-states/usak0114").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Lake Clark National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void LassenVolcanicWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/mineral/california/united-states/usca0707").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Lassen Volcanic National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void MammothCaveWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/mammoth-cave/kentucky/united-states/usky1113").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Mammoth Cave National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void MesaVerdeWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/mesa-verde-national-park/colorado/united-states/usco0640").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Mesa Verde National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void MountRainierWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/ashford/washington/united-states/uswa0555").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Mount Rainier National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void AmericanSamoaWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/honolulu/hawaii/united-states/ushi0026").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/National Park of American Samoa.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void NorthCascadesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/sedro-woolley/washington/united-states/uswa0398").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/North Cascades National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CongareeWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/sumter/south-carolina/united-states/ussc0333").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Congaree National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CraterLakeWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/chemult/oregon/united-states/usor0062").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Crater Lake National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CuyahogaValleyWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/akron/ohio/united-states/usoh0008").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Cuyahoga Valley National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeathValleyWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/death-valley/california/united-states/usca0286").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Death Valley National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void DenaliWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/talkeetna/alaska/united-states/usak0236").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Denali National Park & Preserve.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void DryTortugasWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/key-west/florida/united-states/usfl0244").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Dry Tortugas National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void EvergladesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/homestead/florida/united-states/usfl0208").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Everglades National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GatesofArcticWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/bettles/alaska/united-states/usak0029").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Gates of the Arctic National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GlacierBayWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/haines/alaska/united-states/usak0101").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Glacier Bay National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GlacierWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/west-glacier/montana/united-states/usmt0352").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Glacier National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ChannelIslandsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/oxnard/california/united-states/usca0819").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Channel Islands National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void CarlsbadCavernsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/carlsbad/new-mexico/united-states/usnm0046").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Carlsbad Caverns National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CanyonlandsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/moab/utah/united-states/usut0165").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Canyonlands National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BryceCanyonWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/tropic/utah/united-states/usut0260").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Bryce Canyon National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BlackCanyonWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/gunnison/colorado/united-states/usco0175").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Black Canyon of the Gunnison National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void AcadiaWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/mount-desert/maine/united-states/usme0688").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Acadia National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String ArchesWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];

		String temp = "";
		String lowtemps = "";
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/arches-natl-park/utah/united-states/usut0010").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Arches National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i]; 
				lowtemps += lows[i];
				fw.write(highs[i] + ", " + lows[i] + "\n");
				if (i != highs.length-1) {
					temp += ", ";
					lowtemps += ", ";
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Arches National Park Weather for Each Month \nHighs: " + temp + "\n" + "Lows: " + lowtemps;
	}
	
	public static void BadlandsWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/interior/south-dakota/united-states/ussd0166").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Badlands National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BiscayneWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/homestead/florida/united-states/usfl0208").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Biscayne National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void CapitolReefWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/capitol-reef-natl-park/utah/united-states/usut0036").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Capitol Reef National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				fw.write(highs[i] + ", " + lows[i] + "\n");  
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String BigBendWeather() {
		String[] highs = new String[12];
		String[] lows = new String[12];

		String temp = "";
		String lowtemps = "";
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/big-bend-national-park/texas/united-states/ustx2354").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Big Bend National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i]; 
				lowtemps += lows[i];
				fw.write(highs[i] + ", " + lows[i] + "\n");
				if (i != highs.length-1) {
					temp += ", ";
					lowtemps += ", ";
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Big Bend National Park Weather for Each Month \nHighs: " + temp + "\n" + "Lows: " + lowtemps;
	}
	
	//Parse Joshua Tree Weather highs/lows
	public static String JSTreeWeatherParser() {
		String[] highs = new String[12];
		String[] lows = new String[12];

		String temp = "";
		String lowtemps = "";
 
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/joshua-tree/california/united-states/usca1645").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Joshua Tree National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i]; 
				lowtemps += lows[i];
				fw.write(highs[i] + ", " + lows[i] + "\n");
				if (i != highs.length-1) {
					temp += ", ";
					lowtemps += ", ";
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Joshua Tree Weather for Each Month \nHighs: " + temp + "\n" + "Lows: " + lowtemps;
	}
	
	 
	public static String yosemiteWeatherParser() {
		String[] highs = new String[12];
		String[] lows = new String[12];
		
		String temp = "";
		String lowtemps = "";
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/yosemite-natl-park/california/united-states/usca1269").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = hightemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = coldtemp.text();
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 } 
			 i = 0;
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Yosemite National Park.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Average Monthly Weather\n");
			fw.write("null\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i]; 
				lowtemps += lows[i];
				fw.write(highs[i] + ", " + lows[i] + "\n");
				if (i != highs.length-1) {
					temp += ", ";
					lowtemps += ", ";
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Yosemite Weather for Each Month \nHighs: " + temp + "\n" + "Lows: " + lowtemps;
	}
*/
}

package edu.csupomona.cs480.data;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherParser {
	 
	public static void main(String[] args) {
		String bigbend = BigBendWeather();
		CapitolReefWeather();
		System.out.println(bigbend);
		String arches = ArchesWeather();
		System.out.println(arches);
		String jt = JSTreeWeatherParser();
		System.out.println(jt);
		String yose = yosemiteWeatherParser();
		System.out.println(yose);
	}
	
	//Acadia,badlands, biscayne, black canyon, bryce canyon, canyonlands,  weather not available on usclimatedata site
	
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

}

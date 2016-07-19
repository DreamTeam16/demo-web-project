package edu.csupomona.cs480.data;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherParser {
	
	public int[] highs;
	public int[] lows;
//	public static void main(String[] args) {
//		JSTreeWeatherParser();
//		yosemiteWeatherParser();
//	}
	
	//Parse Joshua Tree Weather highs/lows
	public String JSTreeWeatherParser() {
		int[] highs = new int[12];
		int[] lows = new int[12];

		String temp = "";
		String lowtemps = "";

		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/joshua-tree/california/united-states/usca1645").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				 highs[i] = Integer.parseInt(hightemp.text());
				 System.out.println(highs[i]);
//	         	System.out.println("#" + i + ": " + hightemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = Integer.parseInt(coldtemp.text());
//	         	System.out.println("#" + i + ": " + coldtemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 i = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Joshua Tree.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("January, February, March, April, May, June, July, August, September, October, November, December\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i];
				if (i != highs.length-1) {
					temp += ", ";
				}
			}
//			System.out.println(temp);
			fw.write(temp + "\n");
			for (int i = 0; i < lows.length; i++) {
				lowtemps += lows[i];
				if (i != highs.length-1) {
					lowtemps += ", ";
				}
			}
			fw.write(lowtemps);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Highs: " + temp + "\n" + "Lows: " + lowtemps;
	}
	
	 
	public String yosemiteWeatherParser() {
		int[] highs = new int[12];
		int[] lows = new int[12];
		
		String temp = "";
		String lowtemps = "";
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/yosemite-natl-park/california/united-states/usca1269").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
				highs[i] = Integer.parseInt(hightemp.text());
//	         	System.out.println("#" + i + ": " + hightemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
				lows[i] = Integer.parseInt(coldtemp.text());
//	         	System.out.println("#" + i + ": " + coldtemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 this.highs=highs;
			 this.lows=lows;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*String fileName = "src/main/resources/static/data/parks/chart-data/weather-data/Yosemite.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("January, February, March, April, May, June, July, August, September, October, November, December\n");
			for (int i = 0; i < highs.length; i++) {
				temp += highs[i];
				if (i != highs.length-1) {
					temp += ", ";
				}
			}
			fw.write(temp + "\n");
			for (int i = 0; i < lows.length; i++) {
				lowtemps += lows[i];
				if (i != lows.length-1) {
					lowtemps += ", ";
				}
			}
			fw.write(lowtemps);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		return "Highs: " + temp + "\n" + "Lows: " + lowtemps;
	}

}

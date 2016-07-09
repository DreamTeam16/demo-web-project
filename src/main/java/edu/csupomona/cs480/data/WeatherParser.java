package edu.csupomona.cs480.data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherParser {
	
	//Parse Joshua Tree Weather highs/lows
	public static void JSTreeWeatherParser() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/joshua-tree/california/united-states/usca1645").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
	         	System.out.println("#" + i + ": " + hightemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
	         	System.out.println("#" + i + ": " + coldtemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void yosemiteWeatherParser() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.usclimatedata.com/climate/yosemite-natl-park/california/united-states/usca1269").get();
			Elements highTemperatures = doc.select("td.align_right.temperature_red");
			Elements lowTemperatures = doc.select("td.align_right.temperature_blue");
			
			int i = 0;
			 for (Element hightemp : highTemperatures) {
	         	System.out.println("#" + i + ": " + hightemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
			 
			 i = 0;
			 for (Element coldtemp : lowTemperatures) {
	         	System.out.println("#" + i + ": " + coldtemp.text());
	         	i++;
	         	if (i == 12) {
	         		break;
	         	}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

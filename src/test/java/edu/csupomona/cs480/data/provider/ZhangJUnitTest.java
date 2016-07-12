package edu.csupomona.cs480.data.provider;

import org.junit.Test;
import org.junit.Assert;

import edu.csupomona.cs480.data.WeatherParser;


public class ZhangJUnitTest {

	private WeatherParser wp;
	
	@Test
	public void testJoshuaTreeWeather() {
		wp = new WeatherParser();
		String jst = "Highs: 60, 64, 70, 77, 86, 95, 100, 99, 93, 82, 69, 60" + "\n" + "Lows: 37, 39, 42, 45, 54, 60, 69, 68, 64, 52, 43, 35";
		Assert.assertEquals(wp.JSTreeWeatherParser(), jst);
	}
	

	@Test
	public void testYosemiteWeather() {
		wp = new WeatherParser();
		String yose = "Highs: 48, 51, 58, 64, 71, 81, 89, 89, 82, 71, 56, 47" + "\n" + "Lows: 29, 30, 34, 38, 45, 51, 57, 56, 51, 42, 33, 28";
		Assert.assertEquals(wp.yosemiteWeatherParser(), yose);
	}
}

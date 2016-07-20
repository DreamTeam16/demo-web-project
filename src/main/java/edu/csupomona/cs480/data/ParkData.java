package edu.csupomona.cs480.data;

public class ParkData {

	private String name;
	private int[] recVisitors;
	private int[] highs;
	private int[] lows;
	
	public void setName(String parkName){
		this.name = parkName;
	}
	
	public void setRecVisitors(int[] ary){
		this.recVisitors = ary;
	}
	
	public int[] getRecVisitors(){
		return recVisitors;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHighWeather(int[] array) {
		this.highs = array;
	}
	
	public void setLowWeather(int[] array) {
		this.lows = array;
	}
	
	public int[] getHighs() {
		int temps[] = { 60, 64, 70, 77, 86, 95, 100, 99, 93, 82, 69, 60 };
		return temps;
		//return highs;
	}
	
	public int[] getLows() {
		int temps[] = { 40, 44, 50, 57, 66, 75, 80, 79, 73, 62, 49, 40 };
		return temps;
		//return lows;
	}
}

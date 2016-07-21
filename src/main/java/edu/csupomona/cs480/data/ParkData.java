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
		return highs;
	}
	
	public int[] getLows() {
		return lows;
	}
}

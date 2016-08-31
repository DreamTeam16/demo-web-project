package edu.csupomona.cs480.data;

public class ParkData {

	private String name;
	private String description;
	private String location;
	private String imageURL;
	private String imageCredit;
	private int[] recVisitors;
	private int[] highs;
	private int[] lows;
	
	public void setName(String parkName){
		this.name = parkName;
	}
	
	public void setRecVisitors(int[] ary){
		this.recVisitors = ary;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	public void setLocation(String loc){
		this.location = loc;
	}
	
	public void setImageURL(String url){
		this.imageURL = url;
	}

	public void setImageCredit(String credit){
		this.imageCredit = credit;
	}
	
	public String getImageCredit(){
		return imageCredit;
	}
	
	public String getImageURL(){
		return imageURL;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getDescription(){
		return description;
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

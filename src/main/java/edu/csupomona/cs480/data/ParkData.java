package edu.csupomona.cs480.data;

public class ParkData {

	private String name;
	private int[] recVisitors;  
	
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
}

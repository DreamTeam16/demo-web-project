package edu.csupomona.cs480.data;

public class WeightedRankings {
	String name;
	int prefCrowds;
	int prefTemp;
	int prefWeight;
	
	
	public WeightedRankings(String parkName, int prefCrowds, int prefTemp, int prefWeight){
		
		name=parkName;
		this.prefCrowds=prefCrowds;
		this.prefTemp=prefTemp;
		this.prefWeight=prefWeight;
	
		
	}

}

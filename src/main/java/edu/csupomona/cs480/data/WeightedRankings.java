package edu.csupomona.cs480.data;

import java.util.Arrays;
import java.util.Collections;

public class WeightedRankings {
	public String name;
	int prefCrowds;
	int prefTemp;
	int prefWeight;
	ParkData park;
	public String month;
	int tempWeight;
	int crowdsWeight;
	
	
	public WeightedRankings(ParkData park, int prefCrowds, int prefTemp, int prefWeight)
	{
		this.park=park;
		name=park.getName();
		this.prefCrowds=prefCrowds;
		this.prefTemp=prefTemp;
		this.prefWeight=prefWeight;	
	}
	
	public void getWeight()
	{
		//slider all the way temp
		if (prefWeight == 1){
			tempWeight = 12;
			crowdsWeight = 1;
		}
		//slider closer to temp side
	else if (prefWeight < 6)
		{
			tempWeight = 12 - prefWeight;
			crowdsWeight = 12 - tempWeight;
		}
		//slider in middle
		else if (prefWeight == 6) {
			tempWeight = 6;
			crowdsWeight = 6;
		}
		//slider closer to crowd side
		else if (prefWeight <12){
			crowdsWeight = prefWeight;
			tempWeight = 13 - crowdsWeight;
	}
	//slider all the way to crowds
		else{
			crowdsWeight = 12;
			tempWeight = 1;
		}
		
	}
	
	public void getRankings()
	{
		DensityAlg den= new DensityAlg(park, prefCrowds);
		TempAlg temp=new TempAlg(park,prefTemp);
		int[] rank=new int[12];
		getWeight();
		if(prefCrowds>80)
		{
			crowdsWeight=0;
		}
		String[] density=den.getDensityRankings();
		String[] tRank=temp.Rankings();
		
		for(int x=0;x<12;x++)
		{
			for(int i=0;i<12;i++)
			{
				if(density[x].equals(tRank[i]))
				{
					switch (density[x])
					{
					case "Janurary":rank[0]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "Feburary":rank[1]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "March":rank[2]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "April":rank[3]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "May":rank[4]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "June":rank[5]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "July":rank[6]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "August":rank[7]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "September":rank[8]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "October":rank[9]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "November":rank[10]=(x*crowdsWeight)+(i*tempWeight);
					break;
					case "December":rank[11]=(x*crowdsWeight)+(i*tempWeight);
					break;
					
					}
				}
					
			}
		}
		int highest=0;
		for(int i=1;i<12;i++)
		{
			if(rank[highest]<rank[i])
				highest=i;
				
		}
		
		switch (highest)
		{
		case 1: month="Janurary";
		break;
		case 2: month="Feburary";
		break;		
		case 3: month="March";
		break;
		case 4:month="April";
		break;
		case 5:month="May";
		break;
		case 6: month="June";
		break;
		case 7: month="July";
		break;
		case 8: month="August";
		break;
		case 9: month="September";
		break;
		case 10: month="October";
		break;
		case 11: month="November";
		break;
		case 12: month="December";
		break;
				
		default: month="TESTING";
		break;
		}
		
	}

}

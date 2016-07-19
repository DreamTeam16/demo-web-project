package edu.csupomona.cs480.data;

import java.util.Arrays;
import java.util.Collections;

public class WeightedRankings {
	String name;
	int prefCrowds;
	int prefTemp;
	int prefWeight;
	ParkData park;
	public String month;
	
	
	public WeightedRankings(ParkData park, int prefCrowds, int prefTemp, int prefWeight)
	{
		this.park=park;
		name=park.getName();
		this.prefCrowds=prefCrowds;
		this.prefTemp=prefTemp;
		this.prefWeight=prefWeight;	
	}
	
	public void getRankings()
	{
		DensityAlg den= new DensityAlg(park, prefCrowds);
		TempAlg temp=new TempAlg(park,prefTemp);
		int[] rank=new int[12];
		if(prefCrowds>80)
		{
			//code for weights to change in favor of weather as crowds do not matter as much
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
					case "Janurary":rank[0]=x+i;
					break;
					case "Feburary":rank[1]=x+i;
					break;
					case "March":rank[2]=x+i;
					break;
					case "April":rank[3]=x+i;
					break;
					case "May":rank[4]=x+i;
					break;
					case "June":rank[5]=x+i;
					break;
					case "July":rank[6]=x+i;
					break;
					case "August":rank[7]=x+i;
					break;
					case "September":rank[8]=x+i;
					break;
					case "October":rank[9]=x+i;
					break;
					case "November":rank[10]=x+i;
					break;
					case "December":rank[11]=x+i;
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

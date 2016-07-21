package edu.csupomona.cs480.data;

import java.util.Arrays;
import java.util.Collections;

public class WeightedRankings {
	public String name;
	int prefCrowds;
	int prefTemp;
	double prefWeight;
	ParkData park;
	public String[] month=new String[3];
	double tempWeight;
	double crowdsWeight;
	
	
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
		
		
		System.out.println("prefWeight: "+ prefWeight);
		//slider all the way to crowds
		if (prefWeight == 1){
			crowdsWeight =  12;
			tempWeight =  1;
		}
		//slider closer to crowds side
	else if (prefWeight < 6)
		{
		
			crowdsWeight =12 - prefWeight;
			tempWeight =  (12 - crowdsWeight);
			
		}
		//slider in middle
		else if (prefWeight == 6) {
			crowdsWeight =  6;
			tempWeight =  6;

		}
		//slider closer to temp side
		else if (prefWeight <12){
			tempWeight = prefWeight;
			crowdsWeight =  (12 - tempWeight);

	}
	//slider all the way to temp
		else{
			tempWeight =  12;
			crowdsWeight =  1;
		}
		tempWeight=tempWeight/10;
		crowdsWeight=crowdsWeight/10;
	}
	
	public void getRankings()
	{
		DensityAlg den= new DensityAlg(park, prefCrowds);
		TempAlg temp=new TempAlg(park,prefTemp);
		double[] rank=new double[12];
		getWeight();
		if(prefCrowds>10)
		{
			crowdsWeight= .1;
			tempWeight+=.1;
		}
		System.out.println("crowds:"+crowdsWeight+"temps:"+tempWeight);
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
		int[] ranked={0,1,2};
		
		for(int i=0;i<12;i++)
		{System.out.println(rank[i]);
		
		System.out.println("Highgest "+rank[ranked[2]]+"new value "+rank[i]);
			if(rank[ranked[2]]<=rank[i])
				{
				ranked[0]=ranked[1];
				ranked[1]=ranked[2];
				ranked[2]=i;
				}
			
				
		//	System.out.println(rank[highest]);
				
		}
		for(int i=0;i<3;i++)
		{
			switch (ranked[i])
			{
			case 0: month[i]="Janurary";
			break;
			case 1: month[i]="Feburary";
			break;		
			case 2: month[i]="March";
			break;
			case 3:month[i]="April";
			break;
			case 4:month[i]="May";
			break;
			case 5: month[i]="June";
			break;
			case 6: month[i]="July";
			break;
			case 7: month[i]="August";
			break;
			case 8: month[i]="September";
			break;
			case 9: month[i]="October";
			break;
			case 10: month[i]="November";
			break;
			case 11: month[i]="December";
			break;
					
			default: month[i]="TESTING";
			break;
			}
			
		}
	}

}

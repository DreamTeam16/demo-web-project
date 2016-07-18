package edu.csupomona.cs480.data;
import java.util.*;
import java.lang.Math;
public class DensityAlg {
	 ParkData current;
	 String name;
	 int[] visitors;
	 int userPref;
	 String month;
	 
	 public DensityAlg(ParkData park,int userPref )
	 {
		current= park;
		visitors=park.getRecVisitors();
		this.userPref=userPref;
		month="FAIL";
		getMean();
	 
	 }
	 
	 private void getMean()
	 {
		 for(int i=0; i<visitors.length; i++)
		 {
			 visitors[i]=visitors[i]/10;
		 }
	 }
	 private int getPref()
	 {
		 int[] rSort= visitors.clone();
		 Arrays.sort(rSort);
		 return rSort[userPref];
		
		 
	 }
	 
	 
	 public void getDensityRankings() // Suppose to be string array testing right now.
	 {
		 int pref=getPref();
		 int[] differences= new int[13];
		 String [] rankings = new String[13];
		 for(int i=1;i<13;i++)
		 {
			 
			 differences[i]=visitors[i]-pref;
			 differences[i]=Math.abs(differences[i]);
		 }
		 
		int[] cDifferences=differences.clone();
		Arrays.sort(cDifferences);
		for(int i=1;i<13;i++)
		{
			for(int x=1;x<13;x++)
			{
				if(cDifferences[i]==differences[x])
				{
					switch (x)
					{
					case 1: rankings[i]="Janurary";
							break;
					
					case 2: rankings[i]="Feburary";
							break;
					
					case 3: rankings[i]="March";
							break;
					case 4:rankings[i]="April";
							break;
					case 5:rankings[i]="May";
							break;
					case 6: rankings [i]="June";
							break;
					default: rankings [i]="TESTING";
					break;
					}
					break;
				}
			}
		}
		 month=rankings[1];
		 System.out.println(month);
		 //return rankings;
	 }


}

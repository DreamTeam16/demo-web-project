package edu.csupomona.cs480.data;
import java.util.*;
import java.lang.Math;
public class DensityAlg {
	 ParkData current;
	 public	 String name;
	 int[] visitors;
	 float[] average;
	 int userPref;
	 public	 String month;
	 
	 public DensityAlg(ParkData park,int userPref )
	 {
		current= park;
		average= new float[13];
		name=current.getName();
		visitors=park.getRecVisitors();
		this.userPref=userPref;
		month="FAIL";
		getMean();
	 
	 }
	 
	 private void getMean()
	 {
		 for(int i=0; i<visitors.length; i++)
		 {
			 average[i]=(float)visitors[i]/10;
		 }
	 }
	 private float getPref()
	 {
		 float[] rSort= average.clone();
		 Arrays.sort(rSort);
		 return rSort[userPref];
		
		 
	 }
	 /*
	 private float stdDev()
	 {
		float mean= stdMean();
		
		for(int i=1;i<13;i++)
		{
			
		}
		 
	 }
	 
	 private float stdMean()
	 {
		 float mean=0;
		 for(int i=1;i<average.length;i++)
		 {
			 mean=+average[i];
		 }
		 
		 return (mean/12);
	 }
	 */
	 
	 public String[] getDensityRankings() // Suppose to be string array testing right now.
	 {
		 float pref=getPref();
		 float[] differences= new float[13];
		 String [] rankings = new String[13];
		 //System.out.println("This is user pref:"+pref);
		 for(int i=1;i<13;i++)
		 {
			 //System.out.println("Average:"+average[i]);
			 differences[i]=average[i]-pref;
			 differences[i]=Math.abs(differences[i]);
			 //System.out.println("Difference: "+differences[i]);

		 }
		 
		float[] cDifferences=differences.clone();
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
					case 7: rankings [i]="July";
					break;
					case 8: rankings [i]="August";
					break;
					case 9: rankings [i]="September";
					break;
					case 10: rankings [i]="October";
					break;
					case 11: rankings [i]="November";
					break;
					case 12: rankings [i]="December";
					break;
							
					default: rankings [i]="TESTING";
					break;
					}
					break;
				}
			}
		}
		 month=rankings[1];
		 Collections.reverse(Arrays.asList(rankings));
		 for(int x=0;x<12;x++)
		 System.out.println(rankings[x]);
		 return rankings;
	 }


}

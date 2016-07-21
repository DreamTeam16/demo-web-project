package edu.csupomona.cs480.data;

import java.util.Arrays;
import java.util.Collections;

public class TempAlg {
	
	int temps[] = { 60, 64, 70, 77, 86, 95, 100, 99, 93, 82, 69, 60 };
	int target = 75;
	int tempsDiff[] = new int[12]; // seasonal
	double tempsScore[] = new double[12];
	double sDev;
	public String month;
	
	public void algDriver(){
		calcDiff();
		calcScore();
		calcStdDev();
		calcScore();
		//tempToString();
	}

	//for testing
	public void tempToString(){
		for(int i : temps) {
			System.out.print(i+", ");
		}
		System.out.println();
		for(int i : tempsDiff) {
			System.out.print(i+", ");
		}
		System.out.println();
		for(double i : tempsScore) {
			System.out.print(i+", ");
		}
		System.out.println();
		
	}
	
	
	public TempAlg(int[] temps, int target){
		this.temps = temps;
		this.target = target;		
	}
	
	public TempAlg() {
		// TODO Auto-generated constructor stub
	}
	
	public TempAlg(ParkData park,int userPref) {
		int [] highs=park.getHighs();
		int [] lows=park.getLows();
		target=userPref;
		
		//average temperature
		for (int i = 0; i<12; i++) {
		temps[i] = (highs[i] + lows[i])/2;
		}
		//old seasonal difference code
		/* for (int i = 0; i<12; i++) {
			if (5 < i && i < 11) // summer
			{
				temps[i] = highs[i];// should be highs
			} else // winter
				temps[i] = lows[i];// should be lows
		} */
		
	}

	//calculates the difference from target
	// highs? lows?
	void calcDiff() {

		for (int i = 0; i<12; i++) {
			if (6 > i && i < 9) // summer
			{
				tempsDiff[i] = Math.abs(temps[i] - target);// should be highs
			} else // winter
				tempsDiff[i] = Math.abs(temps[i] - target);// should be lows
		}

	}
	
	void calcScore() {
		for(int i =0; i<12; i++){
			tempsScore[i] = tempsDiff[i]/sDev;
		}
	}

	 void calcStdDev() {
		 double mean = mean(tempsDiff);
		 double a[] = new double[12];
		 for (int i = 0; i<12; i++) {
			a[i] = Math.pow((tempsDiff[i] - mean), 2);
		}
		 double sum=0;
		 for (double i : a){
			 sum+= i;
		 }
		 sDev = Math.sqrt(sum/12);
	}

	private double mean(int[] arr) {
		double mean = 0;
		for (int i : arr) {
			mean += i;
		}
		return (mean / 12);
	}
	
	public String[] Rankings()
	{
		 String [] rankings = new String[12];
		 algDriver();
		 
		for (int i=0;i<12;i++)
		{
			for(int x=i+1;x<12;x++)
			{
				if(tempsScore[x]==tempsScore[i])
				{
					tempsScore[x]=tempsScore[x]+.00000000000001;
				}	
			}
		}
		double[] cDifferences=tempsScore.clone();
		Arrays.sort(cDifferences);
		for(int i=0;i<12;i++)
		{
			for(int x=0;x<12;x++)
			{
				if(cDifferences[i]==tempsScore[x])
				{
					switch (x)
					{
					case 0: rankings[i]="Janurary";
					break;
					case 1: rankings[i]="Feburary";
					break;		
					case 2: rankings[i]="March";
					break;
					case 3:rankings[i]="April";
					break;
					case 4:rankings[i]="May";
					break;
					case 5: rankings [i]="June";
					break;
					case 6: rankings [i]="July";
					break;
					case 7: rankings [i]="August";
					break;
					case 8: rankings [i]="September";
					break;
					case 9: rankings [i]="October";
					break;
					case 10: rankings [i]="November";
					break;
					case 11: rankings [i]="December";
					break;
							
					default: rankings [i]="TESTING";
					break;
					}
					break;
				}
			}
		}
		
		 Collections.reverse(Arrays.asList(rankings));
		 month=rankings[11];
		 //for(int x=0;x<12;x++)
		 //System.out.println(rankings[x]);
		 return rankings;
	}

}


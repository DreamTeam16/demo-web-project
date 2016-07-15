package edu.csupomona.cs480.data;

public class FakeAlgo {
	
	public int[] rankings;
	public String month;
	public String name;
	
	public void generateRankings(ParkData park, int prefCrowds, int prefTemp){
		this.name = park.getName();
		this.rankings = new int[13]; //1 for each month, skipping 0 index (for chart purposes)
		int[] visitors = park.getRecVisitors();
		int[] lows = { 0, 50, 50, 60, 62, 73, 75, 100, 80, 81, 75, 70, 60, 51 }; //park.getHighs();
		int[] highs = { 0, 60, 50, 70, 74, 83, 85, 100, 80, 85, 85, 80, 70, 61 }; //park.getLows();
		int minVisitors = visitors[1];
		
		for(int i = 2; i < 13; i++){
			if(minVisitors > visitors[i])
				minVisitors = visitors[i];
		}
		
		for(int i = 1; i < 13; i++){
			//ranks each month; the lower, the better
			rankings[i] = Math.abs(prefTemp - ((highs[i] + lows[i]) / 2));
		}

		int min = rankings[1];
		int indexMin = 1;
		
		//find index of month with lowest ranking score;
		for(int i = 2; i < 13; i++){
			if(rankings[i] < min)
				indexMin = i;
		}
			
		switch(indexMin){
		case 1:
			this.month = "January";
			break;
		
		case 2:
			this.month = "February";
			break;

		case 3:
			this.month = "March";
			break;

		case 4:
			this.month = "April";
			break;

		case 5:
			this.month = "May";
			break;			
		
		case 6:
			this.month = "June";
			break;
		
		case 7:
			this.month = "July";
			break;
		
		case 8:
			this.month = "August";
			break;
		
		case 9:
			this.month = "September";
			break;
		
		case 10:
			this.month = "October";
			break;
		
		case 11:
			this.month = "November";
			break;
		
		case 12:
			this.month = "December";
			break;
		}
	}
	
}

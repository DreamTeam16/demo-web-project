package edu.csupomona.cs480.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.Random;

public class CommonsMath {

	 public void cmathtest() {

		 DescriptiveStatistics stats = new DescriptiveStatistics();
		 Random rand = new Random();
		 int[] temp = new int[20];

         System.out.println("Hello World");
         try {
            File file = new File("src/main/resources/static/commonsmath.html");
			FileWriter cm = new FileWriter(file);
			cm.write("These are some stats: \n");
			for (int i = 0; i < temp.length; i++) {
				temp[i] = rand.nextInt(1000);
				cm.write("Random #" + i + ": " + temp[i] + "\n");
				stats.addValue(temp[i]);
			}
			double mean = stats.getMean();
			double std = stats.getStandardDeviation();
			double median = stats.getPercentile(50);
			cm.write("The mean of the random numbers generated are: " + mean + "\n");
			cm.write("The Standard Deviation of the random numbers generated are: " + std + "\n");
			cm.write("The median of the random numbers generated are: " + median + "\n");
			cm.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	 }
}

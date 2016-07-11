package edu.csupomona.cs480.data.provider;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.csupomona.cs480.data.*;

public class ParkDataTest {
	private ParkData park;
	private int[] recVisitors;
	
	@Before
	public void testSetup() {
		recVisitors = new int[13];
		for(int i = 0; i < 13; i++) {
			recVisitors[i] = 10;
		}
		park = new ParkData();
		park.setName("Joshua Tree");
		park.setRecVisitors(recVisitors);
	}
	
	@Test
	public void testGetName() {
		String parkName = park.getName();
		Assert.assertNotNull(parkName);
		Assert.assertEquals("Joshua Tree", parkName);
	}
	
	@Test
	public void testSetName() {
		park.setName("Yosemite");
		Assert.assertEquals("Yosemite", park.getName());
	}
	
	@Test
	public void testGetVisitors() {
		int[] visitors = park.getRecVisitors();
		Assert.assertNotNull(visitors);
		Assert.assertArrayEquals(recVisitors, visitors);
	}

	@Test
	public void testSetVisitors() {
		int[] newVisitors = new int [13];
		for(int i = 0; i < 13; i++) {
			newVisitors[i] = 100;
		}
		park.setRecVisitors(newVisitors);
		Assert.assertArrayEquals(newVisitors, park.getRecVisitors());
	}
	
}

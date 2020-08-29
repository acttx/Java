/**
 * 
 * Paul Nguyen
 * Unit 02 Lab - JUnit and Debugging
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTestJUnit {
	
	@Test
	public void testGetMonth(){
		Date apr = new Date(4,1);
		assertEquals ("April", apr.getMonth());
		
		Date may = new Date(5,1);
		assertEquals("May", may.getMonth());
	}
	//Happy test for getting valid Month name with month number
	
	@Test
	public void testWrongMonth() {
		Date date = new Date(15,1);
		assertFalse(date.isValidMonth());
	}
	//Unhappy test for month number validation
	
	@Test
	public void testValidDay() {
		Date feb = new Date(2,29);
		assertTrue(feb.isValidDay());
		
		Date mar = new Date(3,10);
		assertTrue(mar.isValidDay());
	}
	//Happy test for a valid date
	
	@Test
	public void testWrongDay() {
		Date date = new Date (2,31);
		assertFalse(date.isValidDay());
		
	}
	//Unhappy test for an invalid date
	
	@Test
	public void testSeason() {
		Date d = new Date(10,11);
		assertEquals("Fall", d.getSeason());
	}
	//Happy test for getting the correct season
	
	@Test
	public void testWrongSeason() {
		Date d = new Date(1,1);
		assertNotEquals("Fall",d.getSeason());
	}
	//Unhappy test for getting invalid season
	
	@Test
	public void testDualSeason() {
		Date mar20 = new Date(3,20);
		assertEquals("Winter", mar20.getSeason());
		
		Date mar21 = new Date(3,21);
		assertEquals("Spring", mar21.getSeason());
		
	}
	//Testing certain dates to return certain seasons.
	
	@Test
	public void testNovSeason() {
		Date nov20 = new Date(11,20);
		assertEquals("Fall", nov20.getSeason());
		
		Date dec20 = new Date(12,20);
		assertEquals("Fall", dec20.getSeason());
	}
	//Testing getSeason() else statement
	
	@Test
	public void testNotNull() {
		Date date = new Date(1,1);
		assertNotNull(date);
	}
	
	@Test
	public void testSameMonth() {
		Date mon = new Date(1,1);
		assertSame(mon.getMonth(), "January");
	}
	
	@Test
	public void testDifferentMonth() {
		Date mon = new Date(2,1);
		assertNotSame(mon.getMonth(), "March");
	}
	
	@Test
	public void testUnknownSeason() {
		Date date = new Date(2,31);
		assertEquals(date.getSeason(), "UNKNOWN");
	}
	//Testing for invalid day of month to get return string of UNKNOWN for getSeason()
}

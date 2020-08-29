/**
 * 
 * This class represents a date given the month and the day of the month.  For the
 * given date, this class provides a method for determining the season in the northern hemisphere for the date.  
 *
 * For example, the given code fragment the output to the console should be WINTER.
 * 
 * Date jan1 = new Date(1, 1);
 * String season = jan1.getSeason();
 * System.out.println(season);
 * 
 * @author parks
 *
 */
public class Date
{
	private static final Month year[] = {
		new Month("January", 1, 31),
		new Month("February", 2, 29),
		new Month("March", 3, 31),
		new Month("April", 4, 30),
		new Month("May", 5, 31),
		new Month("June", 6, 30),
		new Month("July", 7, 31),
		new Month("August", 8, 31),
		new Month("September", 9, 30),
		new Month("October", 10, 31),
		new Month("November", 11, 30),
		new Month("December", 12, 31),
	};
	
	private int month;
	private int day;

	/**
	 * Constructs a new Date object. The month should be a value
	 * from 1 -12 and the day from 1 - 31.
	 * 
	 * @param theMonth the month
	 * @param theDay the day
	 */
	public Date(int theMonth, int theDay)
	{
		month = theMonth;
		day = theDay;
	}
	
	
	/**
	 * This method returns the String representation for the month.  For example:
	 * "January" for month == 1, "February" for month == 2, etc
	 *
	 * @return string representation of the month
	 */
	public String getMonth()
	{
		
		String result = "UNKNOWN";
		if (isValidDay()) {
			result = year[month - 1].getMonthName();		
		}
		return result;
	}
	

	/**
	 * Returns the season that this days falls in based on the following chart:
	 * 
	 * SEASON RETURNED 	FROM 	        TO
	 * SPRING 	        March 21 	    June 20
	 * SUMMER 	        June 21 	    September 22
	 * FALL 	        September 23 	December 20
	 * WINTER 	        December 21 	March 20
	 * 
	 * If the day does not represent a valid day it will return UNKNOWN
	 * 
	 * @return the string representation for the season: 
	 *         WINTER | SPRING | SUMMER | FALL | UNKNOWN
	 */
	public String getSeason()
	{
		String result = "UNKNOWN";
		
		if (!isValidDay()) {
			return result;
		}
		
		if (((month == 12) && day >= 21) || (month == 1 ) || (month == 2) || (month == 3 && day <= 20)) {
			result = "Winter";
		} else if (((month == 3) && day >= 21) || (month == 4 ) || (month == 5) || (month == 6 && day <= 20)) {
			result = "Spring";
		} else if (((month == 6) && day >= 21) || (month == 7 ) || (month == 8) || (month == 9 && day <= 22)) {
			result = "Summer";
		} else {
			result = "Fall";
		}
		
		return result;
	}
	

	/**
	 * 
	 * Returns true if the day is a valid day of the month. For example if the
	 * day were 31 and the month was 11 (November) this method would return
	 * false since November only has 30 days.  Here is a (shortened version)
	 * of a Mother Goose rhyme for the number of days in each month:
	 * 
	 * Thirty days hath September,
	 * April, June, and November.
	 * All the rest have thirty-one,
	 * Excepting February  (which we will say has 29 days)
	 * 
	 * @return true if the day is a valid day of the month otherwise false
	 */
	public boolean isValidDay()
	{
		boolean rc = false;
		if (isValidMonth() && day > 0 && day <= year[month - 1].getMonthDays()) {
			rc = true;
		}
		return rc;
	}
	

	/**
	 * Returns true if the day is a valid month.  Valid months have values from 1 - 12 (inclusive)
	 * 
	 * @return true if the day is a valid day of the month otherwise false
	 */
	public boolean isValidMonth()
	{
		return month > 0 && month <= year.length;
	}
}

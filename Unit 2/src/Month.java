/**
 * 
 * Simple store for a month's number (1-origin), name 
 * and number of days in the month.
 * 
 * @author parks
 *
 */
public class Month {
	
	private int monthNumber;
	private String monthName;
	private int monthDays;
	
	public Month(String name, int number, int days) {
		setMonthName(name);
		setMonthDays(days);
		setMonthNumber(number);
	}
	
	public boolean isDayValid(int d) {
		return d <= monthDays;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public int getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(int monthDays) {
		this.monthDays = monthDays;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}	
}

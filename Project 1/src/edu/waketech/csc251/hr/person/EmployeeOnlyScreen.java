package edu.waketech.csc251.hr.person;
import edu.waketech.csc251.tools.Screener;

public class EmployeeOnlyScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objToTest) {
		if(objToTest.getClass().getSimpleName().equals("Employee")) {
			return true;
		}
		return false;
	}

}

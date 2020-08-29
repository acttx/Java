package edu.waketech.csc251.hr.mgmt;
import edu.waketech.csc251.tools.Screener;

public class ExecutiveScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objToTest) {
		if(objToTest.getClass().getSimpleName().equals("Executive")) {
			return true;
		}
		return false;
	}

}

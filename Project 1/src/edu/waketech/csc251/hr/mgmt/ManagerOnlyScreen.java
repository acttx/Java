package edu.waketech.csc251.hr.mgmt;
import edu.waketech.csc251.tools.Screener;

public class ManagerOnlyScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objToTest) {
		if(objToTest.getClass().getSimpleName().equals("Manager")) {
			return true;
		}
		return false;
	}

}
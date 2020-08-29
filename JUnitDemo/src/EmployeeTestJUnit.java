import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTestJUnit {

	@Test
	public void testChangeSalary() {
		Employee emp = new Employee("Fred", "Jones", 10000);
		emp.changeSalary(1.05);
		assertEquals(emp.getPreviousSalary(), 10000, .0001);
		assertEquals(emp.getMonthlySalary(), 10000 * 1.05, .0001);
	}

}

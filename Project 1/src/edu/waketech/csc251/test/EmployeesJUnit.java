package edu.waketech.csc251.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;

public class EmployeesJUnit {
	Employee emp = new Employee("Paul", 40000);
	Manager man = new Manager("Joe", 50000, "HR");
	Executive exec = new Executive("Bill Gates", 60000, "CEO", .5);
	
	EmployeeOnlyScreen<Employee> empScr = new EmployeeOnlyScreen<Employee>();
	ManagerOnlyScreen<Employee> manScr = new ManagerOnlyScreen<Employee>();
	ExecutiveScreen<Employee> execScr = new ExecutiveScreen<Employee>();
	
	@Test
	public void testEmpScr1() {
		assertTrue(empScr.test(emp));
	}
	
	@Test
	public void testEmpScr2() {
		assertFalse(empScr.test(man));
	}
	
	@Test
	public void testEmpScr3() {
		assertFalse(empScr.test(exec));
	}
	
	@Test
	public void testManScr1() {
		assertTrue(manScr.test(man));
	}
	
	@Test
	public void testManScr2() {
		assertFalse(manScr.test(exec));
	}
	
	@Test
	public void testManScr3() {
		assertFalse(manScr.test(emp));
	}
	
	@Test
	public void testExecScr1() {
		assertTrue(execScr.test(exec));
	}
	
	@Test
	public void testExecScr2() {
		assertFalse(execScr.test(man));
	}
	
	@Test
	public void testExecScr3() {
		assertFalse(execScr.test(emp));
	}
}

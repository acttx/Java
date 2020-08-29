package edu.waketech.csc251.hr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;

public class DataSetGenericJUnit {
	DataSetGeneric<Employee> employeeList = new DataSetGeneric<Employee>();
	Employee emp = new Employee("Paul", 40000);
	Manager man = new Manager("Joe", 50000, "HR");
	Executive exec = new Executive("Bill Gates", 60000, "CEO", .5);
	
	EmployeeOnlyScreen<Employee> empScr = new EmployeeOnlyScreen<Employee>();
	ManagerOnlyScreen<Employee> manScr = new ManagerOnlyScreen<Employee>();
	ExecutiveScreen<Employee> execScr = new ExecutiveScreen<Employee>();
	
	@Test
	public void getListTest() {
		employeeList.add(emp);
		employeeList.add(man);
		employeeList.add(exec);
		
		assertEquals(employeeList, employeeList.getList());
	}
	
	@Test
	public void testEmpScreener() {
		employeeList.add(emp);
		employeeList.add(man);
		employeeList.add(exec);
		
		assertEquals(emp, employeeList.getList(empScr).get(0));
		assertNotEquals(man, employeeList.getList(empScr).get(0));
		assertNotEquals(exec, employeeList.getList(empScr).get(0));
	}
	
	@Test
	public void testManagerScreener() {
		employeeList.add(emp);
		employeeList.add(man);
		employeeList.add(exec);
		
		assertEquals(man, employeeList.getList(manScr).get(0));
		assertNotEquals(exec, employeeList.getList(manScr).get(0));
		assertNotEquals(emp, employeeList.getList(manScr).get(0));
	}
	
	@Test
	public void testExecScreener() {
		employeeList.add(emp);
		employeeList.add(man);
		employeeList.add(exec);
		
		assertEquals(exec, employeeList.getList(execScr).get(0));
		assertNotEquals(emp, employeeList.getList(execScr).get(0));
		assertNotEquals(man, employeeList.getList(execScr).get(0));
	}
}
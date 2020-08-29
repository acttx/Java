package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.collection.Measurable;
import edu.waketech.csc251.hr.person.Employee;

public class Manager extends Employee implements Measurable{
	private String department;
	
	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	public String getDpmt() {
		return department;
	}
	
	public String toString() {
		return "Manager [Name= " +getName()+ ", Salary= " +getSalary() + ", Department= " +getDpmt()+ "]";
	}

	@Override
	public int getMeasure() {
		// TODO Auto-generated method stub
		return super.getMeasure();
	}	
}
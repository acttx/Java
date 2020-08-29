package edu.waketech.csc251.hr.person;

import edu.waketech.csc251.collection.Measurable;

public class Employee implements Measurable {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}

	public String toString() {
		return "Employee [Name= " +getName()+ ", Salary= " +getSalary() + "]";
	}

	@Override
	public int getMeasure() {
		// TODO Auto-generated method stub
		return (int) salary;
	}
}

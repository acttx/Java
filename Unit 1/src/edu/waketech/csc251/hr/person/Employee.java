/* Paul Nguyen
 * Unit 01 Lab - Inheritance
 */

package edu.waketech.csc251.hr.person;

public class Employee {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "Employee\nName: " +getName()+ "\nSalary: " +getSalary() + "\n";
	}
}

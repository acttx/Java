/* Paul Nguyen
 * Unit 01 Lab - Inheritance
 */

package edu.waketech.csc251.hr.mgmt;

public class Executive extends Manager {
	private double bonusRate;

	public Executive(String name, double salary, String department, double bonusRate) {
		super(name, salary, department);
		this.bonusRate = bonusRate;
	}
	
	public double getBonus() {
		return bonusRate;
	}
	
	public void setBonus(double bonusRate) {
		this.bonusRate = bonusRate;
	}
	
	public double getSalary() {
		return super.getSalary() * (1 + bonusRate);
	}
	
	@Override
	public String toString() {
		return "Executive\nName:" +getName()+ "\nSalary: " +getSalary() + "\nDepartment: " +getDpmt()+ "\n";
	}
}

/* Paul Nguyen
 * Unit 01 Lab - Inheritance
 */

package edu.waketech.csc251.hr.test;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.person.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee dilbert = new Employee("Bob Saget", 90000);
		System.out.println(dilbert);
		Employee pointyHairedBoss = new Manager("Guy Fieri", 80000, "HR");
		System.out.println(pointyHairedBoss);
		Employee clueless = new Executive("Bill Gates", 230000, "CEO", 0.2);
		System.out.println(clueless);

	}

}

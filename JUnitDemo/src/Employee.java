


// Adapted from Employee.java by jkp

public class Employee {
	private String firstName;
	private String lastName;
	private double monthlySalary;
	private double previousSalary;  // added by jkp

	// constructor to initialize first name, last name and monthly salary
	public Employee(String first, String last, double salary) {
		firstName = first;
		lastName = last;
		previousSalary = 0;

		if (salary >= 0.0) // determine whether salary is positive
			monthlySalary = salary;
	} // end three-argument Employee constructor

	// added by jkp
	public void changeSalary(double rate) {
		previousSalary = monthlySalary;
		monthlySalary = monthlySalary * rate;  // hint: monthlySalary * (1 + rate) might work better :-)
	}

	// get Employee's first name
	public String getFirstName() {
		return firstName;
	} // end method getFirstName

	// get Employee's last name
	public String getLastName() {
		return lastName;
	} // end method getLastName

	// get Employee's monthly salary
	public double getMonthlySalary() {
		return monthlySalary;
	} // end method getMonthlySalary

	// added by jkp
	public double getPreviousSalary() {
		return previousSalary;
	}

	// set Employee's first name
	public void setFirstName(String first) {
		firstName = first;
	} // end method setFirstName

	// set Employee's last name
	public void setLastName(String last) {
		lastName = last;
	} // end method setLastName
	
	
	// set Employee's monthly salary
	public void setMonthlySalary(double salary) {
		if (salary >= 0.0) // determine whether salary is positive
			monthlySalary = salary;
	} // end method setMonthlySalary

} // end class Employee

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/

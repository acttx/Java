/**
 * 
Paul Nguyen
CSC.251.0001
HR_Project 

*/


package edu.waketech.csc251.hr;

import java.util.ArrayList;
import java.util.Scanner;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.tools.Utils;

public class Payroll {

   // Possible User Actions.
   public static final String MENU_EXIT = "Exit";
   public static final String MENU_ADD_EMPLOYEE = "Add Employee";
   public static final String MENU_ADD_MANAGER = "Add Manager";
   public static final String MENU_ADD_EXECUTIVE = "Add Executive";
   public static final String MENU_LIST_ALL = "List All";
   public static final String MENU_LIST_EMPLOYEE = "List (Regular) Employees";
   public static final String MENU_LIST_MANAGER = "List Managers";
   public static final String MENU_LIST_EXECUTIVE = "List Executives";
   public static final String MENU_SHOW_HIGHEST_SALARY_PERSON = "Show Highest Salary Person";
   public static final String MENU_GENERATE_PAYROLL = "Generate Payroll";

   // Menu for user actions
   public static final String[] MAIN_MENU = { MENU_EXIT, MENU_ADD_EMPLOYEE, MENU_ADD_MANAGER, MENU_ADD_EXECUTIVE,
         MENU_LIST_ALL, MENU_LIST_EMPLOYEE, MENU_LIST_MANAGER, MENU_LIST_EXECUTIVE, MENU_SHOW_HIGHEST_SALARY_PERSON,
         MENU_GENERATE_PAYROLL, };

   public static void main(String[] args) {
      Scanner kybd = new Scanner(System.in);
      DataSetGeneric<Employee> hrdb = new DataSetGeneric<>();

      String userChoice = Utils.userChoose(kybd, MAIN_MENU);
      while (!MENU_EXIT.equals(userChoice)) {
         if (MENU_ADD_EMPLOYEE.equals(userChoice)) {
            addEmployee(kybd, hrdb);
         } else if (MENU_ADD_MANAGER.equals(userChoice)) {
            addManager(kybd, hrdb);
         } else if (MENU_ADD_EXECUTIVE.equals(userChoice)) {
            addExecutive(kybd, hrdb);
         } else if (MENU_LIST_ALL.equals(userChoice)) {
            displayEverybody(kybd, hrdb);
         } else if (MENU_LIST_EMPLOYEE.equals(userChoice)) {
            displayOnlyEmployees(kybd, hrdb);
         } else if (MENU_LIST_MANAGER.equals(userChoice)) {
            displayOnlyManagers(kybd, hrdb);
         } else if (MENU_LIST_EXECUTIVE.equals(userChoice)) {
            displayOnlyExecutives(kybd, hrdb);
         } else if (MENU_SHOW_HIGHEST_SALARY_PERSON.equals(userChoice)) {
            displayHighestSalary(kybd, hrdb);
         } else if (MENU_GENERATE_PAYROLL.equals(userChoice)) {
            generatePayroll(kybd, hrdb);
         }

         userChoice = Utils.userChoose(kybd, MAIN_MENU);
      }
      System.out.println("Bye");
   }

   /**
    * Add a regular employee to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new employee
    */
   public static void addEmployee(Scanner input, DataSetGeneric<Employee> dataStore) {
	   String name;
	   double salary;
	   
	   System.out.print("Name: ");
	   name = input.next();
	   System.out.println();
	   
	   System.out.print("Enter Salary: ");
	   salary = input.nextDouble();
	   
	   Employee emp = new Employee(name, salary);
	   dataStore.add(emp);
	   
   }

   /**
    * Add an executive to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new executive
    */
   public static void addExecutive(Scanner input, DataSetGeneric<Employee> dataStore) {
	   String name;
	   String department;
	   double salary;
	   double bonus;
	   
	   System.out.print("Name: ");
	   name = input.next();
	   System.out.println();
	   
	   System.out.print("Enter Salary: ");
	   salary = input.nextDouble();
	   System.out.println();
	   
	   System.out.print("Enter Department Managed: ");
	   department = input.next();
	   System.out.println();
	   
	   System.out.print("Enter Bonus: ");
	   bonus = input.nextDouble();
	   
	   Executive exec = new Executive(name, salary, department, bonus);
	   dataStore.add(exec);
   }

   /**
    * Add a manager to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new manager
    */
   public static void addManager(Scanner input, DataSetGeneric<Employee> dataStore) {
	   String name;
	   String department;
	   double salary;
	   
	   System.out.print("Name: ");
	   name = input.next();
	   System.out.println();
	   
	   System.out.print("Enter Salary: ");
	   salary = input.nextDouble();
	   System.out.println();
	   
	   System.out.print("Enter Department Managed: ");
	   department = input.next();
	   
	   Manager manager = new Manager(name, salary, department);
	   dataStore.add(manager);
   }

   /**
    * Display everybody in the data store
    * 
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayEverybody(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   for (int i = 0; i < dataStore.size(); i++) {
	         System.out.println("\t[" + i + "] " + dataStore.get(i));
	   }
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display the person with the highest salary
    * 
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayHighestSalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   System.out.println("\t[0]" + dataStore.getMax());
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
	   //}
   }

   /**
    * Display only the regular employees
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyEmployees(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   EmployeeOnlyScreen<Employee> empScreen = new EmployeeOnlyScreen<Employee>();
	   ArrayList<Employee> empOnly = dataStore.getList(empScreen);
	   for (int i = 0; i < empOnly.size(); i++) {
		   System.out.println("\t[" + i + "] " + empOnly.get(i));
	   }
	   
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
	   
   }

   /**
    * Display only the executives
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyExecutives(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   ExecutiveScreen<Employee> execScreen = new ExecutiveScreen<Employee>();
	   ArrayList<Employee> execOnly = dataStore.getList(execScreen);
	   for (int i = 0; i < execOnly.size(); i++) {
		   System.out.println("\t[" + i + "] " + execOnly.get(i));
	   }
	   
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display on the managers
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyManagers(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   ManagerOnlyScreen<Employee> managerScreen = new ManagerOnlyScreen<Employee>();
	   ArrayList<Employee> managerOnly = dataStore.getList(managerScreen);
	   for (int i = 0; i < managerOnly.size(); i++) {
		   System.out.println("\t[" + i + "] " + managerOnly.get(i));
	   }
	   
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Generate the payroll
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees 
    */
   public static void generatePayroll(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   for (int i = 0; i < dataStore.size(); i++) {
		   System.out.println("\t[" + i + "] Pay " + dataStore.get(i).getName() + " $" + dataStore.get(i).getSalary());
	   }
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }
}

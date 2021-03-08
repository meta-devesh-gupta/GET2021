package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeMain {

	List<Employee> listOfEmployees = new LinkedList<>();

	/**
	 * This method will create and add the employee if employee doesn't already
	 * exists in the list
	 * 
	 * @param employeeID
	 *            It is the unique ID of the employee
	 * @param name
	 *            It is the name of the employee
	 * @param address
	 *            It is the address of the employee
	 * @return true if employee is created and added else return false
	 */
	public boolean addEmployee(int employeeID, String name, String address) {
		Employee newEmployee = new Employee(employeeID, name, address);
		if (listOfEmployees.contains(newEmployee)) {
			// return false;
			throw new AssertionError("Employee ID already exists");
		} else
			listOfEmployees.add(newEmployee);

		return true;
	}

	/**
	 * This method will the list of employees on the basis of their employee ID
	 */
	public void sort() {
		Comparator<Employee> comparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee firstEmp, Employee secondEmp) {
				return firstEmp.getEmployeeID() - secondEmp.getEmployeeID();
			}
		};
		Collections.sort(listOfEmployees, comparator);
	}

	/**
	 * This method will sort the list of employees on the basis of the
	 * employee's name
	 */
	public void sortingBasedOnName() {
		Comparator<Employee> comparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee firstEmp, Employee secondEmp) {
				return firstEmp.getName().compareTo(secondEmp.getName());
			}
		};
		Collections.sort(listOfEmployees, comparator);
	}

}

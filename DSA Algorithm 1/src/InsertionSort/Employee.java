package InsertionSort;

//Employee Class containing details of employee
public class Employee {
	private String employeeName;
	private int employeeSalary;
	private int employeeAge;

	public Employee(String employeeName, int employeeSalary, int employeeAge) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @return the employeeSalary
	 */
	public int getEmployeeSalary() {
		return employeeSalary;
	}

	/**
	 * @return the employeeAge
	 */
	public int getEmployeeAge() {
		return employeeAge;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeAge=" + employeeAge + "]";
	}

	
}

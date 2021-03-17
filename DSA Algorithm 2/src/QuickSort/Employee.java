package QuickSort;

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
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeSalary
	 */
	public int getEmployeeSalary() {
		return employeeSalary;
	}

	/**
	 * @param employeeSalary
	 *            the employeeSalary to set
	 */
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	/**
	 * @return the employeeAge
	 */
	public int getEmployeeAge() {
		return employeeAge;
	}

	/**
	 * @param employeeAge
	 *            the employeeAge to set
	 */
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	/**
	 * This method will compare the salary and age of the employee and return
	 * the integer value based on the sorting order
	 * 
	 * @param secondEmployee
	 *            It is the second employee
	 * @return integer value according to sort order
	 */
	public int compareTo(Employee secondEmployee) {
		Employee firstEmployee = this;
		if (firstEmployee.getEmployeeSalary() != secondEmployee
				.getEmployeeSalary())
			return firstEmployee.getEmployeeSalary()
					- secondEmployee.getEmployeeSalary();
		else {
			if (firstEmployee.getEmployeeAge() > secondEmployee
					.getEmployeeAge())
				return -1;
			return 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeAge=" + employeeAge + "]";
	}

}

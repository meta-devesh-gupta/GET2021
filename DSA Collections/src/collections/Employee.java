package collections;

public class Employee {
	private int employeeID;
	private String name;
	private String address;

	// initializing the employee object
	public Employee(int employeeID, String name, String address) {
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
	}

	// this method will return the employeeID
	public int getEmployeeID() {
		return employeeID;
	}

	// this method will return the name of the employee
	public String getName() {
		return name;
	}

	// this method will return the address of the employee
	public String getAddress() {
		return address;
	}

	/**
	 * Overriding the equals method and checking whether the employee already
	 * exists or not
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || object.getClass() != this.getClass())
			return false;

		Employee employee = (Employee) object;

		return this.employeeID == employee.employeeID;
	}

	/**
	 * Overriding the hashCode() method by unique field employeeID
	 */
	@Override
	public int hashCode() {
		return this.employeeID;
	}
}

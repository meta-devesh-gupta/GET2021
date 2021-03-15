package InsertionSort;

public class EmployeeLinkedList {

	/**
	 * Sorting linked list using Insertion Sort
	 * 
	 * @param employeeLinkedList
	 *            It is the input linked list which needs to be sorted
	 */
	public void sortEmployeeLinkedList(LinkedList<Employee> employeeLinkedList) {

		// Initializing sorted list head node
		Node<Employee> sortedListNode = null;

		// initializing current node with head
		Node<Employee> currentEmployee = employeeLinkedList.head;

		// iterating on all the nodes of the linked list
		while (currentEmployee != null) {
			Node<Employee> nextNode = currentEmployee.next;
			sortedListNode = sortedInsert(sortedListNode, currentEmployee);
			currentEmployee = nextNode;
		}
		employeeLinkedList.head = sortedListNode;
	}

	/**
	 * It is the helper method for sortEmployeeLinkedList method. It will
	 * compare the first node from the unsorted list to nodes from sorted list
	 * and find its suitable position and place it in the list
	 * 
	 * @param sortedListNode
	 *            It is the head node of sorted linked list
	 * @param newNode
	 *            It is the current node from the unsorted list which needs to
	 *            be inserted in the sorted list
	 * @return sorted linked list head node
	 */
	private Node<Employee> sortedInsert(Node<Employee> sortedListNode,
			Node<Employee> newNode) {
		// either sorted is null or newNode salary is greater than first node of
		// sorted list
		if (sortedListNode == null
				|| compareTo(sortedListNode.value, newNode.value) < 0) {
			newNode.next = sortedListNode;
			sortedListNode = newNode;
		} else {
			Node<Employee> currentNode = sortedListNode;

			// skipping first node and continuing from second node
			while (currentNode.next != null
					&& compareTo(currentNode.next.value, newNode.value) > 0) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		return sortedListNode;
	}

	/**
	 * It compares the salary and age of the first and second employee. If
	 * salary of both employees are same then we compare the age of both
	 * employees and sort based on age of employees else sort based on salary.
	 * 
	 * @param firstEmployee
	 *            It is the first employee
	 * @param secondEmployee
	 *            It is the second employee
	 * @return integer value according to sort order
	 */
	public int compareTo(Employee firstEmployee, Employee secondEmployee) {
		if (firstEmployee.getEmployeeSalary() != secondEmployee
				.getEmployeeSalary()) {
			return firstEmployee.getEmployeeSalary()
					- secondEmployee.getEmployeeSalary();
		} else {
			if (firstEmployee.getEmployeeAge() > secondEmployee
					.getEmployeeAge())
				return -1;
			return 1;
		}
	}

	// To display the linked list
	public void display(LinkedList<Employee> employeeLinkedList) {
		Node<Employee> temp = employeeLinkedList.head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		EmployeeLinkedList empLinkedList = new EmployeeLinkedList();
		LinkedList<Employee> employeeLinkedList = new LinkedList<>();
		employeeLinkedList.add(new Employee("A", 10000, 20));
		employeeLinkedList.add(new Employee("B", 40000, 31));
		employeeLinkedList.add(new Employee("C", 20000, 20));
		employeeLinkedList.add(new Employee("D", 30000, 28));
		employeeLinkedList.add(new Employee("E", 20000, 35));
		empLinkedList.sortEmployeeLinkedList(employeeLinkedList);
		empLinkedList.display(employeeLinkedList);

	}
}

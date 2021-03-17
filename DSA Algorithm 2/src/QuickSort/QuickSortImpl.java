package QuickSort;

public class QuickSortImpl {

	/**
	 * This method will sort the employee linked list using quick sort
	 * 
	 * @param employeeLinkedList
	 *            It is the employee linked list
	 */
	public void sortEmployeeLinkedList(LinkedList<Employee> employeeLinkedList) {
		Node<Employee> tail = employeeLinkedList.getHead();
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		quickSort(employeeLinkedList.getHead(), tail);
	}

	/**
	 * This method is the private helper method to above sortEmployeeLinkedList
	 * method
	 * 
	 * @param head
	 *            It is the head node of the employee linked list
	 * @param tail
	 *            It is the tail node of the employee linked list
	 */
	private void quickSort(Node<Employee> head, Node<Employee> tail) {

		Node<Employee> start = head;
		Node<Employee> end = tail;

		if (start == null || start == end.getNext() || start == end) {
			return;
		}

		Node<Employee> prevPivot = partition(start, end);
		quickSort(start, prevPivot);

		if (prevPivot != null && prevPivot == start) {
			quickSort(prevPivot.getNext(), end);
		} else if (prevPivot != null && prevPivot.getNext() != null) {
			quickSort(prevPivot.getNext().getNext(), end);
		}
	}

	/**
	 * This method will find the suitable place for pivot node and place it in
	 * the linked list
	 * 
	 * @param start
	 *            It is the starting node of the linked list
	 * @param end
	 *            It is the last node of the linked list
	 * @return previous of pivot node
	 */
	private Node<Employee> partition(Node<Employee> start, Node<Employee> end) {

		if (start == end || start == null || end == null) {
			return start;
		}

		Node<Employee> prevPivot = start;
		Node<Employee> current = start;

		// taking pivot as the end node
		Node<Employee> pivot = end;

		int pivotage = end.getValue().getEmployeeAge();
		int pivotSlary = end.getValue().getEmployeeSalary();
		String pivotName = end.getValue().getEmployeeName();

		while (start != end) {

			if (start.getValue().compareTo(pivot.getValue()) > 0) {
				prevPivot = current;

				int tempSalary = current.getValue().getEmployeeSalary();
				String tempName = current.getValue().getEmployeeName();
				int tempAge = current.getValue().getEmployeeAge();

				current.getValue().setEmployeeSalary(
						start.getValue().getEmployeeSalary());
				current.getValue().setEmployeeName(
						start.getValue().getEmployeeName());
				current.getValue().setEmployeeAge(
						start.getValue().getEmployeeAge());

				start.getValue().setEmployeeSalary(tempSalary);
				start.getValue().setEmployeeName(tempName);
				start.getValue().setEmployeeAge(tempAge);

				current = current.getNext();
			}
			start = start.getNext();
		}

		int temp = current.getValue().getEmployeeSalary();
		int tempAge = current.getValue().getEmployeeAge();
		String tempName = current.getValue().getEmployeeName();

		current.getValue().setEmployeeSalary(pivotSlary);
		current.getValue().setEmployeeName(pivotName);
		current.getValue().setEmployeeAge(pivotage);

		end.getValue().setEmployeeSalary(temp);
		end.getValue().setEmployeeAge(tempAge);
		end.getValue().setEmployeeName(tempName);

		return prevPivot;
	}

//	public void display(LinkedList<Employee> employeeLinkedList) {
//		Node<Employee> temp = employeeLinkedList.getHead();
//		while (temp != null) {
//			System.out.println(temp.getValue());
//			temp = temp.getNext();
//		}
//	}

//	public static void main(String[] args) {
//		QuickSortImpl quickSortImpl = new QuickSortImpl();
//		LinkedList<Employee> employeeLinkedList = new LinkedList<>();
//		employeeLinkedList.add(new Employee("A", 10000, 10));
//		employeeLinkedList.add(new Employee("B", 40000, 28));
//		employeeLinkedList.add(new Employee("C", 20000, 18));
//		employeeLinkedList.add(new Employee("D", 20000, 28));
//		employeeLinkedList.add(new Employee("E", 10000, 28));
//		quickSortImpl.sortEmployeeLinkedList(employeeLinkedList);
//		quickSortImpl.display(employeeLinkedList);
//
//	}
}

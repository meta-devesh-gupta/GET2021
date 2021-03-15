package Dictionary;

//Generic LinkedList class
public class LinkedList<T> {
	Node head;
	
	class Node {
		T value;
		Node next;

		public Node(T value) {
			this.value = value;
		}
		
	}

	/**
	 * Method to add value in the linked list
	 */
	public void add(T value) {
		Node node = new Node(value);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	/**
	 * Method to get value from the linked list at particular index
	 * 
	 * @param index
	 *            It is the index value of the list
	 * @return value after fetching from the list
	 */
	public T get(int index) {
		int size = getSize();
		if (index < 0 && index >= size)
			throw new AssertionError("Invalid Index");
		Node tempNode = head;
		for (int counter = 0; counter < index; counter++) {
			tempNode = tempNode.next;
		}
		return tempNode.value;
	}

	/**
	 * @return size of the linked list
	 */
	public int getSize() {
		int size = 0;
		Node tempNode = head;
		while (tempNode != null) {
			tempNode = tempNode.next;
			size++;
		}
		return size;
	}
	
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}

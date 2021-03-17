package QuickSort;

//Generic LinkedList class
public class LinkedList<T> {
	private Node<T> head;

	/**
	 * Method to add value in the linked list
	 */
	public void add(T value) {
		Node<T> node = new Node<T>(value);
		if (head == null)
			head = node;
		else {
			Node<T> temp = head;
			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(node);
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
		Node<T> tempNode = head;
		for (int counter = 0; counter < index; counter++) {
			tempNode = (tempNode.getNext());
		}
		return tempNode.getValue();
	}

	/**
	 * @return size of the linked list
	 */
	public int getSize() {
		int size = 0;
		Node<T> tempNode = head;
		while (tempNode != null) {
			tempNode = tempNode.getNext();
			size++;
		}
		return size;
	}

	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

}

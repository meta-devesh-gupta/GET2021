package question1;

public class LinkedList {

	/**
	 * A method to rotate sub list (left to right)in clockwise direction by the
	 * number of steps (N) given as input.
	 * 
	 * @param head
	 *            head is the head node of the singly linked list
	 * @param left
	 *            left position in singly linked list
	 * @param right
	 *            right position in singly linked list
	 * @param rotationCount
	 *            It is the total number of rotation count of the sublist
	 * @return head node of the singly linked list
	 */
	public static Node rotateList(Node head, int left, int right,
			int rotationCount) {

		try {
			if (rotationCount < 0)
				throw new AssertionError(
						"rotation count is less than zero...NOT POSSIBLE");

			left = left - 1;
			right = right - 1;

			if (head == null) // return null
				throw new AssertionError("Head node is null");

			int rotationSize = right - left + 1;
			if (rotationCount > rotationSize)
				rotationCount %= rotationSize;

			if (left < 0)
				throw new AssertionError("Left value is less than zero");
			if (right > getSize(head))
				throw new AssertionError("Right value is greater than ");
			if (rotationCount == 0)
				throw new AssertionError("After rotation value is same");

			// finding left node and left previous node
			Node leftNode = head;
			Node leftPreviousNode = null;
			for (int count = 0; count < left && leftNode != null; count++) {
				leftPreviousNode = leftNode;
				leftNode = leftNode.next;
			}

			// finding right node and right previous node
			Node rightNode = head;
			Node rightPreviousNode = rightNode;
			for (int count = 0; count < right && rightNode != null; count++) {
				rightPreviousNode = rightNode;
				rightNode = rightNode.next;
			}

			// rotation
			for (int count = 0; count < rotationCount; count++) {
				Node nextLink = rightNode.next;
				rightPreviousNode.next = nextLink;
				rightNode.next = leftNode;

				// corner case
				if (leftPreviousNode != null)
					leftPreviousNode.next = rightNode;

				leftNode = rightNode;
				rightNode = rightPreviousNode;

				// after swapping rightPreviousNode=rightNode so...
				rightPreviousNode = head;
				while (rightPreviousNode != null
						&& rightPreviousNode.next != rightNode)
					rightPreviousNode = rightPreviousNode.next;
			}

			// corner case
			if (left == 0)
				head = leftNode;
		} catch (AssertionError assertionError) {
			System.out.println(assertionError.getMessage());
		}
		return head;
	}

	/**
	 * Detecting loop in input linked list
	 * 
	 * @param head
	 *            It is the head node of the input linked list
	 * @return boolean true if loop is found in the input linked list
	 */
	public static boolean detectLoop(Node head) {
		try {
			if (head == null)
				throw new AssertionError("Head node is null");

		} catch (AssertionError assertionError) {
			System.out.println(assertionError.getMessage());
		}
		if (head.next == null)
			return false;

		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}

	/**
	 * This method is used to insert value into the linked list
	 * 
	 * @param head
	 *            It is the head node of the linked list
	 * @param value
	 *            It that value that is added into the linked list
	 */
	public static void add(Node head, int value) {
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
	 * This method will calculate the size of the input linked list
	 * 
	 * @param head
	 *            It is the head node of the input linked list
	 * @return size of the linked list
	 */
	public static int getSize(Node head) {
		int size = 0;
		Node tempNode = head;
		while (tempNode != null) {
			tempNode = tempNode.next;
			size++;
		}
		return size;
	}

	/**
	 * This method will get the value of the node at the particular index
	 * 
	 * @param head
	 *            It is the head node of the input linked list
	 * @param index
	 *            It is the index value of that node whose value is need to be
	 *            returned
	 * @return the index value if value index > 0 && index < size of linked list
	 *         else return -1
	 */
	public static int get(Node head, int index) {
		int size = getSize(head);
		if (index < 0 && index >= size)
			return -1;
		Node tempNode = head;
		for (int counter = 0; counter < index; counter++) {
			tempNode = tempNode.next;
		}
		return tempNode.value;
	}

	public static void main(String[] args) {
		int array[] = { 2, 3, 4, 5, 6, 7 };
		Node head = new Node(array[0]);
		for (int index = 1; index < array.length; index++)
			add(head, array[index]);

		head = LinkedList.rotateList(head, 2, 5, -2);

		// while (head != null) {
		// System.out.print(head.value + " ");
		// head = head.next;
		// }
		for (int i = 0; i < getSize(head); i++)
			System.out.print(get(head, i) + " ");

	}
}

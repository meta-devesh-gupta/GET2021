package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotationTest {

	@Test(expected = AssertionError.class)
	public void firstCase() {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Node head = new Node(array[0]);
		for (int index = 1; index < array.length; index++)
			LinkedList.add(head, array[index]);

		head = LinkedList.rotateList(head, 2, 8, 2);

		int expected[] = { 7, 8, 1, 2, 3, 4, 5, 6 };

		assertArrayEquals(expected, array);
	}

	@Test(expected = AssertionError.class)
	public void secondCase() {
		int array[] = { 2, 3, 4, 5, 6, 7 };
		Node head = new Node(array[0]);
		for (int index = 1; index < array.length; index++)
			LinkedList.add(head, array[index]);

		head = LinkedList.rotateList(head, 2, 5, 2);

		int expected[] = { 2, 5, 6, 3, 7, 4 };

		assertArrayEquals(expected, array);
	}

	@Test(expected = AssertionError.class)
	public void thirdCase() {
		Node head = null;

		head = LinkedList.rotateList(head, 2, 5, 2);

	}

}

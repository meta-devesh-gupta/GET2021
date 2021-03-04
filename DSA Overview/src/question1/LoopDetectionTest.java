package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoopDetectionTest {

	@Test(expected = AssertionError.class)
	public void withoutLoop() {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Node head = new Node(array[0]);
		for (int index = 1; index < array.length; index++)
			LinkedList.add(head, array[index]);

		assertTrue(LinkedList.detectLoop(head));
	}

	@Test(expected = AssertionError.class)
	public void withLoop() {
		int array[] = { 2, 3, 4, 5, 6, 7 };
		Node head = new Node(array[0]);
		Node loop = new Node(6);
		for (int index = 1; index < array.length; index++)
			LinkedList.add(head, array[index]);
			
		Node temp = head;
		for(int counter=0;counter<2;counter++){
			if(counter==1)
				temp.next = loop;
			temp = temp.next;
		}
		
		Node lastNode = head;
		while(lastNode.next!=null)
			lastNode = lastNode.next;
		lastNode.next = loop; 
		
		assertFalse(LinkedList.detectLoop(head));
	}

	@Test(expected = AssertionError.class)
	public void thirdCase() {
		Node head = null;

		LinkedList.detectLoop(head);

	}

}

package PriorityQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyPriorityQueueTest {

	MyPriorityQueue myPriorityQueue;
	
	@Before
	public void init(){
		myPriorityQueue = new MyPriorityQueue(4);
	}
	
	@Test
	public void addItemTest() {
		assertTrue(myPriorityQueue.addItem(new Item("Item 4", 4)));
		assertTrue(myPriorityQueue.addItem(new Item("Item 2", 2)));
		assertTrue(myPriorityQueue.addItem(new Item("Item 1", 1)));
		assertTrue(myPriorityQueue.addItem(new Item("Item 3", 3)));
		
		//overflow condition
		try{
			//assertTrue(myPriorityQueue.addItem(new Item("Item 5", 5)));
		}
		catch(AssertionError assertionError){
			System.out.println(assertionError.getMessage());
		}
	}
	
	public void deleteItemTest(){
		assertEquals("Item 4",myPriorityQueue.removeItem().value);
		assertEquals("Item 3",myPriorityQueue.removeItem().value);
		assertEquals("Item 2",myPriorityQueue.removeItem().value);
		assertEquals("Item 1",myPriorityQueue.removeItem().value);
		
		//underflow condition
		try{
			//assertEquals("Item 4",myPriorityQueue.removeItem().value);
		}
		catch(AssertionError assertionError){
			System.out.println(assertionError.getMessage());
		}
	}
}

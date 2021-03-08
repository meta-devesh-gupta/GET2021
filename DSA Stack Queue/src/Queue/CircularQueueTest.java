package Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {

	CircularQueue circularQueue;

	@Before
	public void init() {
		circularQueue = new CircularQueue(4);
	}

	@Test(expected = AssertionError.class)
	public void queueAddTest() {
		assertTrue(circularQueue.addItem(1));
		assertTrue(circularQueue.addItem(2));
		assertTrue(circularQueue.addItem(3));
		assertTrue(circularQueue.addItem(4));

		// overflow condition
		assertTrue(circularQueue.addItem(5));
	}

	@Test(expected = AssertionError.class)
	public void queuePopTest() {
		assertEquals((Integer) 1, circularQueue.deleteItem());
		assertEquals((Integer) 2, circularQueue.deleteItem());
		assertEquals((Integer) 3, circularQueue.deleteItem());
		assertEquals((Integer) 4, circularQueue.deleteItem());

		// underflow condition
		assertEquals((Integer) 1, circularQueue.deleteItem());
	}
}

package Graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphImplTest {

	GraphImpl graphImpl;

	@Before
	public void init() {
		graphImpl = new GraphImpl(5);
		assertTrue(graphImpl.addEdge(0, 1, 4));
		assertTrue(graphImpl.addEdge(0, 2, 8));
		assertTrue(graphImpl.addEdge(1, 3, 5));
		assertTrue(graphImpl.addEdge(1, 2, 2));
		assertTrue(graphImpl.addEdge(2, 3, 5));
		assertTrue(graphImpl.addEdge(2, 4, 9));
		assertTrue(graphImpl.addEdge(3, 4, 4));
	}

	@Test
	public void isConnectedTest() {

		assertTrue(graphImpl.isConnectedGraph());
	}

	@Test 
	public void reachabelTest() {

		LinkedList<Integer> list = graphImpl.reachable(0);
		int actual[] = new int[list.getSize()];
		for (int index = 0; index < actual.length; index++)
			actual[index] = list.get(index);

		int expected[] = { 0, 1, 2, 3, 4 };
		assertArrayEquals(expected, actual);
	}

	@Test (expected=AssertionError.class)
	public void reachabelTestSecond() {

		LinkedList<Integer> list = graphImpl.reachable(-1);
		int actual[] = new int[list.getSize()];
		for (int index = 0; index < actual.length; index++)
			actual[index] = list.get(index);

		int expected[] = { 0, 1, 2, 3, 4 };
		assertArrayEquals("Invalid Reachable Node", expected, actual);
	}
	
	@Test
	public void dijikstraTest() {
		LinkedList<Integer> list = graphImpl.dijkstra(0, 4);
		int actual[] = new int[list.getSize()];
		for (int index = 0; index < actual.length; index++)
			actual[index] = list.get(index);
		int expected[] = { 4,3,1,0 };
		assertArrayEquals(expected, actual);
	}
}

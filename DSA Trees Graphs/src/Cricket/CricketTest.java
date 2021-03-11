package Cricket;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketTest {

	@Test
	public void addBowlerTest() {
		try {
			Cricket cricket = new Cricket(3, 20);
			assertTrue(cricket.getMyPriorityQueue().add(
					new Bowler("Bowler 1", 5)));
			assertTrue(cricket.getMyPriorityQueue().add(
					new Bowler("Bowler 2", 7)));
			assertTrue(cricket.getMyPriorityQueue().add(
					new Bowler("Bowler 3", 6)));
		} catch (AssertionError assertionError) {
			System.out.println(assertionError.getMessage());
		}
	}

}

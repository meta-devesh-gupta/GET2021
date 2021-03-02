package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCMTestClass {

	@Test
	public void lcmTest() {
		LCM lcm = new LCM();
		assertEquals(5, lcm.findLCM(5,5));
		
		assertEquals(24, lcm.findLCM(8,3));
		
		assertEquals(90, lcm.findLCM(45,30));
		
		assertEquals(72, lcm.findLCM(36,72));
		
		assertEquals(84, lcm.findLCM(84,12));
		
		assertEquals(120, lcm.findLCM(24,15));
		
		assertEquals(6026, lcm.findLCM(262,23));
		
		assertEquals(5400, lcm.findLCM(216,450));
		
		assertEquals(480, lcm.findLCM(60,160));
		
	}

}

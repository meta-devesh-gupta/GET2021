package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class HCFTestClass {

	@Test
	public void hcfTest() {
		
		HCF hcf = new HCF();
		assertEquals(2, hcf.findHCF(10, 14));
		
		assertEquals(4, hcf.findHCF(12, 20));
		
		assertEquals(12, hcf.findHCF(12, 36));
		
		assertEquals(5, hcf.findHCF(35, 55));
		
		assertEquals(20, hcf.findHCF(120, 100));
		
		assertEquals(15, hcf.findHCF(45, 60));
		
		assertEquals(12, hcf.findHCF(12, 0));
		
		assertEquals(18, hcf.findHCF(126, 162));
		
		assertEquals(90, hcf.findHCF(180, 270));
		
		assertEquals(213, hcf.findHCF(1065, 852));
		
		assertEquals(120, hcf.findHCF(120, 120));
	}

}

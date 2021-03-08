package collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrganicChemistryTest {
	OrganicChemistry organicChemistry;

	@Before
	public void init() {
		organicChemistry = new OrganicChemistry();
	}

	@Test(expected=AssertionError.class)
	public void massOfOrganicCompoundTest() {
		assertEquals(29, organicChemistry.evaluateOrganicCompound("CHO"));
		assertEquals(46, organicChemistry.evaluateOrganicCompound("C(oh)2"));
		assertEquals(86, organicChemistry.evaluateOrganicCompound("choc(ch3)3"));
		assertEquals(358, organicChemistry.evaluateOrganicCompound("c12h22o12"));
		assertEquals(0, organicChemistry.evaluateOrganicCompound(""));
	}

}

package question1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CountClumpsTest {
	private int inputArray[];
	private int expectedResult;

	public CountClumpsTest(int inputArray[], int expectedResult) {
		this.inputArray = inputArray;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1 }, 
				{ new int[] { -1, -1, 2, -99, -99 }, 2 },});
	}

	@Test
	public void maxMirrorTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.countClumps(inputArray));
	}
}

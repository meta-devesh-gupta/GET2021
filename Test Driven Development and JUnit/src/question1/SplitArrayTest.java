package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	private int inputArray[];
	private int expectedResult;

	public SplitArrayTest(int inputArray[], int expectedResult) {
		this.inputArray = inputArray;
		this.expectedResult	 = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				 { new int[]{1, 1, 1, 2, 1}, 3 }, 
				 { new int[]{2, 1, 1, 2, 1}, -1 },
				 { new int[]{10, 10}, 1 },
				 { new int[]{1, 4, 5, 5, 4, 1}, 3},
				 { new int[]{4, 5, 3, 9, -5, 8}, 3},
		});
	}

	@Test
	public void splitArrayTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.splitArray(inputArray));
	}
}

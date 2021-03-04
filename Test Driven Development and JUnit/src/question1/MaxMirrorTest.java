package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	private int inputArray[];
	private int expectedResult;

	public MaxMirrorTest(int inputArray[], int expectedResult) {
		this.inputArray = inputArray;
		this.expectedResult	 = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				 { new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3 }, 
				 { new int[]{7, 1, 4, 9, 7, 4, 1}, 2 },
				 { new int[]{1, 2, 1, 4}, 3 },
				 { new int[]{1, 4, 5, 3, 5, 4, 1}, 7},
		});
	}

	@Test
	public void maxMirrorTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertEquals(expectedResult, arrOperation.maxMirror(inputArray));
	}
}

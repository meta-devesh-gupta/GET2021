package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {
	private int inputArray[];
	private int x, y;
	private int expectedResult[];

	public FixXYTest(int inputArray[], int x, int y, int expectedResult[]) {
		this.inputArray = inputArray;
		this.x=x;
		this.y=y;
		this.expectedResult	 = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				 { new int[]{5, 4, 9, 4, 9, 5}, 4, 5, new int[] {9, 4, 5, 4, 5, 9} }, 
				 { new int[]{1, 4, 1, 5}, 4, 5, new int[]{1, 4, 5, 1 }},
				 { new int[]{1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[]{1, 4, 5, 1, 1, 4, 5} },
				 { new int[]{1, 4, 1, 4, 1, 5, 5}, 4, 5, new int[]{1, 4, 5, 4, 5, 1, 1} },
		});
	}

	@Test
	public void fixXYTest() {
		ArrOperation arrOperation = new ArrOperation();
		assertArrayEquals(expectedResult, arrOperation.fixXY(inputArray, x, y));
		
	}
}
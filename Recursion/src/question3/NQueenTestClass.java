package question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTestClass {

	@Test
	public void nQueenTest() {
		NQueensProblem nQueensProblem = new NQueensProblem();
		int dimensionOfMatrix = 4;
		int board[][] = new int[dimensionOfMatrix][dimensionOfMatrix];
		board=nQueensProblem.initializeWithZero(board, dimensionOfMatrix);
		nQueensProblem.nQueen(board, 0, dimensionOfMatrix);
		int expectedBoard[][] = { { 0, 1, 0, 0 }, { 0, 0, 0, 1 },
				{ 1, 0, 0, 0 }, { 0, 0, 1, 0 }, };
		assertArrayEquals(expectedBoard, board);
		
		dimensionOfMatrix = 3;
		board = new int[dimensionOfMatrix][dimensionOfMatrix];
		board=nQueensProblem.initializeWithZero(board, dimensionOfMatrix);
		
		assertFalse(nQueensProblem.nQueen(board, 0, dimensionOfMatrix));
		
	}

}

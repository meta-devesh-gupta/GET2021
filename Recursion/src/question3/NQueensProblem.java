package question3;

public class NQueensProblem {

	/**
	 * The N Queen is the problem of placing N chess queens on an N×N chess
	 * board so that no two queens attack each other.
	 * 
	 * @param board
	 *            board is a 2D square matrix which is initialized with zero.
	 * @param startRow
	 *            startRow contains the index of the row in which queen has to
	 *            be placed.
	 * @param dimensionOfMatrix
	 *            dimensionOfMatrix contains the size of the matrix.
	 * @return boolean value if queen can be placed in the chess board
	 */
	public boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {

		if (startRow >= dimensionOfMatrix)
			return true;

		for (int column = 0; column < dimensionOfMatrix; column++) {
			if (isSafePosition(board, startRow, column, dimensionOfMatrix)) {
				board[startRow][column] = 1;

				if (nQueen(board, startRow + 1, dimensionOfMatrix)) {
					return true;
				}
				board[startRow][column] = 0; // backtracking
			}
		}
		return false;
	}

	/**
	 * This method is the helper method to the nQueen method. It is used to
	 * check whether current position of the board is safe or not for the queen
	 * to be placed.
	 * 
	 * @param board
	 *            board is a 2D square matrix which is initialized with zero.
	 * @param startRow
	 *            startRow contains the index of the row in which queen has to
	 *            be placed.
	 * @param dimensionOfMatrix
	 *            dimensionOfMatrix contains the size of the matrix.
	 * @return return boolean value is the position is safe for the queen
	 */
	private boolean isSafePosition(int[][] board, int startRow, int column,
			int dimensionOfMatrix) {

		boolean flag = true;
		// for all rows in column
		for (int row = 0; row < startRow; row++) {
			if (board[row][column] == 1){
				flag=false;
				break;
			}
		}

		// for upper right diagonal
		for (int row = startRow, col = column; (row >= 0 && col >= 0); row--, col--) {
			if (board[row][col] == 1){
				flag=false;
				break;
			}
		}

		// for upper left diagonal
		for (int row = startRow, col = column; (row >=0 )
				&& (col < dimensionOfMatrix); row--, col++) {
			if (board[row][col] == 1){
				flag=false;
				break;
			}
		}

		return flag;
	}

	/**
	 * Initialize the chess board with initial value 0
	 * 
	 * @param board
	 *            board is a 2D square matrix
	 * @param dimensionOfMatrix
	 *            dimensionOfMatrix is the size of the chess board
	 * @return the chess board array after initializing with 0
	 */
	public int[][] initializeWithZero(int board[][], int dimensionOfMatrix) {
		for (int row = 0; row < dimensionOfMatrix; row++)
			for (int column = 0; column < dimensionOfMatrix; column++)
				board[row][column] = 0;
		return board;
	}

}

package question1;

//Using Euclid's Algorithm
public class HCF {

	/**
	 * Finding highest commom factor/ greatest commom divisor using Euclid's
	 * Algorithm.
	 * 
	 * @param firstNumber
	 *            firstNumber contains the first number for finding hcf.
	 * @param secondNumber
	 *            secondNumber contains the seocnd number for finding hcf.
	 * @return the hcf of two numbers.
	 */
	public int findHCF(int firstNumber, int secondNumber) {
		if (secondNumber == 0)
			return firstNumber;

		return findHCF(secondNumber, firstNumber % secondNumber);
	}
}

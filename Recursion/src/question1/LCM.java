package question1;

public class LCM {

	/**
	 * Finding the least common multiple of given two input numbers.
	 * 
	 * @param firstNumber
	 *            firstNumber contains the first number for finding lcm.
	 * @param secondNumber
	 *            secondNumber contains the second number for finding lcm.
	 * @return this method will return the lcm of input two numbers
	 */
	public int findLCM(int firstNumber, int secondNumber) {
		int maximum = Math.max(firstNumber, secondNumber);

		return lcmUsingRecursion(firstNumber, secondNumber, maximum);
	}

	/**
	 * This method is the private helper method to find the LCM using recursion.
	 * 
	 * @param firstNumber
	 *            firstNumber contains the first number for finding lcm.
	 * @param secondNumber
	 *            secondNumber contains the second number for finding lcm.
	 * @param maximum
	 *            maximum contains the maximum of firstNumber and secondNumber.
	 * @return this method will return the lcm of input two numbers
	 */
	private int lcmUsingRecursion(int firstNumber, int secondNumber, int maximum) {
		if (firstNumber == secondNumber)
			return firstNumber;

		if ((maximum % firstNumber) == 0 && (maximum % secondNumber) == 0)
			return maximum;

		maximum += Math.max(firstNumber, secondNumber);
		return lcmUsingRecursion(firstNumber, secondNumber, maximum);
	}

}

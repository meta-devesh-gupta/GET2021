package Stack;

public class InfixEvaluation {

	/**
	 * This method will evaluate the input infix expression and return the value
	 * using stack
	 * 
	 * @param infixExpression
	 *            It is the string of input infix expression
	 * @return result of evaluation of infix expression
	 */
	public int evaluateInfix(String infixExpression) {
		// if the infix expression length is 0
		if (infixExpression.length() == 0)
			throw new AssertionError("Input infix expression is empty!");

		// if the infix expression have extra spaces after and before the main
		// expression
		infixExpression = infixExpression.trim();

		// appending the ( and ) before and after the string for reducing
		// complexity of evaluation
		infixExpression = "( " + infixExpression + " )";

		// splitting the infix expression on the spaces
		String tokens[] = infixExpression.split(" ");

		// counting numbers of operators and operands to initialize the stack
		int operandCount = 0;
		int operatorCount = 0;
		for (String token : tokens) {
			if (!isOperator(token)) // token is operand
				operandCount++;
			else
				operatorCount++;
		}

		OperandStack operandStack = new OperandStack(operandCount);
		OperatorStack operatorStack = new OperatorStack(operatorCount);

		// Evaluating the expression
		for (String token : tokens) {
			if (!isOperator(token)) // token is operand
				operandStack.push(Integer.parseInt(token));
			else if ("(".equals(token)) // token is opening parenthesis, (
				operatorStack.push(token);
			else if (")".equals(token)) { // token is closing parenthesis , )
				while (!("(".equals(operatorStack.peek()))) {
					String operator = operatorStack.pop();
					int valueTwo = operandStack.pop();
					int valueOne = operandStack.pop();
					operandStack.push(operation(valueOne, valueTwo, operator));
				}
				operatorStack.pop();
			} else { // token is operator
				while (operatorStack.getSize() > 0
						&& (!"(".equals(operandStack.peek()))
						&& precendence(token) <= precendence(operatorStack
								.peek())) {
					String operator = operatorStack.pop();
					int valueTwo = operandStack.pop();
					int valueOne = operandStack.pop();
					operandStack.push(operation(valueOne, valueTwo, operator));
				}
				operatorStack.push(token);
			}

		}

		return operandStack.pop();
	}

	/**
	 * This method will check whether the input token is operator or not
	 * 
	 * @param operator
	 *            It is the input token from the infix expression
	 * @return true if the token is operator else return false
	 */
	public boolean isOperator(String operator) {
		String operatorList[] = { "+", "-", "/", "*", "==", "!=", "<=", ">=",
				"<", ">", "(", ")", "&&", "||" };
		for (String currentOperator : operatorList) {
			if (operator.equals(currentOperator))
				return true;
		}

		return false;
	}

	/**
	 * This method will return the integer precedence value of the input
	 * operator according to java precedence table
	 * 
	 * @param operator
	 *            It is the input operator
	 * @return the precedence value of the operator
	 */
	public int precendence(String operator) {
		if ("||".equals(operator))
			return 1;
		else if ("&&".equals(operator))
			return 2;
		else if ("==".equals(operator) || "!=".equals(operator))
			return 3;
		else if ("<".equals(operator) || ">".equals(operator)
				|| "<=".equals(operator) || ">=".equals(operator))
			return 4;
		else if ("+".equals(operator) || "-".equals(operator))
			return 5;
		else if ("*".equals(operator) || "/".equals(operator))
			return 6;
		return -1;
	}

	/**
	 * This method will perform the operation and return the result
	 * 
	 * @param valueOne
	 *            It is the first value
	 * @param valueTwo
	 *            It is the second value
	 * @param operator
	 *            It is the operator which decides what operator to perform
	 * @return the result after performing the operation
	 */
	public int operation(int valueOne, int valueTwo, String operator) {
		if ("+".equals(operator))
			return valueOne + valueTwo;
		else if ("-".equals(operator))
			return valueOne - valueTwo;
		else if ("*".equals(operator))
			return valueOne * valueTwo;
		else if ("/".equals(operator))
			return valueOne / valueTwo;
		else if ("<=".equals(operator)) {
			if (valueOne <= valueTwo)
				return 1;
			else
				return 0;
		} else if (">=".equals(operator)) {
			if (valueOne >= valueTwo)
				return 1;
			else
				return 0;
		} else if ("<".equals(operator)) {
			if (valueOne < valueTwo)
				return 1;
			else
				return 0;
		} else if (">".equals(operator)) {
			if (valueOne > valueTwo)
				return 1;
			else
				return 0;
		} else if ("==".equals(operator)) {
			if (valueOne == valueTwo)
				return 1;
			else
				return 0;
		} else if ("!=".equals(operator)) {
			if (valueOne != valueTwo)
				return 1;
			else
				return 0;
		} else if ("&&".equals(operator)) {
			if (valueOne == 1 && valueTwo == 1)
				return 1;
			return 0;
		} else if ("||".equals(operator)) {
			if (valueOne == 0 && valueTwo == 0)
				return 0;
			return 1;
		}
		return -1;
	}

	// public static void main(String[] args) {
	// InfixEvaluation eval = new InfixEvaluation();
	// // System.out.println(eval.evaluateInfix(" 2 + ( 5 - 3 * 6 / 2 ) "));
	// // System.out.println(eval.evaluateInfix("2 + 5 * 3"));
	// // System.out.println(eval.evaluateInfix(" ( 22 + 4 ) == ( 23 + 3 ) "));
	// //
	// System.out.println(eval.evaluateInfix(" ( 100 > 99 ) == ( 1 != 1 ) "));
	// //System.out.println(eval.evaluateInfix(" ( 5 * 8 ) / 4 - -2 * ( 2 + 4 / 4 * ( 2 - 21 ) ) "));
	// }
}

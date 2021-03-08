package Stack;

public class OperatorStack implements Stack<String> {
	static int top = -1;
	static int size = 0;
	static String stack[];

	/**
	 * Initializing the stack with number of elements
	 * 
	 * @param numberOfElements
	 *            It is the total number of elements required to push into the
	 *            stack
	 */
	public OperatorStack(int numberOfElements) {
		stack = new String[numberOfElements];
	}

	/**
	 * This method pushes the value into the stack.
	 * 
	 * @param value
	 *            It is that element that is required to pushed into the stack
	 * @return true if value if pushed into the stack
	 */
	@Override
	public boolean push(String value) {

		if ((top + 1) == stack.length)
			throw new AssertionError("Stack overflow...");

		else {
			stack[++top] = value;
			size++;
		}
		return true;
	}

	/**
	 * This method returns the popped element from the stack
	 * 
	 * @return the element that is popped from the stack
	 */
	@Override
	public String pop() {
		if (top == -1)
			throw new AssertionError("Stack unerflow...");
		else {
			String value = stack[top--];
			size--;
			return value;
		}
	}

	/**
	 * This method return the current size of the stack
	 * 
	 * @return current size of the stack
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * This method will return the element on the top of the stack
	 * 
	 * @return element on the top of the stack
	 */
	@Override
	public String peek() {
		if (top == -1)
			throw new AssertionError("Stack underflow");
		return stack[top];
	}

}

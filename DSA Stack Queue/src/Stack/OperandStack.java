package Stack;

public class OperandStack implements Stack<Integer> {
	static int top = -1;
	static int size = 0;
	static int stack[];

	/**
	 * Initializing the stack with number of elements
	 * 
	 * @param numberOfElements
	 *            It is the total number of elements required to push into the
	 *            stack
	 */
	public OperandStack(int numberOfElements) {
		stack = new int[numberOfElements];
	}

	/**
	 * This method pushes the value into the stack.
	 * 
	 * @param value
	 *            It is that element that is required to pushed into the stack
	 * @return true if value if pushed into the stack
	 */
	@Override
	public boolean push(Integer value) {

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
	public Integer pop() {
		if (top == -1)
			throw new AssertionError("Stack unerflow...");
		else {
			int value = stack[top--];
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
	public Integer peek() {
		if (top == -1)
			throw new AssertionError("Stack underflow");
		else
			return stack[top];
	}

}

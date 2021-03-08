package Stack;

public interface Stack<T> {

	/**
	 * This method pushes the value into the stack.
	 * 
	 * @param value
	 *            It is that element that is required to pushed into the stack
	 * @return true if value if pushed into the stack
	 */
	public boolean push(T value);

	/**
	 * This method returns the popped element from the stack
	 * 
	 * @return the element that is popped from the stack
	 */
	public T pop();

	/**
	 * This method will return the element on the top of the stack
	 * 
	 * @return element on the top of the stack
	 */
	public T peek();

	/**
	 * This method return the current size of the stack
	 * 
	 * @return current size of the stack
	 */
	public int getSize();
}

package Queue;

public interface Queue<T> {

	/**
	 * This method will add the item into the stack.
	 * 
	 * @param value
	 *            It is that element that is required to be added into the queue
	 * @return true if value is added into the stack
	 */
	boolean addItem(T value);

	/**
	 * This method will delete the item from the queue and return the deleted
	 * item
	 * 
	 * @return the deleted item from the queue
	 */
	T deleteItem();

	/**
	 * This method will check whether queue is empty or not
	 * 
	 * @return true if queue is empty else return false
	 */
	boolean isEmpty();

	/**
	 * This method will check whether queue is full or not
	 * 
	 * @return true if queue is full else return false
	 */
	boolean isFull();

}

package Cricket;

public interface PriorityQueue<T> {

	/**
	 * Adding item into the queue
	 * 
	 * @param item
	 *            It is the input item
	 * @return true if item is added in the queue else return false
	 */
	boolean add(T item);

	/**
	 * Removing item from the queue
	 * 
	 * @return item It is the item removed from the queue
	 */
	T remove();

	/**
	 * This method will return the size of the queue
	 * 
	 * @return size of the queue
	 */
	int size();

	/**
	 * This method will check whether queue is empty or not
	 * 
	 * @return true if queue is empty else return false
	 */
	boolean isFull();

	/**
	 * This method will check whether queue is full or not
	 * 
	 * @return true if queue is full else return false
	 */
	boolean isEmpty();
}

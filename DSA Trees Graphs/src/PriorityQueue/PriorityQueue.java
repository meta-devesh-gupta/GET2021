package PriorityQueue;

public interface PriorityQueue<T> {

	/**
	 * Adding item into the queue
	 * 
	 * @param item
	 *            It is the input item
	 * @return true if item is added in the queue else return false
	 */
	boolean addItem(T item);

	/**
	 * Removing item from the queue
	 * 
	 * @return item
	 *            It is the item removed from the queue
	 */
	T removeItem();

	/**
	 * This method will return the item of highest priority
	 */
	T getHighestPriority();

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

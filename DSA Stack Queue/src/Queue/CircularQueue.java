package Queue;

public class CircularQueue implements Queue<Integer> {

	int queue[];
	int front, rear;

	/**
	 * Initializing the queue with total number of elements
	 * 
	 * @param numberOfElements
	 *            It tells the size of the queue
	 */
	public CircularQueue(int numberOfElements) {
		this.queue = new int[numberOfElements];
		this.front = -1;
		this.rear = -1;
	}

	/**
	 * This method will add the item into the queue.
	 * 
	 * @param value
	 *            It is that element that is required to be added into the queue
	 * @return true if value is added into the queue
	 */
	@Override
	public boolean addItem(Integer value) {
		if (isFull())
			throw new AssertionError("Queue is full...overflow!");
		else if (rear == -1) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % queue.length;
			queue[rear] = value;
		}

		return true;
	}

	/**
	 * This method will delete the item from the queue and return the deleted
	 * item
	 * 
	 * @return the deleted item from the queue
	 */
	@Override
	public Integer deleteItem() {
		if (isEmpty())
			throw new AssertionError("Queue is empty...underflow!");
		int deletedItem = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
			front = (front + 1) % queue.length;
		return deletedItem;
	}

	/**
	 * This method will check whether queue is empty or not
	 * 
	 * @return true if queue is empty else return false
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1)
			return true;
		return false;
	}

	/**
	 * This method will check whether queue is full or not
	 * 
	 * @return true if queue is full else return false
	 */
	@Override
	public boolean isFull() {
		if (front == ((rear + 1) % queue.length))
			return true;
		return false;
	}

}

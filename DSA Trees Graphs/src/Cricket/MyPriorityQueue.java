package Cricket;

public class MyPriorityQueue implements PriorityQueue<Bowler> {
	private Bowler queue[];
	private int front;
	private int rear;
	private int size = 0;

	// Initializing the queue with total number of bowlers in the queue
	public MyPriorityQueue(int numberOfElements) {
		this.queue = new Bowler[numberOfElements];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}

	/**
	 * Add bowler to the queue
	 * 
	 * @param item
	 *            The bowler to add
	 */
	@Override
	public boolean add(Bowler item) {
		if (isFull())
			throw new AssertionError("Queue is full...overflow!");
		else if (rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = item;
		} else {
			int index = rear;
			while ((index >= 0) && (item.bowlerQuota > queue[index].bowlerQuota)) {
				queue[index + 1] = queue[index];
				index--;
			}
			queue[index + 1] = item;
			rear = rear + 1;
		}
		this.size++;
		return true;
	}

	/**
	 * Remove the highest bowlerQuota bowler from the queue
	 */
	@Override
	public Bowler remove() {
		if (isEmpty())
			throw new AssertionError("Queue is empty...underflow!");
		Bowler deletedBowler = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			int index = front;
			while (index < rear) {
				queue[index] = queue[index + 1];
				index++;
			}
			rear = rear - 1;
		}

		this.size--;
		return deletedBowler;
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
		if (rear == queue.length-1)
			return true;
		return false;
	}

	/**
	 * This method will return the size of the queue
	 * 
	 * @return size of the queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return the queue
	 */
	public Bowler[] getQueue() {
		return queue;
	}

	/**
	 * @return the front
	 */
	public int getFront() {
		return front;
	}

	/**
	 * @return the rear
	 */
	public int getRear() {
		return rear;
	}

}

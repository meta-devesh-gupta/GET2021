package PriorityQueue;

public class MyPriorityQueue implements PriorityQueue<Item> {
	private Item queue[];
	private int front;
	private int rear;
	private int size = 0;

	/**
	 * Initializing MyPriorityQueue
	 * 
	 * @param numberOfElements
	 *            It is the size of the queue
	 */
	public MyPriorityQueue(int numberOfElements) {
		this.queue = new Item[numberOfElements];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}

	/**
	 * Adding item into the queue
	 * 
	 * @param item
	 *            It is the input item
	 * @return true if item is added in the queue else return false
	 */
	@Override
	public boolean addItem(Item item) {
		if (isFull())
			throw new AssertionError("Queue is full...overflow!");
		else if (rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = item;
		} else {
			int index = rear;
			while ((index >= 0) && (item.priority > queue[index].priority)) {
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
	 * Removing item from the queue
	 * 
	 * @return item
	 *            It is the item removed from the queue
	 */
	@Override
	public Item removeItem() {
		if (isEmpty())
			throw new AssertionError("Queue is empty...underflow!");
		Item deletedItem = queue[front];
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
		return deletedItem;
	}

	/**
	 * This method will return the item of highest priority
	 */
	@Override
	public Item getHighestPriority() {
		if (isEmpty())
			throw new AssertionError("Queue is empty");
		return queue[front];
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
		if (rear == queue.length - 1)
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

	// to display the queue
	public void display() {
		for (int index = front; index <= rear; index++)
			System.out.println(queue[index].value + "\t"
					+ queue[index].priority);
	}

	// public static void main(String[] args) {
	// MyPriorityQueue myPriorityQueue = new MyPriorityQueue(4);
	// myPriorityQueue.addItem(new Item("Item 4", 4));
	// myPriorityQueue.addItem(new Item("Item 2", 2));
	// myPriorityQueue.addItem(new Item("Item 1", 1));
	// myPriorityQueue.addItem(new Item("Item 3", 2));
	// myPriorityQueue.addItem(new Item("Item 4", 4));
	// myPriorityQueue.display();
	// System.out.println(myPriorityQueue.removeItem().value);
	// myPriorityQueue.addItem(new Item("Item 5", 5));
	// myPriorityQueue.display();
	// System.out.println(myPriorityQueue.getHighestPriority().value);
	// }

}

package College;

import java.util.Arrays;

import Queue.Queue;

public class StudentQueue implements Queue<Student> {

	Student queue[];
	int front, rear;
	int size;

	/**
	 * Initializing the queue with total number of elements
	 * 
	 * @param numberOfElements
	 *            It tells the size of the queue
	 */
	public StudentQueue(int numberOfElements) {
		this.queue = new Student[numberOfElements];
		this.front = -1;
		this.rear = -1;
		this.size=0;
	}

	/**
	 * This method will add the item into the queue.
	 * 
	 * @param value
	 *            It is that element that is required to be added into the queue
	 * @return true if value is added into the queue
	 */
	@Override
	public boolean addItem(Student value) {
		if (isFull())
			throw new AssertionError("Queue is full...overflow!");
		else if (rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = value;
			size++;
		} else {
			rear = (rear + 1) % queue.length;
			queue[rear] = value;
			size++;
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
	public Student deleteItem() {
		if (isEmpty())
			throw new AssertionError("Queue is empty...underflow!");
		Student deletedItem = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
			front = (front + 1) % queue.length;
		size--;
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

	/**
	 * This method will return the size of the queue
	 * @return size of the queue
	 */
	@Override
	public int size(){
		return size;
	}
	
	@Override
	public String toString() {
		return "StudentQueue [queue=" + Arrays.toString(queue) + ", front="
				+ front + ", rear=" + rear + "]";
	}

}

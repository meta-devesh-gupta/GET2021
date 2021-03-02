package question2;

public class Search {

	/**
	 * Searching linearly whether value is present in the array or not.
	 * 
	 * @param array
	 *            array is the array where value needs to be searched.
	 * @param value
	 *            value is that	 value which needs to be searched
	 * @return return the index if array[index]==value else return -1
	 */
	public int linearSearch(int array[], int value) {
		int index = linearSearchUsingRecursion(array, value, 0);
		return index;
	}

	/**
	 * This method is the helper method to do the linear search recursively
	 * 
	 * @param array
	 *            array is the array where value needs to be searched.
	 * @param value
	 *            value is than value which needs to be searched
	 * @param index
	 *            index is the current index for which is value is checked
	 *            whether it is present or not in the array
	 * @return return the index if array[index]==value else return -1
	 */
	private int linearSearchUsingRecursion(int array[], int value, int index) {
		if (index < array.length) {
			if (array[index] == value)
				return index;
		} else if (index >= array.length)
			return -1;
		return linearSearchUsingRecursion(array, value, index + 1);
	}

	/**
	 * Binary search is a search algorithm that finds the position of a target
	 * value within a sorted array. Assuming array to be sorted for Binary search.
	 * 
	 @param array
	 *            array is the sorted array where value needs to be searched.
	 * @param value
	 *            value is that target value which needs to be searched
	 * @return
	 */
	public int binarySearch(int array[], int value) {
		int index = binarySearchUsingRecursion(array, value, 0,
				array.length - 1);
		return index;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private int binarySearchUsingRecursion(int array[], int value,
			int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return -1;
		int mid = startIndex + (endIndex - startIndex) / 2;
		if (array[mid] == value)
			return mid;
		else if (value < array[mid])
			return binarySearchUsingRecursion(array, value, startIndex, mid - 1);
		else
			return binarySearchUsingRecursion(array, value, mid + 1, endIndex);
	}
}

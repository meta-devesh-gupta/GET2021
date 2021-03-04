package question1;

public class ArrOperation {
	/**
	 * Mirror section in an array is a group of contiguous elements such that
	 * somewhere in the array, the same group appears in reverse order.
	 * 
	 * @param array
	 *            array contains the input array elements.
	 * @return the size of the maximum group that is mirror in array
	 */
	public int maxMirror(int array[]) {
		int maxCount=1;
		try{
			if(array.length==0)
				throw new AssertionError("Array is Empty");
			
			for(int index=0;index<array.length;index++){
				int currentCount=0;
				for(int left=index, right=array.length-1;(left<array.length) && (right>=0) ; ){
					if(array[left]==array[right]){
						left++;
						right--;
						currentCount++;
					}
					else{
						currentCount=0;
						right--;
					}
				}
				maxCount = Math.max(maxCount, currentCount);
			}
		}
		catch(AssertionError assertionError){
			maxCount=-1;
			System.out.println(assertionError.getMessage());
		}
		return maxCount;
	}

	/**
	 * Clump in an array is a series of 2 or more adjacent elements of the same
	 * value.
	 * 
	 * @param array
	 *            array contains the input array elements.
	 * @return the count of the clumps present in the array
	 */
	public int countClumps(int array[]) {
		int count = 0, currentCount = 0;

		try{
			if(array.length==0)
				throw new AssertionError("Array is empty!");
			for (int index = 1; index < array.length; index++) {
				if (array[index] == array[index - 1])
					currentCount++;
				else {
					if (currentCount >= 1)
						count++;
					currentCount = 0;
				}
			}
			if (currentCount > 0) // {1,1,1,1} , {1,2,4,4}
				count++;
		}
		catch(AssertionError assertionError){
			count=-1;
			System.out.println(assertionError.getMessage());
		}
		return count;
	}

	/**
	 * Return an array that contains exactly the same numbers as the input
	 * array, but rearranged so that every X is immediately followed by a Y. Do
	 * not move X within the array, but every other number may move.
	 * 
	 * @param array
	 *            array contains the input array elements.
	 * @param x
	 *            x is that number in input array which is fixed and can not be
	 *            moved
	 * @param y
	 *            y is that number in input array which will immediately follow
	 *            the x
	 * @return the rearranged array
	 */
	public int[] fixXY(int array[], int x, int y) {
		int previousYIndex = -1;

		try{
			if(array.length==0)
				throw new AssertionError("Array is empty!");
			
			boolean flag=false;
			for(int index=1;index<array.length;index++){
				if((array[index]==x) && (array[index]==array[index-1])){
					flag=true;
					break;
				}
			}

			if(flag)
				throw new AssertionError("Adjacent X value is present");
			
			int countX=0, countY=0;
			for(int index=0;index<array.length;index++){
				if(array[index]==x)
					countX++;
				if(array[index]==y)
					countY++;
			}
			if(countX!=countY)
				throw new AssertionError("Count of x not equal to count of y");
			
			if(array[array.length-1]==x)
				throw new AssertionError("X is present at last index in the array");
			
			for (int index = 0; index < array.length - 1; index++) {
				if (array[index] == x) {
					for (int yIndex = previousYIndex + 1; yIndex < array.length; yIndex++) {
						if (array[yIndex] == y) {
							// swapping
							int temp = array[yIndex];
							array[yIndex] = array[index + 1];
							array[index + 1] = temp;

							previousYIndex = index + 1;
						}
					}
				}
			}

		}
		catch(AssertionError assertionError){
			System.out.println(assertionError.getMessage());
		}
		return array;
	}

	/**
	 * Return the index if there is a place to split the input array so that the
	 * sum of the numbers on one side is equal to the sum of the numbers on the
	 * other side else return -1.
	 * 
	 * @param array
	 *            array contains the input array elements.
	 * @return the index of array such that left side sum is equal to right side
	 *         sum of index else return -1
	 */
	public int splitArray(int array[]) {
		int leftSum = 0, rightSum = 0;
		int splitIndex = -2;
		try{
			for (int value : array)
				rightSum += value;
			
			for (int index = 0; index < array.length; index++) {
				leftSum += array[index];
				rightSum -= array[index];
				if (leftSum == rightSum) {
					splitIndex = index;
					break;
				}
			}
		}
		catch(AssertionError assertionError){
			splitIndex=-2;
			System.out.println(assertionError.getMessage());
		}

		return splitIndex + 1; // 0 -> 1
	}

	public static void main(String[] args) {
		ArrOperation arrOperation = new ArrOperation();
		int array[] = {1,4,1,4,1,5,5};
		// System.out.println(arrOperation.countClumps(array));
		 array=arrOperation.fixXY(array,4,5);
		 for(int i: array)
		 System.out.print(i+" ");
		//System.out.println(arrOperation.fixXY(array, 4, 5));
	}
}

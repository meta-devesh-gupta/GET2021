package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	@Test
	public void linearSearchTest() {
		Search search = new Search();
		int array[]={5,3,7,1,9,2,0,6,4,8};
		
		assertEquals(4,search.linearSearch(array, 9)); //value if present in the array
		assertEquals(-1,search.linearSearch(array, 99)); //value not present in the array
	}
	
	@Test
	public void binarySearchTest(){
		Search search = new Search();
		int array[]={-1,1,2,3,4,5,6,7,8,9};
		
		assertEquals(5, search.binarySearch(array, 5)); //value present at mid
		assertEquals(7, search.binarySearch(array, 7));	//value is greater than mid value
		assertEquals(2, search.binarySearch(array, 2)); //value is less than mid value
		assertEquals(1, search.binarySearch(array, 1)); //value present at index 0
		assertEquals(9, search.binarySearch(array, 9)); //value present at last index
		assertEquals(-1, search.binarySearch(array, 99)); //value is not present in the array
		assertEquals(0, search.binarySearch(array, -1)); //if value is negative
		
	}

}

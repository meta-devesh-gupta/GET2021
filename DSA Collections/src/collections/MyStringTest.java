package collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyStringTest {
	MyString myString;
	
	@Before
	public void init(){
		myString = new MyString();
	}

	@Test(expected=AssertionError.class)
	public void countUniqueCharacterTest() {
		assertEquals(11, myString.countUniqueCharacter("devesh gupta"));
		assertEquals(16, myString.countUniqueCharacter("aioebwkobkw owhballdid oqoinxmoz"));
		assertEquals(12, myString.countUniqueCharacter("dell latitude 5490"));
		assertEquals(14, myString.countUniqueCharacter("count unique characters in string"));
		assertEquals(0, myString.countUniqueCharacter(""));
	}

}

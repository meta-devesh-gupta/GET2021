package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyString {

	Map<String, Integer> cache = new HashMap<>();

	/**
	 * This method will return total number of unique characters in the string
	 * 
	 * @param string
	 *            It is the input string containing characters
	 * @return total number of unique characters in the string
	 */
	public int countUniqueCharacter(String string) {
		int count = 0;

		if(string.length()==0)
			throw new AssertionError("Input string is input");
		
		// if the string is present in the cache than direct return the count
		if (cache.containsKey(string)) {
			count = cache.get(string);
		} else { // calculating the unique characters
			Set<Character> uniqueCharacters = new HashSet<>();
			for (char currentCharacter : string.toCharArray())
				uniqueCharacters.add(currentCharacter);
			count = uniqueCharacters.size();
			cache.put(string, count);
		}
		return count;
	}

	public static void main(String[] args) {
		MyString myString = new MyString();
		System.out.println(myString.countUniqueCharacter("dell latitude 5490"));
		System.out.println(myString.countUniqueCharacter("aioebwkobkw owhballdid oqoinxmoz"));
		System.out.println(myString.countUniqueCharacter("count unique characters in string"));
		System.out.println(myString.countUniqueCharacter("devesh gupta"));
	}
}

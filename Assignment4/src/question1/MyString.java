package question1;

//Assuming Strings to be not null and case sensitive
public class MyString {

	/**
	 * Comparing two strings is equal or not.
	 * 
	 * @param firstString
	 *            firstString is the first input string
	 * @param secondString
	 *            secondString is the second input string
	 * @return integer value 1 if firstString equals secondString else 0
	 */
	public int compare(String firstString, String secondString) {
		int flag = 1;
		if (firstString.length() != secondString.length())
			flag = 0;
		else {
			for (int index = 0; index < firstString.length(); index++) {
				if (firstString.charAt(index) != secondString.charAt(index)) {
					flag = 0;
					break;
				}
			}
		}

		return flag;
	}

	/**
	 * Reversing the input string.
	 * 
	 * @param string
	 *            string is that string that needs to be reversed
	 * @return reverse of input string
	 */
	public String reverse(String string) {
		String reversedString = "";
		for (int index = 0; index < string.length(); index++)
			reversedString = string.charAt(index) + reversedString;
		return reversedString;
	}

	/**
	 * Replacing the lower case characters with upper case characters and
	 * vice-versa.
	 * 
	 * @param string
	 *            string is the input string
	 * @return the string after changing the case of the given string
	 */
	public String changeCase(String string) {
		String convertedString = "";
		for (int index = 0; index < string.length(); index++) {
			char currentCharacter = string.charAt(index);
			if (currentCharacter >= 'A' && currentCharacter <= 'Z') {
				int lowerCase = currentCharacter + 32;
				convertedString += ((char) lowerCase);
			} else if (currentCharacter >= 'a' && currentCharacter <= 'z') {
				int upperCase = currentCharacter - 32;
				convertedString += ((char) upperCase);
			} else
				convertedString += currentCharacter;
		}
		return convertedString;
	}

	/**
	 * Finding the largest word of the string.
	 * 
	 * @param string
	 *            string is the input given string
	 * @return largest word of given string. If two words have same length
	 *         return last word
	 */
	public String findLargestWord(String string) {
		String largestWord = "";
		int largestWordLength = 0;
		String currentString = "";

		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) != ' ')
				currentString += string.charAt(index);
			else {
				if (largestWordLength <= currentString.length()) {
					largestWordLength = currentString.length();
					largestWord = currentString;
				}
				currentString = "";
			}
		}

		if (largestWordLength <= currentString.length()) {
			largestWordLength = currentString.length();
			largestWord = currentString;
		}
		return largestWord;
	}
}

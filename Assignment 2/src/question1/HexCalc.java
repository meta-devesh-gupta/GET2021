package question1;


public class HexCalc {
	/**
	 * Coverting hexadecimal string to decimal string
	 * @param hex is hexadecimal number in string
	 * @return decimal conversion of hex in string
	 */
	public static String hexaToDecimal(String hex) {
		return Integer.parseInt(hex, 16) + "";
	}

	/**
	 * Converting decimal string into hexadecimal string
	 * @param decimal is decimal number in string
	 * @return hexadecimal conversion of decimal in string
	 */
	public static String decimalToHexa(String decimal) {
		return Integer.toHexString(Integer.parseInt(decimal));
	}

	/**
	 * Adding two hexadecimal number
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return sum of num1 and num2 in string
	 */
	public static String add(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec + num2Dec));
		return result;

	}
	/**
	 * Subtracting two hexadecimal number
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return subtraction of num1 and num2 in string
	 */
	public static String subtract(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec - num2Dec));
		return result;
	}
	/**
	 * Multiply two hexadecimal number
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return multiplication of num1 and num2 in string
	 */
	public static String multiply(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec * num2Dec));
		return result;
	}
	/**
	 * Dividing two hexadecimal number
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return division of num1 and num2 in string
	 */
	public static String divide(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec / num2Dec));
		return result;
	}

	/**
	 * Comparing num1==num2
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return boolean value checking whether num1==num2
	 */
	public static boolean isEquals(String num1, String num2) {
		if (num1.equals(num2))
			return true;
		return false;
	}
	/**
	 * Comparing num1>num2
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return boolean value checking whether num1>num2
	 */
	public static boolean isGreaterThan(String num1, String num2) {
		if (num1.compareTo(num2) > 0)
			return true;
		return false;
	}
	/**
	 * Comparing num1<num2
	 * @param num1 is first hexadecimal string
	 * @param num2 is second hexadecimal string
	 * @return boolean value checking whether num1<num2
	 */
	public static boolean isLessThan(String num1, String num2) {
		if (num1.compareTo(num2) < 0)
			return true;
		return false;
	}
	
	//For testing purpose
	public static void main(String[] args) {
		String num1 = "8ab";
		String num2 = "b78";
		System.out.println("Addition: " + add(num1, num2));
		System.out.println("Subtration: " + subtract(num1, num2));
		System.out.println("Multiply: " + multiply(num1, num2));
		System.out.println("Division: " + divide(num1, num2));
		System.out.println("num1 equals to num2: " + isEquals(num1, num2));
		System.out
				.println("num1 greater than num2: " + isGreaterThan(num1, num2));
		System.out.println("num1 less than num2: " + isLessThan(num1, num2));

	}

}

package question1;

public class HexCalc {
	public static String hexaToDecimal(String hex) {
		return Integer.parseInt(hex, 16) + "";
	}

	public static String decimalToHexa(String decimal) {
		return Integer.toHexString(Integer.parseInt(decimal));
	}

	public static String add(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec + num2Dec));
		return result;

	}

	public static String subtract(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec - num2Dec));
		return result;
	}

	public static String multiply(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec * num2Dec));
		return result;
	}

	public static String divide(String num1, String num2) {
		int num1Dec = Integer.parseInt(hexaToDecimal(num1));
		int num2Dec = Integer.parseInt(hexaToDecimal(num2));
		String result = decimalToHexa(String.valueOf(num1Dec / num2Dec));
		return result;
	}

	public static boolean equals(String num1, String num2) {
		if (num1.equals(num2))
			return true;
		return false;
	}

	public static boolean greaterThan(String num1, String num2) {
		if (num1.compareTo(num2) > 0)
			return true;
		return false;
	}

	public static boolean lessThan(String num1, String num2) {
		if (num1.compareTo(num2) < 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		String num1 = "8ab";
		String num2 = "b78";
		System.out.println("Addition: " + add(num1, num2));
		System.out.println("Subtration: " + subtract(num1, num2));
		System.out.println("Multiply: " + multiply(num1, num2));
		System.out.println("Division: " + divide(num1, num2));
		System.out.println("num1 equals to num2: " + equals(num1, num2));
		System.out
				.println("num1 greater than num2: " + greaterThan(num1, num2));
		System.out.println("num1 less than num2: " + lessThan(num1, num2));

	}

}

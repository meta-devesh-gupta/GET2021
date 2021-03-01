package question1;

//HexCalc class will be working with only positive integers
public class HexCalc {
	private int baseValue = 16; //base value of hexadecimal number
	
	/**
	 * Converting hexadecimal string to decimal string
	 * @param hex is hexadecimal number in string
	 * @return decimal conversion of hex in string
	 */
	public  String hexadecimalToDecimal(String hexadecimalString) {
		int baseMultiply = 1;
		int decimalNumber = 0;
		for(int index = hexadecimalString.length()-1;index>=0;index--){
			char currentHexadecimalCharacter = hexadecimalString.charAt(index);
			if(currentHexadecimalCharacter>='1' && currentHexadecimalCharacter<='9'){
				int currentHexadecimalNumber = Integer.parseInt(currentHexadecimalCharacter+"");
				decimalNumber += currentHexadecimalNumber * baseMultiply;
				baseMultiply*=baseValue;
			}
			else if(currentHexadecimalCharacter>='A' && currentHexadecimalCharacter<='F'){
				int currentHexadecimalNumber = Integer.parseInt((currentHexadecimalCharacter-55)+"");
				decimalNumber += currentHexadecimalNumber * baseMultiply;
				baseMultiply*=baseValue;
			}
			else if(currentHexadecimalCharacter>='a' && currentHexadecimalCharacter<='f'){
				int currentHexadecimalNumber = Integer.parseInt((currentHexadecimalCharacter-87)+"");
				decimalNumber += currentHexadecimalNumber * baseMultiply;
				baseMultiply*=baseValue;
			}
		}
		String decimalRepresentation = String.valueOf(decimalNumber);
		return decimalRepresentation;
	}

	/**
	 * Converting decimal string into hexadecimal string
	 * @param decimal is decimal number in string
	 * @return hexadecimal conversion of decimal in string
	 */
	public  String decimalToHexadecimal(String decimal) {
		int decimalNumber = Integer.parseInt(decimal);
		char hexadecimalCharacters[] = {'0','1','2','3','4', '5','6','7','8','9','A'
										,'B','C','D','E','F'};
		String hexadecimalNumber = "";
		while(decimalNumber>0){
			int remainder = decimalNumber % baseValue;
			hexadecimalNumber = hexadecimalCharacters[remainder] + hexadecimalNumber;
			decimalNumber /= baseValue;
		}
		return hexadecimalNumber;
	}

	/**
	 * Adding two hexadecimal number
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return sum of firstHexadecimal and secondHexadecimal in string
	 */
	public  String add(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		String addition = decimalToHexadecimal(String.valueOf(firstHexadecimalDec + secondHexadecimalDec));
		return addition;

	}
	/**
	 * Subtracting two hexadecimal number
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return subtraction of firstHexadecimal and secondHexadecimal in string
	 */
	public  String subtract(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		String subtraction = decimalToHexadecimal(String.valueOf(firstHexadecimalDec - secondHexadecimalDec));
		if(subtraction.equals(""))
			subtraction+="0";
		return subtraction;
	}
	/**
	 * Multiply two hexadecimal number
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return multiplication of firstHexadecimal and secondHexadecimal in string
	 */
	public  String multiply(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		String multiplication = decimalToHexadecimal(String.valueOf(firstHexadecimalDec * secondHexadecimalDec));
		return multiplication;
	}
	/**
	 * Dividing two hexadecimal number
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return division of firstHexadecimal and secondHexadecimal in string
	 */
	public  String divide(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		String division = decimalToHexadecimal(String.valueOf(firstHexadecimalDec / secondHexadecimalDec));
		return division;
	}

	/**
	 * Comparing firstHexadecimal==secondHexadecimal
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return boolean value checking whether firstHexadecimal==secondHexadecimal
	 */
	public  boolean isEquals(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		boolean flag = false;
		if (firstHexadecimalDec==secondHexadecimalDec)
			flag = true;
		return flag;
	}
	/**
	 * Comparing firstHexadecimal>secondHexadecimal
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return boolean value checking whether firstHexadecimal>secondHexadecimal
	 */
	public  boolean isGreaterThan(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		boolean flag = false;
		if (firstHexadecimalDec>secondHexadecimalDec)
			flag = true;
		return flag;
	}
	/**
	 * Comparing firstHexadecimal<secondHexadecimal
	 * @param firstHexadecimal is first hexadecimal string
	 * @param secondHexadecimal is second hexadecimal string
	 * @return boolean value checking whether firstHexadecimal<secondHexadecimal
	 */
	public  boolean isLessThan(String firstHexadecimal, String secondHexadecimal) {
		int firstHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(firstHexadecimal));
		int secondHexadecimalDec = Integer.parseInt(hexadecimalToDecimal(secondHexadecimal));
		boolean flag = false;
		if (firstHexadecimalDec<secondHexadecimalDec)
			flag = true;
		return flag;
	}
	
}

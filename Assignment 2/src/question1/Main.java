package question1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/**
	 * For reading integer input from the user
	 * @return integer read from the user
	 */
	public static int integerInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int integer = 0;

		while (true) {
			try {
				integer = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return integer;
	}
	
	/**
	 * For reading string in input from user
	 * @return string that is read from user
	 */
	public static String stringInput(){
		
		String hexadecimalString = "";
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		while(true){
			try {
				hexadecimalString=bufferedReader.readLine();
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return hexadecimalString;
	}
	
	//For testing purpose
		public static void main(String[] args) {
			HexCalc hexCalc = new HexCalc();
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To convert Hexadecimal to Decimal");
				System.out.println("2. To convert Decimal to Hexadecimal");
				System.out.println("3. To Add Hexadecimal numbers");
				System.out.println("4. To Subtract Hexadecimal numbers");
				System.out.println("5. To Multiply Hexadecimal numbers");
				System.out.println("6. To Divide Hexadecimal numbers");
				System.out.println("7. For isEquals operation");
				System.out.println("8. For isGreaterThan operation");
				System.out.println("9. For isLessThan operation");
				System.out.println("10. TO exit");
				System.out.println("Enter Your Choice: ");

				int userOptionChoice = integerInput();
				String hexadecimalString, decimalString;
				String firstHexadecimal, secondHexadecimal;
				switch (userOptionChoice) {
				case 1:
					System.out.println("Enter Hexadecimal numer: ");
					hexadecimalString = stringInput();
					decimalString = hexCalc.hexadecimalToDecimal(hexadecimalString);
					System.out.println("Hexadecimal: "+ hexadecimalString +" -> Decimal: " + decimalString);
					break;

				case 2:
					System.out.println("Enter Decimal number: ");
					decimalString = stringInput();
					hexadecimalString = hexCalc.decimalToHexadecimal(decimalString);
					System.out.println("Decimal: "+ decimalString +" -> Hexadecimal: " + hexadecimalString);
					break;
					
				case 3:
					System.out.println("Addition: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println("Addition = " + hexCalc.add(firstHexadecimal, secondHexadecimal));
					break;
					
				case 4:
					System.out.println("Subtraction: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println("Subtraction = " + hexCalc.subtract(firstHexadecimal, secondHexadecimal));
					break;

				case 5:
					System.out.println("Multiplication: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println("Multiplication = " + hexCalc.multiply(firstHexadecimal, secondHexadecimal));
					break;

				case 6:
					System.out.println("Division: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println("Division = " + hexCalc.divide(firstHexadecimal, secondHexadecimal));
					break;

				case 7:
					System.out.println("isEqual comparision: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println(firstHexadecimal+" == " + secondHexadecimal +" : "+ 
								hexCalc.isEquals(firstHexadecimal, secondHexadecimal));
					break;
					
				case 8:
					System.out.println("isGreaterThan comparision: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println(firstHexadecimal+" > " + secondHexadecimal +" : "+ 
								hexCalc.isGreaterThan(firstHexadecimal, secondHexadecimal));
					break;
					
				case 9:
					System.out.println("isLessThan comparision: ");
					System.out.println("Enter First Hexadecimal number: ");
					firstHexadecimal = stringInput();
					System.out.println("Enter Second Hexadecimal number: ");
					secondHexadecimal = stringInput();
					System.out.println(firstHexadecimal+" < " + secondHexadecimal +" : "+ 
								hexCalc.isLessThan(firstHexadecimal, secondHexadecimal));
					break;
					
				case 10:
					System.exit(0);

				default:
					System.out.println("Illegal Input");
					break;
				}

			}

		}
}

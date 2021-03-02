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
		
		String string = "";
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		while(true){
			try {
				string=bufferedReader.readLine();
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return string;
	}
	
	//For testing purpose
		public static void main(String[] args) {
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To compare two string");
				System.out.println("2. To reverse the string");
				System.out.println("3. To change the case of string");
				System.out.println("4. To find largest word in the string");
				System.out.println("5. To exit");
				System.out.println("Enter Your Choice: ");

				int userOptionChoice = integerInput();
				MyString myString=new MyString();
				String string;
				switch (userOptionChoice) {
				case 1:
					System.out.println("Enter first string: ");
					String firstString = stringInput();
					System.out.println("Enter second string: ");
					String secondString = stringInput();
					if(myString.compare(firstString,secondString)==1)
						System.out.println(firstString + " is equal to "+ secondString);
					else
						System.out.println(firstString + " is not equal to "+ secondString);
					break;

				case 2:
					System.out.println("Enter the string: ");
					string = stringInput();
					System.out.println("Reversed String: "+myString.reverse(string));
					break;
					
				case 3:
					System.out.println("Enter the string: ");
					string = stringInput();
					System.out.println("Converted String: "+myString.changeCase(string));
					break;
					
				case 4:
					System.out.println("Enter the string: ");
					string = stringInput();
					System.out.println("Largest Word: "+myString.findLargestWord(string));
					break;

				case 5:
					System.exit(0);

				default:
					System.out.println("Illegal Input");
					break;
				}

			}

		}
}

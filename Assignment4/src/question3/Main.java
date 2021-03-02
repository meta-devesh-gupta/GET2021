package question3;

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
	
	public static double doubleInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		double value = 0.0;

		while (true) {
			try {
				value = Double.parseDouble(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return value;
	}
	
	//For testing purpose
		public static void main(String[] args) {
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To calculate area of triangle");
				System.out.println("2. To calculate area of rectangle");
				System.out.println("3. To calculate area of square");
				System.out.println("4. To calculate area of circle");
				System.out.println("5. To exit");
				System.out.println("Enter Your Choice: ");

				double width, height, radius;
				Area area = new Area();
				
				int userOptionChoice = integerInput();
				switch (userOptionChoice) {
				case 1:
					System.out.println("For Triangle: ");
					System.out.println("Enter width: ");
					width= doubleInput();
					System.out.println("Enter height: ");
					height = doubleInput();
					System.out.println("Area of Triangle: "+ area.areaOfTriangle(width, height));
					break;

				case 2:
					System.out.println("For Rectangle: ");
					System.out.println("Enter width: ");
					width= doubleInput();
					System.out.println("Enter height: ");
					height = doubleInput();
					System.out.println("Area of Rectangel: "+ area.areaOfRectangle(width, height));
					break;
					
				case 3:
					System.out.println("For Square: ");
					System.out.println("Enter width: ");
					width= doubleInput();
					System.out.println("Area of Square: "+ area.areaOfSquare(width));
					break;
					
				case 4:
					System.out.println("For Circle: ");
					System.out.println("Enter radius: ");
					radius= doubleInput();
					System.out.println("Area of Circle: "+ area.areaOfCircle(radius));
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
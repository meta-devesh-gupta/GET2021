package question2;

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
	 * Reading a float value in input from user
	 * @return the float value that is read from the user
	 */
	public static float floatInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		float value = 0.0f;

		while (true) {
			try {
				value = Float.parseFloat(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return value;
	}
	
	/**
	 * Reading the polynomial in input from the user
	 * @return the polynomial that is read from the user
	 */
	public static int[] inputPolynomial(){
		System.out.println("Enter the degree of the polynomial: ");
		int degree=integerInput();
		int polynomialCofficients[] = new int[degree+1];
		System.out.println("Enter the coefficients of polynomial in increasing order of their degree: ");
		for(int index=0;index<=degree;index++){
			polynomialCofficients[index] = integerInput();
		}
		return polynomialCofficients;
	}
	
	//For testing purpose
		public static void main(String[] args) {
			System.out.println();
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To evaluate the polynomial");
				System.out.println("2. To add the polynomial");
				System.out.println("3. To multiply the polynomial");
				System.out.println("4. To get the degree of the polynomial");
				System.out.println("5. To exit");
				System.out.println("Enter Your Choice: ");

				int userOptionChoice = integerInput();
				int polynomialCofficients[], firstPolynomialCofficients[], secondPolynomialCofficients[];
				Poly polynomial, firstPolynomial, secondPolynomial;
				switch (userOptionChoice) {
				case 1:
					polynomialCofficients = inputPolynomial();
					polynomial = new Poly(polynomialCofficients);
					System.out.println("Enter the value for which to evaluate: ");
					float value = floatInput();
					System.out.println(polynomial.evaluate(value));
					break;
					
				case 2:
					System.out.println("For Addition:");
					
					System.out.println("For first polynomial: ");
					firstPolynomialCofficients = inputPolynomial();
					firstPolynomial = new Poly(firstPolynomialCofficients);
					
					System.out.println("For second polynomial: ");
					secondPolynomialCofficients = inputPolynomial();
					secondPolynomial = new Poly(secondPolynomialCofficients);
					
					Poly addition = firstPolynomial.addPoly(secondPolynomial);
					System.out.println("Addition = ");
					System.out.print(addition);
					break;
					
				case 3:
					System.out.println("For Multiplication:");
					
					System.out.println("For first polynomial: ");
					firstPolynomialCofficients = inputPolynomial();
					firstPolynomial = new Poly(firstPolynomialCofficients);
					
					System.out.println("For second polynomial: ");
					secondPolynomialCofficients = inputPolynomial();
					secondPolynomial = new Poly(secondPolynomialCofficients);
					
					Poly multiplication = firstPolynomial.multiplyPoly(secondPolynomial);
					System.out.println("Multiplication = ");
					System.out.print(multiplication);
					break;

				case 4:
					polynomialCofficients = inputPolynomial();
					polynomial = new Poly(polynomialCofficients);
					System.out.println(polynomial.degree());
					break;

				case 5:
					System.exit(0);

				default:
					System.out.println("Invalid Input");
					break;
				}
			}

		}
}

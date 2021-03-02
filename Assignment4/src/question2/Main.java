package question2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/**
	 * For reading integer input from the user
	 * 
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

	// For testing purpose
	public static void main(String[] args) {
		while (true) {
			System.out.println("\n        MENU");
			System.out.println("*******************************************");
			System.out
					.println("You Need to choose the option first and then need to enter the grades");
			System.out.println("1. To get average of all grades");
			System.out.println("2. To get maximum of all grades");
			System.out.println("3. To get minimum of all grades");
			System.out.println("4. To get percentage of students passed");
			System.out.println("5. To exit");
			System.out.println("Enter Your Choice: ");

			int numberOfStudents = 0;
			int gradesOfStudent[];

			Marksheet marksheet;

			int userOptionChoice = integerInput();
			switch (userOptionChoice) {
			case 1:
				System.out.println("Enter total number of students: ");
				numberOfStudents = integerInput();

				gradesOfStudent = new int[numberOfStudents];
				System.out.println("Enter grade of students: ");
				for (int student = 0; student < numberOfStudents; student++)
					gradesOfStudent[student] = integerInput();

				marksheet = new Marksheet(gradesOfStudent);

				System.out.println("Average of all grades: "
						+ marksheet.getAverage());

				break;

			case 2:
				System.out.println("Enter total number of students: ");
				numberOfStudents = integerInput();

				gradesOfStudent = new int[numberOfStudents];
				System.out.println("Enter grade of students: ");
				for (int student = 0; student < numberOfStudents; student++)
					gradesOfStudent[student] = integerInput();

				marksheet = new Marksheet(gradesOfStudent);

				System.out.println("Maximum of all grades: "
						+ marksheet.getMaximumGrade());

				break;

			case 3:
				System.out.println("Enter total number of students: ");
				numberOfStudents = integerInput();

				gradesOfStudent = new int[numberOfStudents];
				System.out.println("Enter grade of students: ");
				for (int student = 0; student < numberOfStudents; student++)
					gradesOfStudent[student] = integerInput();

				marksheet = new Marksheet(gradesOfStudent);

				System.out.println("Minimum of all grades: "
						+ marksheet.getMinimumGrade());

				break;

			case 4:
				System.out.println("Enter total number of students: ");
				numberOfStudents = integerInput();

				gradesOfStudent = new int[numberOfStudents];
				System.out.println("Enter grade of students: ");
				for (int student = 0; student < numberOfStudents; student++)
					gradesOfStudent[student] = integerInput();

				marksheet = new Marksheet(gradesOfStudent);

				System.out.println("Percentage of students passed: "
						+ marksheet.passedStudentsPercentage());

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
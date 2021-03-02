package question2;

/**
 *Class Marksheet which reads in grades of n no of students. 
 *Assume n as a positive integer and grades will be between 0 and 100 both inclusive
 */
public class Marksheet {
	private int gradesOfStudent[];
	private int numberOfStudents;

	public Marksheet(int[] gradesOfStudent) {
		this.gradesOfStudent = gradesOfStudent;
		this.numberOfStudents = gradesOfStudent.length;
	}

	/**
	 * Calculating the average of all grades
	 * 
	 * @return average of all grades
	 */
	public float getAverage() {
		float totalGrades = 0.0f;
		for (int grade : gradesOfStudent)
			totalGrades += grade;
		float average = 0.0f;
		try {
			average = totalGrades / numberOfStudents;
			average = Float.parseFloat(String.format("%.2f", average));
		} catch (ArithmeticException exception) {
			System.out.println("Number of student = 0");
		}
		return average;
	}

	/**
	 * calculating the maximum of all grades
	 * 
	 * @return maximum grade of all grades
	 */
	public int getMaximumGrade() {
		int maximumGrade = gradesOfStudent[0];
		for (int student = 1; student < numberOfStudents; student++) {
			if (maximumGrade < gradesOfStudent[student])
				maximumGrade = gradesOfStudent[student];
		}
		return maximumGrade;
	}

	/**
	 * Calculating the minimum of all grades
	 * 
	 * @return minimum grade of all grades
	 */
	public int getMinimumGrade() {
		int minimumGrade = gradesOfStudent[0];
		for (int student = 1; student < numberOfStudents; student++) {
			if (minimumGrade > gradesOfStudent[student])
				minimumGrade = gradesOfStudent[student];
		}
		return minimumGrade;
	}

	/**
	 * Calculating the percentage of students passed
	 * 
	 * @return float percentage value of students passed
	 */
	public float passedStudentsPercentage() {
		int numberOfStudentsPassed = 0;
		for (int grade : gradesOfStudent) {
			if (grade >= 40)
				numberOfStudentsPassed++;
		}
		float percentageOfPassedStudents = 0.0f;
		try {
			percentageOfPassedStudents = (float) numberOfStudentsPassed
					/ numberOfStudents;
			percentageOfPassedStudents *= 100;
			percentageOfPassedStudents = Float.parseFloat(String.format("%.2f",
					percentageOfPassedStudents));

		} catch (ArithmeticException exception) {
			System.err.println("number of students = 0 ");
		}
		return percentageOfPassedStudents;
	}
}

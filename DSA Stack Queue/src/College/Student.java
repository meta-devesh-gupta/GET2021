package College;

import java.util.Arrays;

//Student class containing details of a student
public class Student {
	String studentName;
	String[] programPreference = new String[5];
	String allocatedProgram;

	// Initializing the student object
	public Student(String studentName, String[] programPreference) {
		this.studentName = studentName;
		this.allocatedProgram = "";
		for (int index = 0; index < programPreference.length; index++)
			this.programPreference[index] = programPreference[index];
	}

	// this method will return the name of the student
	public String getStudentName() {
		return studentName;
	}

	// this method will return the program prefrences of the student
	public String[] getProgramPreference() {
		return programPreference;
	}

	//this method will return the allocated program to the student
	public String getAllocatedProgram() {
		return allocatedProgram;
	}

	// this method will allocate the program to the student
	public void setAllocatedProgram(String allocatedProgram) {
		this.allocatedProgram = allocatedProgram;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", programPreference="
				+ Arrays.toString(programPreference) + "]";
	}

}

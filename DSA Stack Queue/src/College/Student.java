package College;

import java.util.Arrays;

public class Student {
	String studentName;
	String[] programPreference = new String[5];

	public Student(String studentName, String[] programPreference) {
		this.studentName = studentName;
		for (int index = 0; index < programPreference.length; index++)
			this.programPreference[index] = programPreference[index];
	}

	public String getStudentName() {
		return studentName;
	}

	public String[] getProgramPreference() {
		return programPreference;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", programPreference="
				+ Arrays.toString(programPreference) + "]";
	}

}

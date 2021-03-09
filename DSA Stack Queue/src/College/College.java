package College;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Queue.Queue;

//Counseling process of college
public class College {
	Queue<Student> studentQueue;
	List<Program> listOfPrograms;
	String path ;

	// Initializing the object of college
	public College(String filename) {
		this.path = filename;
		addStudentsToQueue();
		listOfPrograms = getListOfPrograms();
		
	}

	/**
	 * This method will read students and their program preference choice from
	 * the excel sheet and enter them into the student queue
	 */
	public void addStudentsToQueue() {
		try {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Student Data");

			// fetching total number of students record in the excel sheet
			int totalRows = sheet.getPhysicalNumberOfRows();

			// initializing the student queue
			this.studentQueue = new StudentQueue(totalRows - 1);

			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);
				int cellNum = currentRow.getPhysicalNumberOfCells();

				String studentName = currentRow.getCell(0).getStringCellValue();
				String[] programPreference = new String[5];

				// Entering the program prefrence into the string array
				for (int cell = 1; cell < cellNum; cell++) {
					XSSFCell currentCell = currentRow.getCell(cell);
					programPreference[cell - 1] = currentCell
							.getStringCellValue();
				}

				// after reading the student record, creating the student object
				Student newStudent = new Student(studentName, programPreference);
				// adding the student into the queue
				this.studentQueue.addItem(newStudent);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will read the programs and its capacity from the excel sheet
	 * and make list of it
	 * 
	 * @return return the list of programs
	 */
	public List<Program> getListOfPrograms() {
		List<Program> listOfPrograms = new LinkedList<>();
		try {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Program Data");

			// fetching total number of program from the excel sheet
			int totalRows = sheet.getPhysicalNumberOfRows();

			// for each program row
			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);

				String programName = currentRow.getCell(0).getStringCellValue();
				int programCapacity = (int) currentRow.getCell(1)
						.getNumericCellValue();

				// adding the program into the list of programs
				listOfPrograms.add(new Program(programName, programCapacity));
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfPrograms;
	}

	/**
	 * This method will allocate the programs to the students from their choice
	 * of program preference
	 */
	public boolean allocateProgramToStudents() {
		List<Student> listOfStudents = new LinkedList<>();
		while (!studentQueue.isEmpty()) {
			// boolean isProgramAllocated = false;
			Student currentStudent = studentQueue.deleteItem();

			for (int index = 0; index < currentStudent.programPreference.length; index++) {
				// checking the capacity of the current prefered program of
				// student
				for (int program = 0; program < listOfPrograms.size(); program++) {
					Program currentProgram = listOfPrograms.get(program);
					if (currentStudent.programPreference[index]
							.equals(currentProgram.getProgramName())) {
						if (currentProgram.hasCapacity()) {
							currentStudent
									.setAllocatedProgram(currentProgram.programName);
							currentProgram.setCapacity(currentProgram
									.getCapacity() - 1);
							// isProgramAllocated = true;
							break;
						}
					}
				}
			}
			listOfStudents.add(currentStudent);
		}
		return writingTheDataIntoExcelSheet(listOfStudents);
	}

	/**
	 * This method will write the student record that is student name and
	 * allocated program into the excel sheet
	 * 
	 * @param listOfStudents
	 *            It contains the list of students
	 */
	public boolean writingTheDataIntoExcelSheet(List<Student> listOfStudents) {
		boolean flag=false;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();

			// fetching the total number of student record from the list to be
			// entered into the excel sheet
			int totalRows = listOfStudents.size();

			// Initializing first row with the title of the column
			XSSFRow firstRow = sheet.createRow(0);
			firstRow.createCell(0).setCellValue("Student Name");
			firstRow.createCell(1).setCellValue("Program Allocated");

			// inserting the each student and its allocated program name into
			// the excel sheet
			for (int row = 0; row < totalRows; row++) {
				Student currentStudent = listOfStudents.get(row);
				XSSFRow currentRow = sheet.createRow(row + 1);
				String studentName = currentStudent.getStudentName();
				String allocatedProgram = currentStudent.getAllocatedProgram();
				currentRow.createCell(0).setCellValue(studentName);
				currentRow.createCell(1).setCellValue(allocatedProgram);
			}

			// writing the workbook
			String path = "Allocation.xlsx";
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			workbook.close();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

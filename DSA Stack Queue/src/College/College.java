package College;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Queue.Queue;

public class College {
	Queue<Student> studentQueue;
	List<Program> listOfPrograms;

	public College() {
		addStudentsToQueue();
		listOfPrograms = getListOfPrograms();
	}

	public void addStudentsToQueue() {
		try {
			String path = "C:\\Users\\devesh.gupta_metacub\\workspace\\DSA Stack Queue\\src\\ExcelData.xlsx";
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Student Data");
			int totalRows = sheet.getPhysicalNumberOfRows();
			
			this.studentQueue = new StudentQueue(totalRows);
			
			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);
				int cellNum = currentRow.getPhysicalNumberOfCells();
				String studentName = currentRow.getCell(0).getStringCellValue();
				String[] programPreference = new String[5];
				for (int cell = 1; cell < cellNum; cell++) {
					XSSFCell currentCell = currentRow.getCell(cell);
					programPreference[cell - 1] = currentCell
							.getStringCellValue();
				}
				Student newStudent = new Student(studentName, programPreference);
				System.out.println(newStudent);
				this.studentQueue.addItem(newStudent);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getTotalStudents() {
		int totalStudents = 0;
		try {
			String path = "C:\\Users\\devesh.gupta_metacub\\workspace\\DSA Stack Queue\\src\\ExcelData.xlsx";
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Student Data");
			totalStudents = sheet.getPhysicalNumberOfRows();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalStudents - 1;
	}

	public void addStudents() {
		// Program[] programPrefrences
	}

	public List<Program> getListOfPrograms() {
		List<Program> listOfPrograms = new LinkedList<>();
		try {
			String path = "C:\\Users\\devesh.gupta_metacub\\workspace\\DSA Stack Queue\\src\\ExcelData.xlsx";
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Program Data");
			int totalRows = sheet.getPhysicalNumberOfRows();
			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);
				String programName = currentRow.getCell(0).getStringCellValue();
				int programCapacity = (int) currentRow.getCell(1)
						.getNumericCellValue();
				listOfPrograms.add(new Program(programName, programCapacity));
			}
			workbook.close();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LinkedList<>(listOfPrograms);
	}

	public void displayPrograms() {
		for (Program p : listOfPrograms)
			System.out.println(p.getProgramName() + " " + p.getCapacity());
	}

//	public void displayStudents(){
//		while(!studentQueue.isEmpty()){
//			System.out.println(studentQueue.deleteItem());
//		}
//	}
	
	public int getTotalPrograms() {
		int totalPrograms = 0;
		try {
			String path = "C:\\Users\\devesh.gupta_metacub\\workspace\\DSA Stack Queue\\src\\ExcelData.xlsx";
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Program Data");
			totalPrograms = sheet.getPhysicalNumberOfRows();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPrograms - 1;
	}

	public static void main(String[] args) {
		College college = new College();
		//college.displayStudents();
	}
}

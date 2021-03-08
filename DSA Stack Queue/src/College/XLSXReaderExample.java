package College;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReaderExample {
	public static void main(String[] args) {
		try {
			File file = new File(
					"C:\\Users\\devesh.gupta_metacub\\workspace\\DSA Stack Queue\\src\\ExcelData.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file); 
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(1);
			int rowNum = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowNum; i++) {
				XSSFRow row = sheet.getRow(i);
				int cellNum = row.getPhysicalNumberOfCells();
				for (int j = 0; j < cellNum; j++) {
					XSSFCell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue()+" ");
						break;
					case NUMERIC:
						System.out.println(cell.getNumericCellValue()+" ");
						break;
					default:
						break;
					}
				}
				System.out.println();
			}
			workbook.close();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
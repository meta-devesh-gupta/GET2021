package College;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollegeTest {
	College college;
	
	@Before
	public void init(){
		college = new College("ExcelData1.xlsx");
	}
	@Test
	public void test() {
		assertTrue(college.allocateProgramToStudents());
	}
	
}

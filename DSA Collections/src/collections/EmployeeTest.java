package collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	EmployeeMain employeeMain;
	
	@Before
	public void init(){
		employeeMain = new EmployeeMain();
	}

	@Test(expected = AssertionError.class)
	public void addEmployeeTest() {
		assertTrue(employeeMain.addEmployee(1, "Devesh Gupta", "Alwar Rajasthan"));
		assertTrue(employeeMain.addEmployee(2, "Anuj Khandelwal", "Jaipur Rajasthan"));
		assertTrue(employeeMain.addEmployee(3, "Bharat Gupta", "Bilwara Rajasthan"));
		
		//duplicate employee id
		assertTrue(employeeMain.addEmployee(2, "Chirag Khandelwal", "Jaipur Rajasthan"));
		
		assertTrue(employeeMain.addEmployee(4, "Manish Khandelwal", "Alwar Rajasthan"));
		assertTrue(employeeMain.addEmployee(5, "Narendra Modi", "Surat Gujrat"));
	}

}

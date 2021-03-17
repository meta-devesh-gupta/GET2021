package QuickSort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuickSortImplTest {
	QuickSortImpl quickSortImpl;
	LinkedList<Employee> employeeLinkedList;
	@Before
	public void init(){
		quickSortImpl = new QuickSortImpl();
		employeeLinkedList = new LinkedList<>();
	}

	
	@Test
	public void sortEmployeeLinkedListTest() {
		employeeLinkedList.add(new Employee("A", 10000, 10));
		employeeLinkedList.add(new Employee("B", 40000, 28));
		employeeLinkedList.add(new Employee("C", 20000, 18));
		employeeLinkedList.add(new Employee("D", 20000, 28));
		employeeLinkedList.add(new Employee("E", 10000, 28));
		quickSortImpl.sortEmployeeLinkedList(employeeLinkedList);
		
		String empNameActual[] = new String[employeeLinkedList.getSize()];
		for(int index=0;index<employeeLinkedList.getSize();index++){
			empNameActual[index] = employeeLinkedList.get(index).getEmployeeName();
		}
		
		String empNameExpected[] = {"B","C","D","A","E"};
		
		assertArrayEquals(empNameExpected, empNameActual);
	}

}

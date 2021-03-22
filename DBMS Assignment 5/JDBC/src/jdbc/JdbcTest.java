package jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JdbcTest {

	JdbcMain jdbcMain;
	
	@Before
	public void init(){
		jdbcMain = new JdbcMain();
	}
	
	@Test
	public void fetchAllOrdersTest() {
		try {
			ArrayList<Orders> orderList = jdbcMain.fetchAllOrders(1004);
			int actual[] = new int[orderList.size()];
			for(int index=0;index<orderList.size();index++)
				actual[index] = orderList.get(index).getOrderId();
			int expected[] ={2003};
			assertArrayEquals(expected, actual);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void displayTopCategoriesTest() {
		try {
			ArrayList<Category> categoryList = jdbcMain.displayTopCategories();
			int actual[] = new int[categoryList.size()];
			for(int index=0;index<categoryList.size();index++)
				actual[index] = categoryList.get(index).getId();
			int expected[] ={304,305,301,306};
			assertArrayEquals(expected, actual);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void deleteProdutsTest() {
		try {
			assertEquals(1, jdbcMain.deleteProduts());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

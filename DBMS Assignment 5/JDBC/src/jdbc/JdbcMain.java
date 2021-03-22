package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcMain {
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String host = "jdbc:mysql://localhost:3306/";
	private String dbName = "storefront";
	private String jdbcURL = host + dbName;
	private String userId = "root";
	private String password = "toor";

	/**
	 * Setting up the connection
	 * 
	 * @return connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection setUpConnection() throws ClassNotFoundException,
			SQLException {
		Connection connection = null;

		Class.forName(jdbcDriver);
		connection = DriverManager.getConnection(jdbcURL, userId, password);

		return connection;
	}

	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order
	 * date column in chronological order
	 * 
	 * @param userId
	 *            It is input user id
	 * @return array list of Orders
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Orders> fetchAllOrders(int userId) throws SQLException,
			ClassNotFoundException {
		String query = "SELECT O.Order_Id, O.Order_Date, O.Order_Amount, O.Status"
				+ " FROM Orders O"
				+ " INNER JOIN User U"
				+ " ON U.User_Id = O.User_Id"
				+ " AND U.User_Id = "
				+ userId
				+ " WHERE O.Status = 'Shipped'" + "ORDER BY O.Order_Date;";
		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Orders> orderList = new ArrayList<Orders>();

		while (resultSet.next()) {
			Orders order = new Orders(resultSet.getInt(1),
					resultSet.getTimestamp(2), resultSet.getInt(3),
					resultSet.getString(4));
			orderList.add(order);
		}
		connection.close();
		preparedStatement.close();
		return orderList;
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1
	 * year. Return the number of products deleted
	 * 
	 * @return number of products deleted
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteProduts() throws SQLException, ClassNotFoundException {
		String safeUpdate = "SET FOREIGN_KEY_CHECKS=0; ";
		String query = " DELETE FROM Product" + " WHERE Product_Id NOT IN ("
				+ " SELECT DISTINCT(OP.Product_Id)"
				+ " FROM Ordered_Product OP" + " INNER JOIN Orders O"
				+ " ON O.Order_Id = OP.Order_Id"
				+ " WHERE DATEDIFF(NOW(), O.Order_Date) < 365 );";
		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(safeUpdate);
		preparedStatement.execute();
		preparedStatement = connection.prepareStatement(query);
		int result = preparedStatement.executeUpdate();
		connection.close();
		preparedStatement.close();
		return result;
	}

	/**
	 * Insert five or more images of a product using batch insert technique
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertImage() throws SQLException, ClassNotFoundException {
		String[] queries = {
				"INSERT INTO IMAGE (Image_Id, Product_Id, Image_Name, Image_URL)"
						+ "VALUES (521, 101, 'Dell Laptop Image 1', 'dell_laptop/path_image_1')",
				"INSERT INTO IMAGE (Image_Id, Product_Id, Image_Name, Image_URL)"
						+ "VALUES (522, 101, 'Dell Laptop Image 2', 'dell_laptop/path_image_2')",
				"INSERT INTO IMAGE (Image_Id, Product_Id, Image_Name, Image_URL)"
						+ "VALUES (523, 101, 'Dell Laptop Image 3', 'dell_laptop/path_image_3')",
				"INSERT INTO IMAGE (Image_Id, Product_Id, Image_Name, Image_URL)"
						+ "VALUES (524, 101, 'Dell Laptop Image 4', 'dell_laptop/path_image_4')",
				"INSERT INTO IMAGE (Image_Id, Product_Id, Image_Name, Image_URL)"
						+ "VALUES (525, 101, 'Dell Laptop Image 5', 'dell_laptop/path_image_5')" };
		Connection connection = setUpConnection();
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		for (String query : queries)
			statement.addBatch(query);

		statement.executeBatch();

		connection.commit();
		connection.close();
		statement.close();

	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories
	 * 
	 * @return array list of categories
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Category> displayTopCategories() throws SQLException,
			ClassNotFoundException {
		String query = "SELECT P.Category_Id,P.Category_Name, COUNT(C.Category_Id) as Child_Category"
				+ " FROM Category P"
				+ " LEFT JOIN Category C"
				+ " ON P.Category_Id = C.Parent_Category_Id"
				+ " WHERE P.Parent_Category_Id IS NULL"
				+ " GROUP BY P.Category_Id" + " ORDER BY P.Category_Name;";

		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Category> categoryList = new ArrayList<Category>();

		while (resultSet.next()) {
			Category category = new Category(resultSet.getInt(1),
					resultSet.getString(2), resultSet.getInt(3));
			categoryList.add(category);
		}
		connection.close();
		preparedStatement.close();
		return categoryList;
	}

//	public static void main(String[] args) throws ClassNotFoundException {
//		try {
//			JdbcMain jdbcMain = new JdbcMain();
//			ArrayList<Orders> orderList = jdbcMain.fetchAllOrders(1004);
//			for (Orders order : orderList)
//				System.out.println(order);
//			// System.out.println(jdbcMain.deleteProduts());
//			//jdbcMain.insertImage();
//			ArrayList<Category> categoryList = jdbcMain.displayTopCategories();
//			for (Category category : categoryList)
//				System.out.println(category);
//		} catch (SQLException sqlException) {
//			System.out.println(sqlException.getMessage());
//		}
//	}
}

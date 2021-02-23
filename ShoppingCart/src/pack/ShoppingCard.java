package pack;

import java.util.HashMap;

// ShoppingCard class to store predefined current item available in the shop
class ShoppingCard {
	private static Product biscuit = new Product( "Biscuit", 90, 20);
	private static Product sanitizer = new Product( "Sanitizer", 120, 50);
	private static Product vaseline = new Product( "Vaseline", 50, 5);
	private static Product pepsi = new Product( "Pepsi", 45, 35);
	private static Product chips = new Product( "Chips", 25, 10);

	/**
	 * Putting the products into hashmap 
	 * @return the HashMap<index, product>
	 */
	public static HashMap<Integer, Product> toHashMap() {
		HashMap<Integer, Product> productList = new HashMap<>();
		productList.put(1, biscuit);
		productList.put(2, sanitizer);
		productList.put(3, vaseline);
		productList.put(4, pepsi);
		productList.put(5, chips);
		return productList;
	}

}
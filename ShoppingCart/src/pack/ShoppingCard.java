package pack;

import java.util.HashMap;

// ShoppingCard class to store predefined current item available in the shop
class ShoppingCard {
	private static Product biscuit = new Product(1, "Biscuit", 90, 20);
	private static Product sanitizer = new Product(2, "Sanitizer", 120, 50);
	private static Product vaseline = new Product(3, "Vaseline", 50, 5);
	private static Product pepsi = new Product(4, "Pepsi", 45, 35);
	private static Product chips = new Product(5, "Chips", 25, 10);

	/**
	 * Putting the products into hashmap 
	 * @return the HashMap<index, product>
	 */
	public static HashMap<Integer, Product> toHashMap() {
		HashMap<Integer, Product> productList = new HashMap<>();
		productList.put(biscuit.getProductID(), biscuit);
		productList.put(sanitizer.getProductID(), sanitizer);
		productList.put(vaseline.getProductID(), vaseline);
		productList.put(pepsi.getProductID(), pepsi);
		productList.put(chips.getProductID(), chips);
		return productList;
	}

}
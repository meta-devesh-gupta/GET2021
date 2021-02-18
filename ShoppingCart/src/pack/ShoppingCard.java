package pack;

import java.util.HashMap;

class ShoppingCard {
	private static Product biscuit = new Product("bis", "Biscuit", 90, 20);
	private static Product sanitizer = new Product("san", "Sanitizer", 120, 50);
	private static Product vaseline = new Product("vas", "Vaseline", 50, 5);
	private static Product pepsi = new Product("pep", "Pepsi", 45, 35);
	private static Product chips = new Product("chi", "Chips", 25, 10);

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
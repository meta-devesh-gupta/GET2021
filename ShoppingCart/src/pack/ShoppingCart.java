package pack;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private static HashMap<Product, Integer> currentCart = new HashMap<>();
	private static HashMap<Integer,Product> productList = ShoppingCard
			.toHashMap();

	/**
	 * Adding item into the shopping cart
	 * @param productID is the product index of the productList
	 * @param quantity is the number of quantity to be added
	 * @return boolean value checking whether product is added or not
	 */
	public  boolean addItemToCart(int productID, int quantity) {
		boolean flag = true;

		Product product = productList.get(productID);
		if (isValidQuantity(product, quantity)) {
			currentCart.put(product,quantity);
			product.setQuantity(product.getQuantity() - quantity);
		} else
			flag = false;
		
		return flag;
	}

	/**
	 * Updating the product quantity into the cart
	 * @param productID is the product index of the productList
	 * @param updatedQuantity is the number of quantity to be updated
	 * @return boolean value checking whether product quantity is updated or not
	 */
	public boolean updateItemQuantity(int productID, int updatedQuantity){
		boolean flag = false;
		if(!deleteItemFromCart(productID))
			flag = false;
		else{
			if(!addItemToCart(productID, updatedQuantity))
				flag=false;
			else
				flag = true;
			
		}
		return flag;
	}
	
	/**
	 * Delete item from the shopping cart
	 * @param productID is the ID of product to be deleted from the cart
	 * @return boolean value checking whether product is deleted or not
	 */
	 public boolean deleteItemFromCart(int productID){
		 boolean flag = true;
		 if (currentCart.size() == 0)
			 flag = false;
		 else{
			 Product product = productList.get(productID);
			 product.setQuantity(product.getQuantity()+currentCart.get(product));
			 currentCart.remove(product);
			 flag = true;
		 }
		 return flag;
	 }
	
	/**
	 * Displaying the product name and quantity present in the cart
	 */
	public  boolean displayCart() {
		boolean flag = true;
		if (currentCart.size() == 0)
			flag = false;
		else {
			System.out.println("\n\tShopping Cart:");
			System.out.println("*******************************************");
			for (Map.Entry<Product, Integer> me : currentCart.entrySet()) {
				Product product = (Product) me.getKey();
				int quantity = (int)me.getValue();
				System.out.println("Product ID: "+ product.getProductID()+"\n\tProduct Name: "+ product.getProductName() + 
						"\tProduct Quantity: " + quantity);
			}
			flag = true;
		}
		return flag;
	}

	/**
	 * Generating the bill of the product items present in the cart
	 */
	public  void generateBill() {
		if (currentCart.size() != 0) {
			System.out.println("\n                   BILL                   ");
			System.out.println("*******************************************");
			int totalCost = 0;
			for (Map.Entry<Product, Integer> me : currentCart.entrySet()) {
				Product product = (Product) me.getKey();
				String itemName = product.getProductName();
				int itemQuantity = (Integer) me.getValue();
				int itemPrice = product.getPrice() * itemQuantity;
				System.out.println("Product Name: "+itemName +"\n   Quanity: "+ itemQuantity
						+ "\t    Price: " + itemPrice);
				totalCost += itemPrice;
			}
			System.out.println("*******************************************");
			System.out.println("Total Cost : " + totalCost);
		} else
			System.out.println("Shopping Cart is Empty!");
	}
	
	/**
	 * Checking whether the product ID is present in productList
	 * @param productID is the product index of the productList
	 * @return boolean value checking productList contains productID
	 */
	public boolean isValidProductID(int productID){
		return productList.containsKey(productID);
	}

	/**
	 * Checking whether the product is present in the ShoppingCart
	 * @param productID is the product index of the productList
	 * @return boolean value checking product is present in the cart
	 */
	public boolean isValidProductIDInCart(int productID){
		boolean flag = true;
		if(!isValidProductID(productID))
			flag = false;
		else{
			Product product = productList.get(productID);
			flag = currentCart.containsKey(product);
		}
		return flag;
	}
	
	/**
	 * Checking the entered quantity is valid or not
	 * @param product is the product in productList
	 * @param quantity is user entered quantity
	 * @return boolean value is quantity is valid
	 */
	public boolean isValidQuantity(Product product, int quantity){
		boolean flag = true;
		if(quantity <= 0 || product.getQuantity() < quantity)
			flag = false;
		return flag;
	}
	
	/**
	 * Displaying available items in the shop from ShoppingCard
	 */
	public  void displayAvailableItems() {
		for(Map.Entry<Integer, Product> productEntry: productList.entrySet()){
			Product product = (Product)productEntry.getValue();
			System.out.println(product);
		}
			
	}

}

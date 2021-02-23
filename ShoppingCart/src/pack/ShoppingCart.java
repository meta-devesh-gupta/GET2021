package pack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 
public class ShoppingCart {
	
	private static HashMap<Product, Integer> currentCart = new HashMap<>();
	private static HashMap<Integer, Product> productList = ShoppingCard
			.toHashMap();

	/**
	 * Adding item into the shopping cart
	 * @param choice is the product index of the productList
	 * @param quantity is the number of quantity to be added
	 * @return boolean value checking whether product is added or not
	 */
	public  boolean addItemToCart(int choice, int quantity) {
		if (choice >= 1 && choice <= 5) {
			Product product = productList.get(choice);
			if (product.getQuantity() >= quantity) {
				currentCart.put(product,
						currentCart.getOrDefault(product, 0) + quantity);
				product.setQuantity(product.getQuantity() - quantity);
			} else
				return false;
		}
		return true;
	}

	/**
	 * Updating the product item quantity into the cart
	 * @param choice is the product index of the productList
	 * @param quantity is the number of quantity to be updated
	 * @return boolean value checking whether product quantity is updated or not
	 */
	public boolean updateItemQuantity(int choice, int quantity){
		if (choice >= 1 && choice <= 5) {
			Product product = productList.get(choice);
			int originalQuanitity = currentCart.get(product)+product.getQuantity();
			if (originalQuanitity >= quantity) {
				currentCart.put(product, quantity);
				product.setQuantity(originalQuanitity - quantity);
			} else
				return false;
		}
		return true;
	}
	
	/**
	 * Delete item from the shopping cart
	 * @param choice is the product index of the productList
	 * @param quantity is the number of quantity to be deleted
	 * @return boolean value checking whether product is deleted or not
	 */
	 public boolean deleteItemFromCart(int choice, int quantity){
		 if (currentCart.size() == 0){
				System.out.println("Shopping Cart is Empty!");
				return false;
		 }
		 else{
			 Product product = productList.get(choice);
			 if(currentCart.get(product)==quantity)
				 currentCart.remove(product);
			 else
				 currentCart.put(product, currentCart.get(product)-quantity);
			 int quan = product.getQuantity();
			 product.setQuantity(quan+quantity);
			 return true;
		 }
	 }
	
	/**
	 * Displaying the product name and quantity present in the cart
	 */
	public  boolean displayCart() {
		if (currentCart.size() == 0)
			return false;
		else {
			System.out.println("\n\tShopping Cart:");
			System.out.println("*******************************************");
			for (Map.Entry<Product, Integer> me : currentCart.entrySet()) {
				Product product = (Product) me.getKey();
				String itemName = product.getItemName();
				int itemQuantity = (Integer) me.getValue();
				System.out.println("Product Name: "+itemName + "    Product Quantity: "
						+ itemQuantity);
			}
			return true;
		}
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
				String itemName = product.getItemName();
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
	 * Displaying available items in the shop from ShoppingCard
	 */
	public  void displayAvailableItems() {
		HashMap<Integer, Product> productList = ShoppingCard.toHashMap();
		System.out.println("Available Items in the Shopping Card: ");
		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i + 1);
			System.out.println((i + 1) + ". " +"Product Name: "+ product);
		}

	}

	//For Testing
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		while (true) {
			System.out.println("\n        Shopping Cart MENU");
			System.out.println("*******************************************");
			System.out.println("1. To display available items");
			System.out.println("2. To add item into the cart");
			System.out.println("3. To update item quantity into the cart");
			System.out.println("4. To delete item into the cart");
			System.out.println("5. To display cart items");
			System.out.println("6. To generate bill");
			System.out.println("7. To exit");
			System.out.println("Enter Your Choice: ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			int ch, quantity;
			switch (choice) {
			case 1:
				shoppingCart.displayAvailableItems();
				break;

			case 2:
				shoppingCart.displayAvailableItems();
				System.out.println("Enter product number to add: ");
				ch = scanner.nextInt();
				System.out.println("Enter quantity to add: ");
				quantity = scanner.nextInt();
				if(!shoppingCart.addItemToCart(ch, quantity))
					System.out.println("Invalid Quanitity...Product can't be added into the cart.");
				else 
					System.out.println("Product added Successfully...");
				break;
			
			case 3:
				shoppingCart.displayAvailableItems();
				System.out.println("Enter product number to update: ");
				ch = scanner.nextInt();
				System.out.println("Enter quantity to update: ");
				quantity = scanner.nextInt();
				if(!shoppingCart.updateItemQuantity(choice, quantity))
					System.out.println("Invalid Quanitity...Product can't be added into the cart.");
				else 
					System.out.println("Product quantity updated Successfully...");
				break;
				
			case 4:
				shoppingCart.displayAvailableItems();
				if(!shoppingCart.displayCart()){
					System.out.println("Shopping Cart is Empty!");
					break;
				}
				System.out.println("Enter product number to remove: ");
				ch = scanner.nextInt();
				System.out.println("Enter quantity to delete: ");
				quantity = scanner.nextInt();
				shoppingCart.deleteItemFromCart(ch, quantity);
				break;

			case 5:
				shoppingCart.displayCart();
				break;

			case 6:
				shoppingCart.generateBill();
				break;

			case 7:
				return;

			default:
				System.out.println("Illegal Input");
				break;
			}
		}
	}

}

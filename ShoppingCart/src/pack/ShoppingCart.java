package pack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
	private static HashMap<Product, Integer> currentCart = new HashMap<>();
	private static HashMap<Integer, Product> productList = ShoppingCard
			.toHashMap();

	public  boolean addItemToCart(int choice, int quantity) {
		if (choice >= 1 && choice <= 5) {
			Product product = productList.get(choice);
			if (product.getQuantity() >= quantity) {
				currentCart.put(product,
						currentCart.getOrDefault(product, 0) + quantity);
				product.setQuantity(product.getQuantity() - quantity);
			} else
				return false;
			return true;
		}
		return false;
	}

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
	
	public  void displayCart() {
		if (currentCart.size() == 0)
			System.out.println("Shopping Cart is Empty!");
		else {
			System.out.println("Product Name                       Quantity");
			System.out.println("*******************************************");
			for (Map.Entry<Product, Integer> me : currentCart.entrySet()) {
				Product product = (Product) me.getKey();
				String itemName = product.getItemName();
				int itemQuantity = (Integer) me.getValue();
				System.out.println(itemName + "                       "
						+ itemQuantity);
			}
		}
	}

	public  void generateBill() {
		if (currentCart.size() != 0) {
			System.out.println("                    BILL                   ");
			System.out.println("*******************************************");
			System.out.println("Product Name         Quantity         Price");
			System.out.println("*******************************************");
			int totalCost = 0;
			for (Map.Entry<Product, Integer> me : currentCart.entrySet()) {
				Product product = (Product) me.getKey();
				String itemName = product.getItemName();
				int itemQuantity = (Integer) me.getValue();
				int itemPrice = product.getPrice() * itemQuantity;
				System.out.println(itemName + "         " + itemQuantity
						+ "         " + itemPrice);
				totalCost += itemPrice;
			}
			System.out.println("*******************************************");
			System.out.println("Total Cost : " + totalCost);
		} else
			System.out.println("Shopping Cart is Empty!");
	}

	public  void displayAvailableItems() {
		HashMap<Integer, Product> productList = ShoppingCard.toHashMap();
		System.out.println("Available Items in the Shopping Card: ");
		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i + 1);
			System.out.println((i + 1) + ". " + product.getItemName());
		}

	}

	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		while (true) {
			System.out.println("\n                    MENU                   ");
			System.out.println("*******************************************");
			System.out.println("1. To display available items");
			System.out.println("2. To add item into the cart");
			System.out.println("3. To delete item into the cart");
			System.out.println("4. To display cart items");
			System.out.println("5. To generate bill");
			System.out.println("6. To exit");
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
				shoppingCart.addItemToCart(ch, quantity);
				break;

			case 3:
				shoppingCart.displayAvailableItems();
				shoppingCart.displayCart();
				System.out.println("Enter product number to remove: ");
				ch = scanner.nextInt();
				System.out.println("Enter quantity to delete: ");
				quantity = scanner.nextInt();
				shoppingCart.deleteItemFromCart(ch, quantity);
				break;

			case 4:
				shoppingCart.displayCart();
				break;

			case 5:
				shoppingCart.generateBill();
				break;

			case 6:
				return;

			default:
				System.out.println("Illegal Input");
				break;
			}
		}
	}

}

package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int integerInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int integer = 0;

		while (true) {
			try {
				integer = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return integer;
	}
	
	// For Testing
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		while (true) {
			System.out.println("\n        Shopping Cart MENU");
			System.out
					.println("*******************************************");
			System.out.println("1. To display available products");
			System.out.println("2. To add product into the cart");
			System.out.println("3. To update product quantity into the cart");
			System.out.println("4. To delete product product the cart");
			System.out.println("5. To display cart product");
			System.out.println("6. To generate bill");
			System.out.println("7. To exit");
			System.out.println("Enter Your Choice: ");

			int userOptionChoice = integerInput();
			int productID, quantity;
			switch (userOptionChoice) {
			case 1:
				shoppingCart.displayAvailableItems();
				break;

			case 2:
				shoppingCart.displayAvailableItems();
				System.out.println("Enter product ID to add: ");
				productID = integerInput();
				if(!shoppingCart.isValidProductID(productID)){
					System.out.println("Invalid ProductID.....");
					break;
				}
				System.out.println("Enter quantity to add: ");
				quantity = integerInput();
				if (!shoppingCart.addItemToCart(productID, quantity))
					System.out
							.println("Invalid Quanitity...Product can't be added into the cart.");
				else
					System.out.println("Product added Successfully...");
				break;

			case 3:
				if (!shoppingCart.displayCart()) {
					System.out.println("Shopping Cart is Empty!");
					break;
				}
				System.out.println("Enter product ID to update quantity: ");
				productID = integerInput();
				if(!shoppingCart.isValidProductIDInCart(productID)){
					System.out.println("Invalid ProductID.....");
					break;
				}
				System.out.println("Enter updated quantity: ");
				quantity = integerInput();
				if (!shoppingCart.updateItemQuantity(productID, quantity))
					System.out
							.println("Invalid Quanitity...Product can't be updated into the cart.");
				else
					System.out.println("Product quantity updated Successfully...");
				break;

			case 4:
				if (!shoppingCart.displayCart()) {
					System.out.println("Shopping Cart is Empty!");
					break;
				}
				System.out.println("Enter product ID to delete product from cart: ");
				productID = integerInput();
				if(!shoppingCart.isValidProductIDInCart(productID)){
					System.out.println("Invalid ProductID.....");
					break;
				}
				if(!shoppingCart.deleteItemFromCart(productID))
					System.out
							.println("Shopping Cart is Empty!");
				else
					System.out.println("Product deleted Successfully...");
				break;

			case 5:
				shoppingCart.displayCart();
				break;

			case 6:
				shoppingCart.generateBill();
				break;

			case 7:
				System.exit(0);

			default:
				System.out.println("Illegal Input");
				break;
			}

		}
	}
}

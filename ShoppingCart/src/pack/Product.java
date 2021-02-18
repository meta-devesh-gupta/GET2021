package pack;

class Product {
	private final String itemCode;
	private final String itemName;
	private int quantity;
	private final int price;

	public Product(String itemCode, String itemName, int quantity, int price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

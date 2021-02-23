package pack;

//Product class to describe the attributes of the product
class Product {
	private final String itemName;
	private int quantity;
	private final int price;

	public Product( String itemName, int quantity, int price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
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
	
	public String toString(){
		return itemName + "\n     Quantity: "+quantity;
	}
}

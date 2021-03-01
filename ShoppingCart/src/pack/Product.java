package pack;

//Product class to describe the attributes of the product
class Product {
	private final String productName;
	private int quantity;
	private final int price;
	private final int productID;

	public Product(  int productID, String productName, int quantity, int price) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
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

	public int getProductID() {
		return productID;
	}
	
	public String toString(){
		return "Product ID: "+ this.getProductID()+"\n\tProduct Name: "+ this.getProductName() + 
				"\tProduct Quantity: " + this.getQuantity();
	}

}

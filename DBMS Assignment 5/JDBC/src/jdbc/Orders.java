package jdbc;

import java.sql.Timestamp;

//Orders class containing details such as order id, order date, order amount and order staus.
public class Orders {
	private int orderId;
	private Timestamp orderDate;
	private int orderAmount;
	private String orderStatus;
		
	public Orders(int orderId, Timestamp orderDate, int orderAmount,
			String orderStatus) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderDate
	 */
	public Timestamp getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderAmount
	 */
	public int getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate
				+ ", orderAmount=" + orderAmount + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
}

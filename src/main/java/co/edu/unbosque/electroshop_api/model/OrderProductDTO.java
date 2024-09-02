package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;

public class OrderProductDTO {
	
	@NotBlank
	private int orderId;
	@NotBlank
	private int productId;
	@NotBlank
	private int quantity;
	
	public OrderProductDTO() {
		
	}

	public OrderProductDTO(@NotBlank int orderId, @NotBlank int productId, @NotBlank int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

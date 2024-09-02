package co.edu.unbosque.electroshop_api.model;

import java.util.Date;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

public class ProcessedOrderDTO {
	
	@NotBlank
	private String customerName;
	@NotBlank
	private String customerAddress;
	@NotBlank
	@PastOrPresent
	private Date date;
	@NotEmpty
	private Map<Integer, Integer> products;
	@NotBlank
	private String paymentMethod;
	@NotBlank
	private String status;
	@NotBlank
	private float totalPrice;
	@NotBlank
	private float priceWithIVA;
	
	public ProcessedOrderDTO() {
		
	}

	public ProcessedOrderDTO(@NotBlank String customerName, @NotBlank String customerAddress,
			@NotBlank @PastOrPresent Date date, @NotEmpty Map<Integer, Integer> products,
			@NotBlank String paymentMethod, @NotBlank String status, @NotBlank float totalPrice,
			@NotBlank float priceWithIVA) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.date = date;
		this.products = products;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.totalPrice = totalPrice;
		this.priceWithIVA = priceWithIVA;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, Integer> products) {
		this.products = products;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getPriceWithIVA() {
		return priceWithIVA;
	}

	public void setPriceWithIVA(float priceWithIVA) {
		this.priceWithIVA = priceWithIVA;
	}
	
}

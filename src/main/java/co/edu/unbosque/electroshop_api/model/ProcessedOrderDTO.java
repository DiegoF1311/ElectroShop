package co.edu.unbosque.electroshop_api.model;

import java.util.Date;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

/**
 * DTO representing an order that has been processed.
 * <p>
 * This DTO contains details about the customer, the order, and the payment.
 * </p>
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util 
 */
@Schema(description = "DTO representing an order that has been processed. Contains details about the customer, order, and payment.")
public class ProcessedOrderDTO {
	
	/**
     * Name of the customer who placed the order.
     * <p>
     * This field cannot be blank.
     * </p>
     */
	@NotBlank
	@Schema(description = "Name of the customer.", example = "Jane Doe")
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

	/**
     * Address of the customer who placed the order.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @Schema(description = "Address of the customer.", example = "Ak. 9 #131a-2")
    @NotBlank(message = "Customer address cannot be blank")
    private String customerAddress;

    /**
     * Date when the order was processed.
     * <p>
     * This field cannot be blank and must be in the past or present.
     * </p>
     */
    @Schema(description = "Date when the order was processed.", example = "2024-09-01T12:34:56Z")
    @NotBlank(message = "Date cannot be blank")
    @PastOrPresent(message = "Date must be in the past or present")
    private Date date;

    /**
     * Map of product IDs to quantities for the order.
     * <p>
     * This field cannot be empty.
     * </p>
     */
    @Schema(description = "Map of product IDs to quantities for the order.", example = "{ \"1\": 2, \"2\": 3 }")
    @NotEmpty(message = "Products map cannot be empty")
    private Map<Integer, Integer> products;

    /**
     * Method of payment used for the order.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @Schema(description = "Method of payment used for the order.", example = "Credit Card")
    @NotBlank(message = "Payment method cannot be blank")
    private String paymentMethod;

    /**
     * Current status of the order.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @Schema(description = "Current status of the order.", example = "In process")
    @NotBlank(message = "Status cannot be blank")
    private String status;

    /**
     * Total price of the order before taxes.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @Schema(description = "Total price of the order.", example = "100.000")
    @NotBlank(message = "Total price cannot be blank")
    private float totalPrice;

    /**
     * Total price of the order including IVA (tax).
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @Schema(description = "Total price of the order including IVA.", example = "118.588")
    @NotBlank(message = "Price with IVA cannot be blank")
    private float priceWithIVA;
	
    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code ProcessedOrderDTO}.
     * </p>
     */
	public ProcessedOrderDTO() {
		
	}

	 /**
     * Constructs a new {@code ProcessedOrderDTO} with the specified values.
     * 
     * @param customerName the name of the customer
     * @param customerAddress the address of the customer
     * @param date the date when the order was processed
     * @param products a map of product IDs to quantities
     * @param paymentMethod the method of payment used for the order
     * @param status the current status of the order
     * @param totalPrice the total price of the order
     * @param priceWithIVA the total price of the order including IVA
     */
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

	/**
	 * Getters and Setters
	 */
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

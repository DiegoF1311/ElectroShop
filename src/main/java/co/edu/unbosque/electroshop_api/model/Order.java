package co.edu.unbosque.electroshop_api.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entity representing an order placed by a customer.
 * <p>
 * This class defines the structure of an order within the system, including details such as the order date, payment method,
 * status, total price, and associated customer and products.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Entity
@Table(name = "orders")
@Schema(description = "Entity representing an order placed by a customer, including details such as the order date, payment method,\n"
		+ " * status, total price, and associated customer and products.")
public class Order {

	/**
     * Unique identifier for the order.
     * <p>
     * This field is automatically generated.
     * </p>
     */
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the order.", example = "1")
    private Integer orderId;

    /**
     * Date when the order was placed.
     * <p>
     * This field is required.
     * </p>
     */
    @Column(name = "date", nullable = false)
    @Schema(description = "Date when the order was placed.", example = "2024-09-03T00:00:00.000+00:00")
    private Date date;

    /**
     * Method used to pay for the order.
     * <p>
     * This field is required.
     * </p>
     */
    @Column(name = "payment_method", nullable = false)
    @Schema(description = "Method used to pay for the order.", example = "Credit Card")
    private String paymentMethod;

    /**
     * Current status of the order.
     * <p>
     * This field is required.
     * </p>
     */
    @Column(name = "status", nullable = false)
    @Schema(description = "Current status of the order.", example = "Pending")
    private String status;

    /**
     * Total price of the order.
     * <p>
     * This field is required.
     * </p>
     */
    @Column(name = "total_price", nullable = false)
    @Schema(description = "Total price of the order .", example = "100.0")
    private Float totalPrice;

    /**
     * Total price of the order including IVA.
     * <p>
     * This field is required.
     * </p>
     */
    @Column(name = "iva_price", nullable = false)
    @Schema(description = "Total price of the order including IVA.", example = "119.0")
    private Float priceWithIVA;

    /**
     * Customer who placed the order.
     * <p>
     * This field is a reference to the customer entity.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @JsonBackReference
    @Schema(description = "Customer who placed the order.")
    private Customer customer;

    /**
     * List of products included in the order.
     * <p>
     * This field is a list of {@link OrderProduct} entities associated with the order.
     * </p>
     */
    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    @Schema(description = "List of products included in the order.")
    private List<OrderProduct> orderProducts;	
    
    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code Order}.
     * </p>
     */
	public Order() {
		
	}

	/**
     * Constructs a new {@code Order} with the specified details.
     * 
     * @param orderId the unique identifier for the order
     * @param date the date when the order was placed
     * @param paymentMethod the method used to pay for the order
     * @param status the current status of the order
     * @param totalPrice the total price of the order
     * @param priceWithIVA the total price of the order including IVA
     * @param customer the customer who placed the order
     * @param orderProducts the list of products included in the order
     */
	public Order(Integer orderId, Date date, String paymentMethod, String status, Float totalPrice,
			Float priceWithIVA, Customer customer, List<OrderProduct> orderProducts) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.totalPrice = totalPrice;
		this.priceWithIVA = priceWithIVA;
		this.customer = customer;
		this.orderProducts = orderProducts;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getPriceWithIVA() {
		return priceWithIVA;
	}

	public void setPriceWithIVA(Float priceWithIVA) {
		this.priceWithIVA = priceWithIVA;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
}

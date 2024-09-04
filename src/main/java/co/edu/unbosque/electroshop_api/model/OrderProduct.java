package co.edu.unbosque.electroshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entity representing the relationship between an order and the products it contains.
 * <p>
 * This class defines the association between an order and the products included in that order.
 * It uses a composite key consisting of both the order ID and the product ID.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Entity
@Table(name = "product_order")
@Schema(description = "Entity representing the relationship between an order and the products it contains. including product's id, quantity of the product, the order and the product")
public class OrderProduct {

	/**
     * Composite key consisting of order ID and product ID.
     * <p>
     * This field is used to uniquely identify the relationship between an order and a product.
     * </p>
     */
    @EmbeddedId
    @Schema(description = "Composite key consisting of order ID and product ID.")
    private OrderProductId id = new OrderProductId();

    /**
     * Quantity of the product in the order.
     * <p>
     * This field represents how many units of the product are included in the order.
     * </p>
     */
    @Column(name = "quantity")
    @Schema(description = "Quantity of the product in the order.", example = "2")
    private int quantity;

    /**
     * Order to which this product belongs.
     * <p>
     * This field is a reference to the {@link Order} entity associated with this product.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonBackReference
    @Schema(description = "Order to which this product belongs.")
    private Order order;

    /**
     * Product included in the order.
     * <p>
     * This field is a reference to the {@link Product} entity that is part of the order.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonBackReference
    @Schema(description = "Product included in the order.")
    private Product product;

    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code OrderProduct}.
     * </p>
     */
    public OrderProduct() {
		// TODO Auto-generated constructor stub
	}
    
    /**
     * Constructs a new {@code OrderProduct} with the specified details.
     * 
     * @param order the order to which this product belongs
     * @param product the product included in the order
     * @param quantity the quantity of the product in the order
     */
    public OrderProduct(Order order, Product product, int quantity) {
        this.id = new OrderProductId(order.getOrderId(), product.getProductId());
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
    /**
     * Gets the composite key consisting of order ID and product ID.
     * 
     * @return the composite key
     */
    public OrderProductId getId() {
        return id;
    }

    /**
     * Sets the composite key consisting of order ID and product ID.
     * 
     * @param id the composite key
     */
    public void setId(OrderProductId id) {
        this.id = id;
    }

    /**
     * Gets the quantity of the product in the order.
     * 
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order.
     * 
     * @param quantity the quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the order to which this product belongs.
     * 
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order to which this product belongs.
     * 
     * @param order the order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Gets the product included in the order.
     * 
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product included in the order.
     * 
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
}

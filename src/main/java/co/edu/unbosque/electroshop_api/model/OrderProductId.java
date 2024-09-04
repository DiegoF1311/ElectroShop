package co.edu.unbosque.electroshop_api.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import jakarta.persistence.Embeddable;

/**
 * Represents a composite key consisting of an order ID and a product ID.
 * <p>
 * This class is used as a composite key for the {@link OrderProduct} entity, identifying a unique combination of an order and a product.
 * </p>
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util 
 */
@Embeddable
@Schema(description = "OrderProduct, representing a combination of order and product IDs.")
public class OrderProductId implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
     * Identifier for the order.
     * <p>
     * This field represents the unique identifier for the order in the composite key.
     * </p>
     */
    @Schema(description = "Identifier for the order", example = "123")
    private Integer orderId;

    /**
     * Identifier for the product.
     * <p>
     * This field represents the unique identifier for the product in the composite key.
     * </p>
     */
    @Schema(description = "Identifier for the product", example = "456")
    private Integer productId;

    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code OrderProductId}.
     * </p>
     */
    public OrderProductId() {}

    /**
     * Constructs a new {@code OrderProductId} with the specified order and product IDs.
     * 
     * @param orderId the identifier for the order
     * @param productId the identifier for the product
     */
    public OrderProductId(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    /**
     * Gets the identifier for the order.
     * 
     * @return the identifier for the order
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Sets the identifier for the order.
     * 
     * @param orderId the identifier for the order
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the identifier for the product.
     * 
     * @return the identifier for the product
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets the identifier for the product.
     * 
     * @param productId the identifier for the product
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the {@code o} argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductId that = (OrderProductId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    /**
     * Returns a hash code value for the object.
     * 
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}


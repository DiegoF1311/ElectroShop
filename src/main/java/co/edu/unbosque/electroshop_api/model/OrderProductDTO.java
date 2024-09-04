package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO representing the relationship between an Order and a Product.
 * <p>
 * This class is used for transferring data that represents the association between an order and a product, including the quantity of the product in the order.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util 
 * */
@Schema(description = "DTO representing the relationship between an Order and a Product, including the quantity of the product in the order, the order's id and product's id.")
public class OrderProductDTO {
	
	/**
     * Identifier of the order.
     * <p>
     * This field represents the unique identifier of the order to which the product is associated.
     * </p>
     */
    @Schema(description = "Identifier of the order", example = "123")
    @NotBlank
    private int orderId;

    /**
     * Identifier of the product.
     * <p>
     * This field represents the unique identifier of the product included in the order.
     * </p>
     */
    @Schema(description = "Identifier of the product", example = "456")
    @NotBlank
    private int productId;

    /**
     * Quantity of the product in the order.
     * <p>
     * This field represents the number of units of the product included in the order.
     * </p>
     */
    @Schema(description = "Quantity of the product in the order", example = "2")
    @NotBlank
    private int quantity;
	
    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code OrderProductDTO}.
     * </p>
     */
	public OrderProductDTO() {
		
	}

	/**
     * Constructs a new {@code OrderProductDTO} with the specified details.
     * 
     * @param orderId the identifier of the order
     * @param productId the identifier of the product
     * @param quantity the quantity of the product in the order
     */
	public OrderProductDTO(@NotBlank int orderId, @NotBlank int productId, @NotBlank int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	 /**
     * Gets the identifier of the order.
     * 
     * @return the identifier of the order
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the identifier of the order.
     * 
     * @param orderId the identifier of the order
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the identifier of the product.
     * 
     * @return the identifier of the product
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the identifier of the product.
     * 
     * @param productId the identifier of the product
     */
    public void setProductId(int productId) {
        this.productId = productId;
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
	
}

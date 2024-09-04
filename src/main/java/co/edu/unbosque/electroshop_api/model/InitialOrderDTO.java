package co.edu.unbosque.electroshop_api.model;

import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for initial order information.
 * <p>
 * This class encapsulates the information required to create an initial order, including customer details, product quantities,
 * payment method, and card details.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Schema(description = "DTO for initial order information. Including customer details, product quantities,\n"
		+ " * payment method, and card details.")
public class InitialOrderDTO {
	
	/**
     * The unique identifier for the customer placing the order.
     * <p>
     * This field is required and must be between 1 and 10 characters in length.
     * </p>
     */
	@Schema(description = "Unique customer identifier", example = "1111111111", minLength = 1, maxLength = 10)
	@NotBlank(message = "Customer ID cannot be blank")
	@Size(min = 1, max = 10, message = "Customer ID must have 10 digits")
	private String customerId;
	
	/**
     * A map of product identifiers to quantities for the order.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Map from product identifiers to quantities", example = "{ \"1\": 2, \"2\": 3 }")
	@NotNull
	private Map<Integer, Integer> productsId;
	
	 /**
     * The method of payment for the order.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Method of payment", example = "Credit Card")
	@NotBlank
	private String paymentMethod;
	
	 /**
     * The card details for the payment method.
     * <p>
     * This field is optional and is validated if provided.
     * </p>
     */
	@Schema(description = "Card details for the payment method", example = "implementation = CardDTO.class")
	@Valid
	private CardDTO card;
	
	/**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code InitialOrderDTO}.
     * </p>
     */
	public InitialOrderDTO() {
		
	}

	/**
     * Constructs a new {@code InitialOrderDTO} with the specified details.
     * 
     * @param customerId the unique identifier for the customer
     * @param productsId a map of product identifiers to quantities
     * @param paymentMethod the method of payment for the order
     * @param card the card details for the payment method
     */
	public InitialOrderDTO(
			@NotBlank(message = "Customer ID cannot be blank") @Size(min = 1, max = 10, message = "Customer ID must have 10 digits") String customerId,
			@NotNull Map<Integer, Integer> productsId, @NotBlank String paymentMethod, @Valid CardDTO card) {
		super();
		this.customerId = customerId;
		this.productsId = productsId;
		this.paymentMethod = paymentMethod;
		this.card = card;
	}

	 /**
     * Gets the unique identifier for the customer placing the order.
     * 
     * @return the customer identifier
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the unique identifier for the customer placing the order.
     * 
     * @param customerId the new customer identifier
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the map of product identifiers to quantities for the order.
     * 
     * @return the map of product identifiers to quantities
     */
    public Map<Integer, Integer> getProductsId() {
        return productsId;
    }

    /**
     * Sets the map of product identifiers to quantities for the order.
     * 
     * @param productsId the new map of product identifiers to quantities
     */
    public void setProductsId(Map<Integer, Integer> productsId) {
        this.productsId = productsId;
    }

    /**
     * Gets the method of payment for the order.
     * 
     * @return the method of payment
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the method of payment for the order.
     * 
     * @param paymentMethod the new method of payment
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the card details for the payment method.
     * 
     * @return the card details
     */
    public CardDTO getCard() {
        return card;
    }

    /**
     * Sets the card details for the payment method.
     * 
     * @param card the new card details
     */
    public void setCard(CardDTO card) {
        this.card = card;
    }

}

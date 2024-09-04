package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO representing credit card information.
 * <p>
 * This class is used to transfer credit card details in requests, such as during payment processing.
 * It includes fields for the credit card number, expiration date, and security code (CVV), along with validation constraints.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Schema(description = "DTO for credit card information, it includes fields for the credit card number, expiration date, and security code (CVV)")
public class CardDTO {
	
	/**
     * The credit card number.
     * <p>
     * This field must be between 13 and 18 digits long and cannot be blank.
     * </p>
     */
    @Schema(description = "Credit card number", example = "1234567890123456", minLength = 13, maxLength = 18)
    @NotBlank(message = "Card number cannot be blank")
    @Size(min = 13, max = 18, message = "Card number must have 13 to 18 digits")
    private String cardNumber;

    /**
     * The expiration date of the card.
     * <p>
     * This field must be in MM/YYY format and cannot be blank.
     * </p>
     */
    @Schema(description = "Card expiration date in MM/YYY format", example = "09/24")
    @NotBlank(message = "Expiration date cannot be blank")
    @Size(min = 5, max = 5, message = "Invalid Format of Expiration date")
    private String expirationDate;

    /**
     * The security code (CVV) of the card.
     * <p>
     * This field must be exactly 3 digits long and cannot be blank.
     * </p>
     */
    @Schema(description = "Card security code", example = "123", minLength = 3, maxLength = 3)
    @NotBlank(message = "CVV cannot be blank")
    @Size(min = 3, max = 3, message = "CVV must have 3 digits")
    private String cvv;
	
    /**
     * Default constructor.
     */
	public CardDTO() {
		
	}

	/**
     * Constructs a new {@code CardDTO} with the specified details.
     *
     * @param cardNumber the credit card number
     * @param expirationDate the expiration date of the card in MM/YYY format
     * @param cvv the card's security code (CVV)
     */
	public CardDTO(
			@NotBlank(message = "Card number cannot be blank") @Size(min = 13, max = 18, message = "Card number must have 13 to 18 digits") String cardNumber,
			@NotBlank(message = "Expiration date cannot be blank") String expirationDate,
			@NotBlank(message = "CVV cannot be blank") @Size(min = 3, max = 3, message = "CVV must have 3 digits") String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}
	 /**
     * Gets the credit card number.
     * 
     * @return the credit card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the credit card number.
     * 
     * @param cardNumber the new credit card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiration date of the card.
     * 
     * @return the expiration date in MM/YYY format
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the card.
     * 
     * @param expirationDate the new expiration date
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the card's security code (CVV).
     * 
     * @return the security code (CVV)
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the card's security code (CVV).
     * 
     * @param cvv the new security code (CVV)
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

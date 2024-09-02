package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CardDTO {
	
	@NotBlank(message = "Card number cannot be blank")
    @Size(min = 13, max = 18, message = "Card number must have 13 to 18 digits")
	private String cardNumber;
	
	@NotBlank(message = "Expiration date cannot be blank")
	@Size(min = 5, max = 5, message = "Invalid Format of Expiration date")
	private String expirationDate;
	
	@NotBlank(message = "CVV cannot be blank")
	@Size(min = 3, max = 3, message = "CVV must have 3 digits")
	private String cvv;
	
	public CardDTO() {
		
	}

	public CardDTO(
			@NotBlank(message = "Card number cannot be blank") @Size(min = 13, max = 18, message = "Card number must have 13 to 18 digits") String cardNumber,
			@NotBlank(message = "Expiration date cannot be blank") String expirationDate,
			@NotBlank(message = "CVV cannot be blank") @Size(min = 3, max = 3, message = "CVV must have 3 digits") String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
}

package co.edu.unbosque.electroshop_api.model;

import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InitialOrderDTO {
	
	@NotBlank(message = "Customer ID cannot be blank")
	@Size(min = 1, max = 10, message = "Customer ID must have 10 digits")
	private String customerId;
	@NotNull
	private Map<Integer, Integer> productsId;
	@NotBlank
	private String paymentMethod;
	@Valid
	private CardDTO card;
	
	public InitialOrderDTO() {
		
	}

	public InitialOrderDTO(
			@NotBlank(message = "Customer ID cannot be blank") @Size(min = 1, max = 10, message = "Customer ID must have 10 digits") String customerId,
			@NotNull Map<Integer, Integer> productsId, @NotBlank String paymentMethod, @Valid CardDTO card) {
		super();
		this.customerId = customerId;
		this.productsId = productsId;
		this.paymentMethod = paymentMethod;
		this.card = card;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, Integer> getProductsId() {
		return productsId;
	}

	public void setProductsId(Map<Integer, Integer> productsId) {
		this.productsId = productsId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CardDTO getCard() {
		return card;
	}

	public void setCard(CardDTO card) {
		this.card = card;
	}

}

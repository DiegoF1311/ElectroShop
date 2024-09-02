package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
	
	@NotBlank
	private String name;
	@NotBlank
	private String category;
	@NotBlank
	private float price;
	@NotBlank
	private int stock;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(@NotBlank String name, @NotBlank String category, @NotBlank float price, @NotBlank int stock) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}

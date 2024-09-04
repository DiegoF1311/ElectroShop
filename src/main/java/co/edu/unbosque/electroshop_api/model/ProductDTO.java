package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for product details.
 * <p>
 * Includes product name, category, price, and stock information.
 * </p>
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util 
 */
@Schema(description = "DTO for product details. Includes product name, category, price, and stock information.")
public class ProductDTO {
	
	/**
     * Name of the product.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @NotBlank
    @Schema(description = "Name of the product.", example = "Smartphone")
    private String name;

    /**
     * Category to which the product belongs.
     * <p>
     * This field cannot be blank.
     * </p>
     */
    @NotBlank
    @Schema(description = "Category to which the product belongs.", example = "Electronics")
    private String category;

    /**
     * Price of the product.
     * <p>
     * This field cannot be blank. It represents the cost of the product in the specified currency.
     * </p>
     */
    @NotBlank
    @Schema(description = "Price of the product.", example = "300.000")
    private float price;

    /**
     * Amount of stock available for the product.
     * <p>
     * This field cannot be blank. It represents the quantity of the product currently in stock.
     * </p>
     */
    @NotBlank
    @Schema(description = "Amount of stock available for the product.", example = "100")
    private int stock;
	
    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code ProductDTO}.
     * </p>
     */
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructs a new {@code ProductDTO} with the specified values.
     * 
     * @param name the name of the product
     * @param category the category of the product
     * @param price the price of the product
     * @param stock the amount of stock available for the product
     */
	public ProductDTO(@NotBlank String name, @NotBlank String category, @NotBlank float price, @NotBlank int stock) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	/**
     * Gets the name of the product.
     * 
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * 
     * @param name the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the product.
     * 
     * @return the category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     * 
     * @param category the new category of the product
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price of the product.
     * 
     * @return the price of the product
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price the new price of the product
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the amount of stock available for the product.
     * 
     * @return the amount of stock available
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the amount of stock available for the product.
     * 
     * @param stock the new amount of stock available
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}

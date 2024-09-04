package co.edu.unbosque.electroshop_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entity representing a product in the inventory.
 * <p>
 * Includes details about the product's name, category, stock, and price.
 * </p>
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util 
 */
@Entity
@Table(name = "product")
@Schema(description = "Entity representing a product in the inventory. Includes details about the product's name, category, stock, and price.")
public class Product {

	/**
     * Unique identifier for the product.
     * <p>
     * This field is auto-generated and cannot be null.
     * </p>
     */
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the product.", example = "1")
    private Integer productId;

    /**
     * Name of the product.
     * <p>
     * This field cannot be null.
     * </p>
     */
    @Column(name = "product_name", nullable = false)
    @Schema(description = "Name of the product.", example = "Laptop")
    private String name;

    /**
     * Category to which the product belongs.
     * <p>
     * This field cannot be null.
     * </p>
     */
    @Column(name = "category", nullable = false)
    @Schema(description = "Category to which the product belongs.", example = "Electronics")
    private String category;

    /**
     * Amount of stock available for the product.
     * <p>
     * This field cannot be null.
     * </p>
     */
    @Column(name = "stock", nullable = false)
    @Schema(description = "Amount of stock available for the product.", example = "50")
    private Integer stock;

    /**
     * Price of the product.
     * <p>
     * This field cannot be null.
     * </p>
     */
    @Column(name = "product_value", nullable = false)
    @Schema(description = "Price of the product.", example = "799.99")
    private Float price;

    /**
     * List of order-product associations for the product.
     * <p>
     * This field represents the relationship between products and orders.
     * </p>
     */
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    @Schema(description = "List of order-product associations for the product.")
    private List<OrderProduct> orderProducts;
	
    /**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code Product}.
     * </p>
     */
	public Product() {
		
	}

	/**
     * Constructs a new {@code Product} with the specified values.
     * 
     * @param productId the unique identifier for the product
     * @param name the name of the product
     * @param category the category of the product
     * @param stock the amount of stock available for the product
     * @param price the price of the product
     * @param orderProducts the list of order-product associations for the product
     */
	public Product(Integer productId, String name, String category, Integer stock, Float price,
			List<OrderProduct> orderProducts) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.orderProducts = orderProducts;
	}
	
	/**
	 * Getters and Setters
	 */
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

}

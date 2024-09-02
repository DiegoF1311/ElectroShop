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

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "product_name", nullable = false)
	private String name;
	@Column(name = "category", nullable = false)
	private String category;
	@Column(name = "stock", nullable = false)
	private Integer stock;
	@Column(name = "product_value", nullable = false)
	private Float price;
	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
    private List<OrderProduct> orderProducts;
	
	public Product() {
		
	}

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

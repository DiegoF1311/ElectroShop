package co.edu.unbosque.electroshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_order")
public class OrderProduct {
	
	@EmbeddedId
    private OrderProductId id = new OrderProductId();
    
    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonBackReference
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JsonBackReference
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public OrderProduct() {
		// TODO Auto-generated constructor stub
	}

    public OrderProduct(Order order, Product product, int quantity) {
        this.id = new OrderProductId(order.getOrderId(), product.getProductId());
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

	public OrderProductId getId() {
		return id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
}

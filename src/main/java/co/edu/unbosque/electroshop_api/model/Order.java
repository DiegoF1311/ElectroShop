package co.edu.unbosque.electroshop_api.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(name = "date", nullable = false)
	private Date date;
	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;
	@Column(name = "status", nullable = false)
	private String status;
	@Column(name = "total_price", nullable = false)
	private Float totalPrice;
	@Column(name = "iva_price", nullable = false)
	private Float priceWithIVA;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@JsonBackReference
    private Customer customer;
	
	@OneToMany(mappedBy = "order")
    @JsonManagedReference
    private List<OrderProduct> orderProducts;
	
	public Order() {
		
	}

	public Order(Integer orderId, Date date, String paymentMethod, String status, Float totalPrice,
			Float priceWithIVA, Customer customer, List<OrderProduct> orderProducts) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.totalPrice = totalPrice;
		this.priceWithIVA = priceWithIVA;
		this.customer = customer;
		this.orderProducts = orderProducts;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getPriceWithIVA() {
		return priceWithIVA;
	}

	public void setPriceWithIVA(Float priceWithIVA) {
		this.priceWithIVA = priceWithIVA;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
}

package co.edu.unbosque.electroshop_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_id", nullable = false, columnDefinition = "VARCHAR(10)")
	private String customerId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "gender", nullable = false)
	private String gender;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "email", nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
    private List<Order> orders;
	
	public Customer() {
		
	}

	public Customer(String customerId, String name, String lastName, String gender, String phoneNumber, String address,
			String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String genre) {
		this.gender = genre;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

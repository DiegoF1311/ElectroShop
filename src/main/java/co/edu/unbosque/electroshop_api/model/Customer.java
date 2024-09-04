package co.edu.unbosque.electroshop_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Represents a customer in the system.
 * <p>
 * This class is an entity representing a client with various personal details.
 * Includes attributes such as the customer's ID, name, last name, gender, phone number, address, and email.
 * It also maintains a one-to-many relationship with the {@link Order} entity.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Entity
@Table(name = "customer")
@Schema(description = "Entity that represents a client in the system. Includes attributes such as the customer's ID, name, last name, gender, phone number, address, and email.")
public class Customer {
	
	/**
     * The unique identifier for the customer.
     * <p>
     * This field is marked as the primary key in the database and cannot be null. It is defined as a VARCHAR(10) in the database schema.
     * </p>
     */
	@Id
	@Column(name = "customer_id", nullable = false, columnDefinition = "VARCHAR(10)")
    @Schema(description = "Unique customer identifier.", example = "1111111111")
	private String customerId;
	
	/**
     * The customer's first name.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "name", nullable = false)
    @Schema(description = "Customer's name.", example = "Jane")
	private String name;
	
	/**
     * The customer's last name.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "last_name", nullable = false)
	@Schema(description = "Customer's last name.", example = "Doe")
	private String lastName;
	
	/**
     * The customer's gender.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "gender", nullable = false)
	@Schema(description = "Customer's gender.", example = "M")
	private String gender;
	
	/**
     * The customer's phone number.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "phone_number", nullable = false)
	@Schema(description = "Customer's phone number.", example = "1111111111")
	private String phoneNumber;
	
	/**
     * The customer's address.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "address", nullable = false)
	@Schema(description = "Customer's address.", example = "Ak. 9 #131a-2")
	private String address;
	
	/**
     * The customer's email address.
     * <p>
     * This field cannot be null.
     * </p>
     */
	@Column(name = "email", nullable = false)
	@Schema(description = "Customer's email.", example = "jane123@gmail.com")
	private String email;
	
	/**
     * The list of orders associated with the customer.
     * <p>
     * This is a one-to-many relationship where one customer can have multiple orders.
     * </p>
     */
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	 @Schema(description = "List of orders associated with the customer.")
    private List<Order> orders;
	
	/**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code Customer}.
     * </p>
     */
	public Customer() {
		
	}

	/**
     * Constructs a new {@code Customer} with the specified details.
     * 
     * @param customerId the unique identifier for the customer
     * @param name the customer's first name
     * @param lastName the customer's last name
     * @param gender the customer's gender
     * @param phoneNumber the customer's phone number
     * @param address the customer's address
     * @param email the customer's email address
     */
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
	
	/**
	 * Getters and Setters
	 */

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

package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for transferring customer data.
 * <p>
 * This class is used to encapsulate the customer data that is transferred between the client and server.
 * It includes attributes such as the customer's ID, name, last name, gender, phone number, address, and email.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@Schema(description = "DTO for the transfer of customer data, it includes attributes such as the customer's ID, name, last name, gender, phone number, address, and email.")
public class CustomerDTO {
	
	/**
     * The unique identifier for the customer.
     * <p>
     * This field is required and must be between 1 and 10 characters in length.
     * </p>
     */
	@Schema(description = "Customer identifier", example = "1111111111", minLength = 1, maxLength = 10)
	@NotBlank
	@Size(min = 1, max = 10, message = "Customer ID must have 10 digits or less")
	private String id;
	
	/**
     * The customer's first name.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Customer's name", example = "John")
	@NotBlank
	private String name;
	
	/**
     * The customer's last name.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Customer's last name.", example = "Doe")
	@NotBlank
	private String lastName;
	
	/**
     * The customer's gender.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Customer's gender.", example = "F")
	@NotBlank
	private String gender;
	
	/**
     * The customer's phone number.
     * <p>
     * This field is required and must be exactly 10 digits in length.
     * </p>
     */
	@Schema(description = "Customer number phone", example = "1111111111", minLength = 10, maxLength = 10)
	@NotBlank
	@Size(min = 10, max = 10, message = "Customer Number must have 10 digits")
	private String phoneNumber;
	
	/**
     * The customer's address.
     * <p>
     * This field is required.
     * </p>
     */
	@Schema(description = "Customer address", example = "Ak. 9 #131a-2")
	@NotBlank
	private String address;
	
	/**
     * The customer's email address.
     * <p>
     * This field is required and must be a valid email format.
     * </p>
     */
	@Schema(description = "Customer email", example = "john123@gmail.com")
	@NotBlank
	@Email
	private String email;
	
	/**
     * Default constructor.
     * <p>
     * Initializes a new instance of {@code CustomerDTO}.
     * </p>
     */
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructs a new {@code CustomerDTO} with the specified details.
     * 
     * @param id the unique identifier for the customer
     * @param name the customer's first name
     * @param lastName the customer's last name
     * @param gender the customer's gender
     * @param phoneNumber the customer's phone number
     * @param address the customer's address
     * @param email the customer's email address
     */
	public CustomerDTO(@NotBlank @Size(min = 10, max = 10, message = "Customer ID must have 10 digits") String id,
			@NotBlank String name, @NotBlank String lastName, @NotBlank String gender,
			@NotBlank @Size(min = 10, max = 10, message = "Customer Number must have 10 digits") String phoneNumber,
			@NotBlank String address, @NotBlank @Email String email) {
		super();
		this.id = id;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setGender(String gender) {
		this.gender = gender;
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

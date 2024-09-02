package co.edu.unbosque.electroshop_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDTO {
	
	@NotBlank
	@Size(min = 1, max = 10, message = "Customer ID must have 10 digits or less")
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank
	private String gender;
	@NotBlank
	@Size(min = 10, max = 10, message = "Customer Number must have 10 digits")
	private String phoneNumber;
	@NotBlank
	private String address;
	@NotBlank
	@Email
	private String email;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

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

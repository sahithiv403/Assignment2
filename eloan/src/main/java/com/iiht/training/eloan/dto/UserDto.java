package com.iiht.training.eloan.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
	
	
	private Long id;
	
	@NotNull(message="First Name cannot be null")
	@Size(min = 3, max = 100, message = "First name must be of 3 to 100 chars")
	private String firstName;
	
	@NotNull(message="Last Name cannot be null")
	@Size(min = 3, max = 100, message = "Last name must be of 3 to 100 chars")
	private String lastName;
	
	@NotNull(message="Email cannot be null")
	@Size(min = 3, max = 100, message = "Email must be of 3 to 100 chars")
	@Email
	private String email;
	
	@NotNull(message="Mobile cannot be null")
	@Size(min = 10, max = 10, message = "Mobile must be of 10 to 10 chars")
	private String mobile;
	
	@NotNull(message="Role cannot be null")
	private String role;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}

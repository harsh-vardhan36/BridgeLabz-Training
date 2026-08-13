package com.app.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ContactRequest {
		@NotBlank(message = "First Name is required!")
	 private String firstName;

	    private String lastName;
	    
	    @NotBlank (message = "email must not be blank.")
	    @Email(message = "you have entered a wrong mail address")
	    private String email;
	    
	    @NotBlank(message = "phone number is required")
	    @Pattern(regexp = "^[6-9]\\d{9}$" ,
	    message = "Must be an Indian Number with 10 digit.")
	    private String phone;
	    	
	    @Pattern(regexp = "^[6-9]\\d{9}$" ,
	    	    message = "Must be an Indian Number with 10 digit.")
	    private String secondaryPhone;
	    
	    public ContactRequest() {
	    	
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

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getSecondaryPhone() {
			return secondaryPhone;
		}

		public void setSecondaryPhone(String secondaryPhone) {
			this.secondaryPhone = secondaryPhone;
		}
}

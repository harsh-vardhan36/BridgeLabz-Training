package com.app.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequest {
		@NotBlank
	 private String firstName;

	    private String lastName;
	    @NotBlank
	    @Email
	    private String email;
	    @NotBlank
	    private String phone;

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

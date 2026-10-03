package com.sample.modal;

// JAVABean類別

public class Customer {
	
	//屬性
	private String customerID ;
	private String FirstName ;
	private String LastName ;
	private String Email ;
	
	//無參數建構子
	public Customer() {
		super();
	}
	
	//getxxx & setxxx
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	
	@Override
	public String toString() {
		return "Cudtomer [customerID=" + customerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + "]";
	}
	
	
	
	
	
	
	
}

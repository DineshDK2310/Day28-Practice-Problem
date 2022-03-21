package com.bridgelab.addressbookday28;

public class AddressBook {
	private String firstName, lastName, address, city, state, email;
	private int zipCode;
	private long phoneNumber;

	public AddressBook(String firstName, String lastName, String address, String city, String state,
			int zipCode, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return	"\n First Name : " + firstName + 
				"\n Last Name : " + lastName +
				"\n Address : " + address +
				"\n City : " + city +
				"\n State : " + state +
				"\n Zip Code : " + zipCode +
				"\n Phone Number : " + phoneNumber +
				"\n Email : " + email ;
	}

	public static void main(String[] args) {
		AddressBook data = new AddressBook("Rashmi", "Gajra", "Jawahar Nagar", "SGNR", "Rajasthan", 335001, 1234569874, "gajra.rashmi0504@gmail.com") ;
		data.toString();
	}
}

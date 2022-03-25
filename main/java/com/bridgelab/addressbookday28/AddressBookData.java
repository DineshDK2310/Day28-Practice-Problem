package com.bridgelab.addressbookday28;

import java.util.Objects;

public class AddressBookData {
	public String typeId;
	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String email;
	public String city;
	public String state;
	public String zipCode;

	public AddressBookData( String typeId, String firstName, String lastName, String address,String phoneNumber, String email, String city, String state, String zipCode) {
		this.typeId = typeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AddressBookData)) return false;
		AddressBookData that = (AddressBookData) o;
		return  typeId == that.typeId &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName) &&
				Objects.equals(address, that.address) &&
				Objects.equals(phoneNumber, that.phoneNumber) &&
				Objects.equals(email, that.email) &&
				Objects.equals(city, that.city) &&
				Objects.equals(state, that.state) &&
				Objects.equals(zipCode, that.zipCode);
	}

	@Override
	public String toString() {
		return "AddressBookData{" +
				", typeId=" + typeId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipCode='" + zipCode + '\'' +
				'}';
	}
}

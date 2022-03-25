package com.bridgelab.addressbookday28;

public class AddressBookException extends Exception {
	enum ExceptionType {
		DatabaseException,
	}

	public ExceptionType type;

	public AddressBookException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}

package com.bridgelab.addressbookday28;

import java.util.List;

public class AddressBookService {
	 private List<AddressBookData> addressBookList;

	    public enum IOService {DB_IO}

	    private static AddressBookConnection addressBookConnection;

	    public AddressBookService() {
	        addressBookConnection = AddressBookConnection.getInstance();
	    }

	    public List<AddressBookData> readAddressBookData(IOService ioService) {
	        if (ioService.equals(IOService.DB_IO)) {
	            this.addressBookList = addressBookConnection.readDate();
	        }
	        return addressBookList;
	    }
}

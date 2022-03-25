package com.bridgelab.addressbookday28;

import java.time.LocalDate;
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

	public void updateRecord(String name, String phoneNumber) throws AddressBookException
	{
		int result = addressBookConnection.updateAddressBookRecord(name, phoneNumber);
		if (result==0)return;
		AddressBookData  addressBookData = this.getAddressBookData(name);
		if (addressBookData!=null) addressBookData.phoneNumber=phoneNumber;
	}

	private AddressBookData getAddressBookData(String name)
	{
		return this.addressBookList.stream()
				.filter(addressBookData -> addressBookData.firstName.equals(name))
				.findFirst()
				.orElse(null);
	}

	public boolean checkRecordSyncWithDB(String name)
	{
		List<AddressBookData> addressBookData= addressBookConnection.getAddressBookData(name);
		System.out.println(addressBookData);
		return addressBookData.get(0).equals(getAddressBookData(name));
	}

	public List<AddressBookData> readAddressBookForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate) {
		if (ioService.equals(IOService.DB_IO)) {
			return addressBookConnection.getAddressBookForDateRange(startDate, endDate);
		}
		return null;
	}

	public static void main(String[] args) throws AddressBookException {
		AddressBookService a = new AddressBookService();
		a.updateRecord("Rash", "9667860846");
	}
}

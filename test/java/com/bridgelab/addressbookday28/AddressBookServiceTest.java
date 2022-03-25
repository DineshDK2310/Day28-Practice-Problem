package com.bridgelab.addressbookday28;

import java.util.List;
import static com.bridgelab.addressbookday28.AddressBookService.IOService.DB_IO;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookServiceTest {
	@Test
	public void givenAddressBookInDB_WhenRetrieved_ShouldMatchThePeopleCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
		Assert.assertEquals(5,addressBookDataList.size());
	}
	
	@Test
    public void givenNewPhoneNumber_ShouldUpdateTheRecorAndSyncWithDataBase() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        addressBookService.updateRecord("Rash", "9667860846");
        boolean result = addressBookService.checkRecordSyncWithDB("Rash");
        Assert.assertTrue(result);
    }
}

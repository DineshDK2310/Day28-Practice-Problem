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
}

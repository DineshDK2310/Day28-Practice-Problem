package com.bridgelab.addressbookday28;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMethods {
	
	private String firstName, lastName, address, city, state, email;
	private int zipCode;
	private long phoneNumber;
	ArrayList<AddressBook> contact = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public void readData() {
		System.out.println("Enter the first name: ");
		firstName = sc.next();
		System.out.println("Enter the last name: ");
		lastName = sc.next();
		System.out.println("Enter the address: ");
		address = sc.next();
		System.out.println("Enter the city: ");
		city = sc.next();
		System.out.println("Enter the state: ");
		state = sc.next();
		System.out.println("Enter the zip code: ");
		zipCode = sc.nextInt();
		System.out.println("Enter the phone number: ");
		phoneNumber = sc.nextLong();
		System.out.println("Enter the email: ");
		email = sc.next();

		AddressBookMethods method = new AddressBookMethods();
		boolean duplicate = method.checkDuplicateName(firstName, lastName);

		if(duplicate == false) {
			AddressBook book = new AddressBook(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
			contact.add(book);
			System.out.println("\nContact added Successfully.");
		}
		else {
			System.out.println("Name already exist");
		}
	}

	public boolean checkDuplicateName(String firstName ,String lastName) {
		boolean duplicate = false ;
		for(int i=0;i<contact.size();i++) {
			if(contact.get(i).getFirstName().equals(firstName)&&contact.get(i).getLastName().equals(lastName)) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}

	public void editData(String name) {
		int i,ans;
		for(i = 0 ; i < contact.size() ; i++) {
			if(contact.get(i).getFirstName().equals(name)) {
				do {
					System.out.print("\nSelect option to Edit: \n1.First Name \n2.Last Name \n3.Address \n4.City \n5.State \n6.Zip Code \n7.Phone Number \n8.Email : ");
					int ch = sc.nextInt();
					switch(ch) {
					case 1:
						System.out.print("Enter new first name :- ");
						contact.get(i).setFirstName(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					case 2:
						System.out.print("Enter new last name :- ");
						contact.get(i).setLastName(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					case 3:
						System.out.print("Enter new address :- ");
						contact.get(i).setAddress(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					case 4:
						System.out.print("Enter new city :- ");
						contact.get(i).setCity(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					case 5:
						System.out.print("Enter new state :- ");
						contact.get(i).setState(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					case 6:
						System.out.print("Enter new zip code :- ");
						contact.get(i).setZipCode(sc.nextInt());
						System.out.println("[*]\tEntry Modified");
						break;
					case 7:
						System.out.print("Enter new phone number :- ");
						contact.get(i).setPhoneNumber(sc.nextLong());
						System.out.println("[*]\tEntry Modified");
						break;
					case 8:
						System.out.print("Enter new email :- ");
						contact.get(i).setEmail(sc.next());
						System.out.println("[*]\tEntry Modified");
						break;
					}
					System.out.println("If you want to continue, enter 1");
					ans = sc.nextInt();
				}while(ans == 1);
			}
			else
				System.out.println("Please enter First Name");
		}
		sc.close();

	}
	public void deleteData() {
		int i;
		System.out.println("\nEnter first name to delete : ");
		String name = sc.next();
		for(i = 0 ; i < contact.size() ; i++) {
			if(contact.get(i).getFirstName().equals(name)) {
				contact.removeAll(contact);
				System.out.println("Contact is deleted");
			}
			else
				System.out.println("No one with these details found");
		}
	}

	public void searchPersonByState(String state) {
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("Name: " + contact.getFirstName() +" "+ contact.getLastName());
		}
	}

	public void searchPersonByCity(String city2) {
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("First Name: " + contact.getFirstName()+ "  " + contact.getLastName());
		}
	}

	public void viewPersonByState(String state) {
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("Name: " + contact.getFirstName() +" "+ contact.getLastName());
			System.out.println("State: " + state);
		}
	}

	public void viewPersonByCity(String city2) {
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("City: " + city);
		}
	}

	public int countPersonsByState(String state) {
		int count= 0;
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			count ++;
		}
		return count;
	}

	public int countPersonsByCity(String city) {
		int count = 0 ;
		ArrayList<AddressBook> list = (ArrayList<AddressBook>) contact.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (AddressBook contact : list) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			count +=1;
		}
		return count;
	}

	public void sortByFirstName() {
		ArrayList<AddressBook>  sortedList = (ArrayList<AddressBook>) contact.stream().sorted((sort1, sort2) -> (sort1.getFirstName()
				.compareTo(sort2.getFirstName()))).collect(Collectors.toList());
		for (AddressBook contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
		}
	}

	public void sortByCity() {
		ArrayList<AddressBook>  sortedList = (ArrayList<AddressBook>) contact.stream().sorted((sort1, sort2) -> (sort1.getCity().compareTo(sort2.getCity()))).collect(Collectors.toList());
		for (AddressBook contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("City: " + contact.getCity());
			System.out.println("\n");
		}
	}
	public void sortByState() {
		ArrayList<AddressBook>  sortedList = (ArrayList<AddressBook>) contact.stream().sorted((sort1, sort2) -> (sort1.getState().compareTo(sort2.getState()))).collect(Collectors.toList());
		for (AddressBook contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("State: " +contact.getState());
			System.out.println("\n");
		}
	}
	public void sortByZipCode() {
		ArrayList<AddressBook>  sortedList = (ArrayList<AddressBook>) contact.stream().sorted((sort1, sort2) -> (int)(sort1.getZipCode() - sort2.getZipCode())).collect(Collectors.toList());
		for (AddressBook contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("Zip Code: " + contact.getZipCode());
			System.out.println("\n");
		}
	}

	public void DisplayContacts() {
		System.out.println("\nContacts Present in Address Book:");
		for(int i=0;i<contact.size();i++) {
			System.out.println(contact.get(i));
		}
	}

	public void writeData() {
		StringBuffer personBuffer = new StringBuffer();
		contact.forEach(person -> {
			String personDataString = person.toString().concat("\n");
			personBuffer.append(personDataString);
		});
		try {
			Files.write(Paths.get("Data.txt"), personBuffer.toString().getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileData() {
		try {
			Files.lines(new File("Data.txt").toPath()).map(String::trim).forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void writeDataCSV() {
		StringBuffer personBuffer = new StringBuffer();
		contact.forEach(person -> {
			String personDataString = person.toString().concat("\n");
			personBuffer.append(personDataString);
		});
		try {
			Files.write(Paths.get("Data.csv"), personBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileDataCSV() {
		try {
			Files.lines(new File("Data.csv").toPath()).map(String::trim).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
}

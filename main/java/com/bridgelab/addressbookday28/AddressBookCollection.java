package com.bridgelab.addressbookday28;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookCollection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		int choice;
		int count;
		String city, state;
		AddressBookMethods detail = new AddressBookMethods();
		do {
			System.out.println("Enter the choice : ");
			System.out.println("1.Add contact ");
			System.out.println("2.Display contact");
			System.out.println("3.Edit contact");
			System.out.println("4.Delete contact");
			System.out.println("5.Search By State name");
			System.out.println("6.Search By City name");
			System.out.println("7.View By State name");
			System.out.println("8.View By City name");
			System.out.println("9.Count person By City");
			System.out.println("10.Count person By City");
			System.out.println("11.Sort By First Name");
			System.out.println("12.Sort By City");
			System.out.println("13.Sort By State");
			System.out.println("14.Sort By ZipCode");
			System.out.println("15.Write data to file");
			System.out.println("16.Read data from file");
			System.out.println("17.Write data to csv file");
			System.out.println("18.Read data from csv file");
			System.out.println("19.Write data to csv file");
			System.out.println("20.Read data from csv file");
			
			ch= sc.nextInt();
			switch(ch) {
			case 1: 
				detail.readData();
				break;
			case 2:
				detail.DisplayContacts();
				break;
			case 3:
				System.out.println("\nEnter First Name you want to edit:- ");
				String name = sc.next();
				detail.editData(name);;
				break;
			case 4:
				detail.deleteData();
				break;
			case 5:
				System.out.println("\nEnter the state name to display details :- ");
				state = sc.next();
				detail.searchPersonByState(state);
				break;
			case 6:
				System.out.println("\nEnter the city name to display details :- ");
				city = sc.next();
				detail.searchPersonByCity(city);
				break;
			case 7:
				System.out.println("\nEnter the state name :- ");
				state = sc.next();
				detail.viewPersonByState(state);;
				break;
			case 8:
				System.out.println("\nEnter the city name :- ");
				city = sc.next();
				detail.viewPersonByCity(city);;
				break;
			case 9:
				System.out.println("\nEnter the city name to find person in city :- ");
				city = sc.next();
				count = detail.countPersonsByCity(city);
				System.out.println("Number of persons by city "+city+" is "+count);
				break;
			case 10:
				System.out.println("\nEnter the state name to find person in state  :- ");
				state = sc.next();
				count = detail.countPersonsByState(state);
				System.out.println("Number of persons by state "+state+" is "+count);
				break;
			case 11:
				detail.sortByFirstName();
				break;
			case 12:
				detail.sortByCity();
				break;
			case 13:
				detail.sortByState();
				break;
			case 14:
				detail.sortByZipCode();
				break;
			case 15:
				detail.writeData();;
				break;
			case 16:
				detail.readFileData();;
				break;
			case 17:
				detail.writeDataCSV();
				break;
			case 18:
				detail.readFileDataCSV();
				break;
			case 19:
				try {
					detail.writeDataInJSon();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 20:
				try {
					detail.readDataFromJson();
				} catch (IOException e) {
					e.printStackTrace();
				};
				break;
			
			}System.out.println("Do you want to continue? if yes press 1");
			choice = sc.nextInt();
		}while(choice == 1);
		sc.close();
	}


}

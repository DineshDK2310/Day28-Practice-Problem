package com.bridgelab.addressbookday28;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookConnection {
	
	public Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	private PreparedStatement addressBookDataStatement;
	private static AddressBookConnection addressBookConnection;

	public AddressBookConnection() {
	}

	public static AddressBookConnection getInstance() {
		if (addressBookConnection == null) {
			addressBookConnection = new AddressBookConnection();
		}
		return addressBookConnection;
	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/addressbook_services?useSSL=false";
		String userName="root";
		String password="Rash@123";
//		Connection connection;
		connection = DriverManager.getConnection(dbURL,userName,password);
		System.out.println(connection + "Database connection is successfull");
		return connection;
	}

//	public static void main(String[] args) throws SQLException {
//		AddressBookConnection a =new AddressBookConnection();
//		a.getConnection();
//	}
	
	public List<AddressBookData> readDate() {
		String query = "SELECT * from address_book";
		return this.getAddressBookDataUsingDB(query);
	}

	private List<AddressBookData> getAddressBookDataUsingDB(String query) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			addressBookList = this.getAddressBookData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

	private List<AddressBookData> getAddressBookData(ResultSet resultSet) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String typeId = resultSet.getString("type");
				String firstName = resultSet.getString("fname");
				String lastName = resultSet.getString("lname");
				String address = resultSet.getString("address");
				String phoneNumber = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");
				addressBookList.add(new AddressBookData(typeId, firstName, lastName, address, phoneNumber, email, city, state, zip));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}
	
	private void prepareStatementForAddressBook() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM  address_book WHERE `fname` = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<AddressBookData> getAddressBookData(String firstName) {
        List<AddressBookData> addressBookDataList = null;
        if (this.addressBookDataStatement == null) {
            this.prepareStatementForAddressBook();
        }
        try {
            addressBookDataStatement.setString(1, firstName);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            addressBookDataList =this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookDataList;
    }

    public int updateAddressBookRecord(String name, String phoneNumber) throws AddressBookException {
        String query = String.format("update  address_book set phone = '%s' where fname= '%s' ;", phoneNumber, name);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
        }
    }
    
    public List<AddressBookData> getAddressBookForDateRange(LocalDate startDate, LocalDate endDate) {
        String query = String.format("SELECT * FROM address_book WHERE date_added BETWEEN '%s' AND '%s';",
                Date.valueOf(startDate), Date.valueOf(endDate));
        return this.getAddressBookDataUsingDB(query);
    }
}

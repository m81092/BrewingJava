package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.UserDetails;
import org.brewingjava.model.UserInfo;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class AccountInfoDAOImpl implements AccountInfoDAO {

	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	private DBConnection dbConnection;

	public AccountInfoDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public boolean createAccount(UserDetails userDetails) {

		boolean hasError = true;
		try {
			String QueryAccountId = "SAVE_ACCOUNT";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryAccountId);
			// Formating the query with the data to be saved
			String newquery = String.format(query, userDetails.accountInfo.getUsername(), userDetails.accountInfo.getPassword());
			Statement stmt = connection.createStatement();
			// Returns 1 if data is inserted
			int temp = stmt.executeUpdate(newquery);
			if (temp == 1)
				hasError = false;
			else
				hasError = true;
		} catch (Exception e) {
			System.out.println("Some Error occurred while saving user credentials");
			//e.printStackTrace();
			hasError = true;
		}
		
		try {
			String QueryUserInfoId = "SAVE_USER_INFO";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryUserInfoId);
			// Formating the query with the data to be saved
			String newquery = String.format(query, userDetails.userInfo.getFname(), userDetails.userInfo.getLname(),
					userDetails.userInfo.getUserName(), userDetails.userInfo.getShipping(), userDetails.userInfo.getBilling());
			Statement stmt = connection.createStatement();
			// Returns 1 if data is inserted
			int temp = stmt.executeUpdate(newquery);
			if (temp == 1)
				hasError = false;
			else
				hasError = true;
		} catch (Exception e) {
			System.out.println("Some Error occurred while saving user info");
			e.printStackTrace();
			hasError = true;
		}
		return (!hasError) ? true : false;
	}
	
	public UserDetails getAccount(String username, String password) {
		UserDetails usereDetails;
		UserInfo userInfo = new UserInfo();
		AccountInfo accountInfo = new AccountInfo();
		try {
			String QueryId = "LOGIN";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			// Formating the query with the data to be saved
			String newquery = String.format(query, username);
			Statement stmt = connection.createStatement();
			// Fetching all the data for the user
			ResultSet rs = stmt.executeQuery(newquery);
			while (rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");
				accountInfo.setUsername(user);
				accountInfo.setPassword(pass);
			}
		} catch (Exception e) {
			System.out.println("Some Error occurred!");
			e.printStackTrace();
		}
		try {
			String QueryId = "USER_INFO";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			// Formating the query with the data to be saved
			String newquery = String.format(query, username);
			Statement stmt = connection.createStatement();
			// Fetching all the data for the user
			ResultSet rs = stmt.executeQuery(newquery);
			while (rs.next()) {
				userInfo.setFname(rs.getString("fname"));
				userInfo.setLname(rs.getString("lname"));
				userInfo.setShipping(rs.getString("shippingaddress"));
				userInfo.setBilling(rs.getString("billingaddress"));
			}
		} catch (Exception e) {
			System.out.println("Some Error occurred!");
			e.printStackTrace();
		}
		usereDetails = new UserDetails(accountInfo, userInfo);
		return usereDetails;
	}

}
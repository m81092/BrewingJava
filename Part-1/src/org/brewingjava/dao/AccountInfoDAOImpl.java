package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.Statement;

import org.brewingjava.model.AccountInfo;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class AccountInfoDAOImpl implements AccountInfoDAO {

	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	private DBConnection dbConnection;

	public AccountInfoDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public boolean createAccount(AccountInfo accountInfo) {

		boolean hasError = true;

		try {
			String QueryId = "SAVE_ACCOUNT";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			// Formating the query with the data to be saved
			String newquery = String.format(query, accountInfo.getUsername(), accountInfo.getPassword(),
					accountInfo.getBilling(), accountInfo.getShipping(), accountInfo.getSalt());
			Statement stmt = connection.createStatement();
			// Returns 1 if data is inserted
			int temp = stmt.executeUpdate(newquery);
			if (temp == 1)
				hasError = false;
			else
				hasError = true;
		} catch (Exception e) {
			System.out.println("Some Error occurred!");
			//e.printStackTrace();
			hasError = true;
		}
		return (!hasError) ? true : false;
	}

}

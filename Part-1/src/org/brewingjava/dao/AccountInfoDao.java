package org.brewingjava.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.brewingjava.model.Books;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class AccountInfoDao {
	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	private DBConnection dbConnection;
	PreparedStatement pstmtSearchLogin = null;

	
	public AccountInfoDao() {
		dbConnection = DBConnection.getInstance();
	}
	
	public boolean validateLogin(String username, String password) throws FileNotFoundException, IOException {
		
			ResultSet rs = null;
			try {
				String QueryId = "LOGIN_CREDENTIALS";
				Connection connection = dbConnection.getDataSource().getConnection();
				String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				pstmtSearchLogin = connection.prepareStatement(query);
				pstmtSearchLogin.setString(1, username);
				pstmtSearchLogin.setString(2, password);
				rs = pstmtSearchLogin.executeQuery();
				return rs.next(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
}

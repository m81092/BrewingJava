package org.brewingjava.dao;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PasswordEncryptionService;
import org.brewingjava.util.PropertyReaderUtil;

public class AccountInfoDAOImpl implements AccountInfoDAO {
	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	private DBConnection dbConnection;
	PreparedStatement pstmtSearchLogin = null;

	
	public AccountInfoDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}
	
	public boolean validateLogin(String username, String password) {
		PasswordEncryptionService service = new PasswordEncryptionService();
		try {
		
		ResultSet rs = null;
		try {
			String QueryId = "LOGIN_CREDENTIALS";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			pstmtSearchLogin = connection.prepareStatement(query);
			pstmtSearchLogin.setString(1, username);
			// pstmtSearchLogin.setString(2, encryptedPassword);
			rs = pstmtSearchLogin.executeQuery();
			while (rs.next())
			{
				return service.validatePassword(password, rs.getString("password").getBytes(), service.getSaltValue());
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return false;
	}
}

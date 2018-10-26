package org.brewingjava.dao;


import org.brewingjava.model.UserDetails;

public interface AccountInfoDAO {

	public boolean createAccount(UserDetails userDetails);
	public UserDetails getAccount(String username, String password);
}

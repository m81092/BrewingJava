package org.brewingjava.service;

import org.brewingjava.model.UserDetails;

public interface OrderService {

	public boolean createAccount(UserDetails userDetails);
	public UserDetails getAccount(String username, String password);
	
}

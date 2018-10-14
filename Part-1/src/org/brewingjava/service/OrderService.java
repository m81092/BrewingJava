package org.brewingjava.service;

import org.brewingjava.model.AccountInfo;

public interface OrderService {

	public boolean createAccount(AccountInfo accountInfo);
	public AccountInfo getAccount(String username, String password);
	
}

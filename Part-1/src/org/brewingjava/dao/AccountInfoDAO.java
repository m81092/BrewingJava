package org.brewingjava.dao;

import org.brewingjava.model.AccountInfo;

public interface AccountInfoDAO {

	public boolean createAccount(AccountInfo accountInfo);
	public AccountInfo getAccount(String username, String password);
}

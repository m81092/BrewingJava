package org.brewingjava.service;

import java.util.Arrays;

import org.brewingjava.dao.AccountInfoDAO;
import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.model.AccountInfo;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean createAccount(AccountInfo accountInfo) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		return dao.createAccount(accountInfo);
	}

	@Override
	public AccountInfo getAccount(String username, String password) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		AccountInfo accountInfo = new AccountInfo();
		accountInfo = dao.getAccount(username, password);
		if (username.equals(accountInfo.getUsername()) && password.equals(accountInfo.getPassword())) {
			return accountInfo;
		} else {
			return null;
		}
	}
}

package org.brewingjava.service;

import org.brewingjava.dao.AccountInfoDAO;
import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.model.UserDetails;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean createAccount(UserDetails userDetails) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		return dao.createAccount(userDetails);
	}

	@Override
	public UserDetails getAccount(String username, String password) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails = dao.getAccount(username, password);
		if (username.equals(userDetails.accountInfo.getUsername()) && password.equals(userDetails.accountInfo.getPassword())) {
			return userDetails;
		} else {
			return null;
		}
	}
}

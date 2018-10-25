<<<<<<< HEAD
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
=======
package org.brewingjava.service;


import org.brewingjava.dao.AccountInfoDAO;
import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.dao.OrderDAO;
import org.brewingjava.dao.OrderDAOImpl;
import org.brewingjava.model.PO;
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

	@Override
	public int createOrder(PO purchaseOrder) {
		OrderDAO dao = new OrderDAOImpl();
		return dao.createOrder(purchaseOrder);
	}
	
	@Override
	public String confirmOrder(int id, boolean payement) {
		if(id%5==0) {
			payement = false;
		}
		OrderDAO dao = new OrderDAOImpl();
		boolean result = dao.confirmOrder(id, payement);
		String resultingStmt;
		if(result)
			resultingStmt = "Your Order is Confirmed";
		else
			resultingStmt = "Your Order is Denied";
		return resultingStmt;
	}
}
>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git

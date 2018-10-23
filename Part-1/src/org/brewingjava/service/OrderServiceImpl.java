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

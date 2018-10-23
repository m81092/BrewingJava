package org.brewingjava.service;

import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;

public interface OrderService {

	public boolean createAccount(UserDetails userDetail);
	public UserDetails getAccount(String username, String password);
	public int createOrder(PO purchaseOrder);
	public String confirmOrder(int id, boolean payement);
	
}

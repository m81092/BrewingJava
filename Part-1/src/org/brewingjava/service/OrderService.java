<<<<<<< HEAD
package org.brewingjava.service;

import org.brewingjava.model.AccountInfo;

public interface OrderService {

	public boolean createAccount(AccountInfo accountInfo);
	public AccountInfo getAccount(String username, String password);
	
}
=======
package org.brewingjava.service;

import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;

public interface OrderService {

	public boolean createAccount(UserDetails userDetail);
	public UserDetails getAccount(String username, String password);
	public int createOrder(PO purchaseOrder);
	public String confirmOrder(int id, boolean payement);
	
}
>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git

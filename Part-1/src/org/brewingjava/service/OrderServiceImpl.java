package org.brewingjava.service;

import org.brewingjava.dao.AccountInfoDAO;
import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.model.AccountInfo;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean createAccount(AccountInfo accountInfo) {
		
		AccountInfoDAO dao = new AccountInfoDAOImpl();
		return dao.createAccount(accountInfo);
	}

}

<<<<<<< HEAD
package org.brewingjava.dao;

import org.brewingjava.model.AccountInfo;

public interface AccountInfoDAO {

	public boolean createAccount(AccountInfo accountInfo);
	public AccountInfo getAccount(String username, String password);
}
=======
package org.brewingjava.dao;


import org.brewingjava.model.UserDetails;

public interface AccountInfoDAO {

	public boolean createAccount(UserDetails userDetails);
	public UserDetails getAccount(String username, String password);
}
>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git

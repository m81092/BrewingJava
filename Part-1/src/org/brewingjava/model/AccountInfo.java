<<<<<<< HEAD
package org.brewingjava.model;

public class AccountInfo {

	private String username;
	private String password;
	private String billing;
	private String shipping;

	public AccountInfo(String username, String password, String billing, String shipping, byte[] salt) {
		this.username = username;
		this.password = password;
		this.billing = billing;
		this.shipping = shipping;
	}

	public AccountInfo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

}
=======
package org.brewingjava.model;

public class AccountInfo {

	private String username;
	private String password;
	

	public AccountInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AccountInfo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git

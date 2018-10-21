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

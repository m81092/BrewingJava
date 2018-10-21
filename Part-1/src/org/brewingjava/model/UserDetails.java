package org.brewingjava.model;

public class UserDetails {
	public AccountInfo accountInfo;
	public UserInfo userInfo;
	
	public UserDetails() {
	}
	
	public UserDetails(AccountInfo accountInfo, UserInfo userInfo) {
		this.accountInfo = accountInfo;
		this.userInfo = userInfo;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}	
}
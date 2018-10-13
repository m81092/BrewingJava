package org.brewingjava.model;

public class AccountInfo {

	private String username;
	private String password;
	private String billingAddress;
	private String shippingAddress;
	
	public AccountInfo(String username, String password, String billingAddress, String shippingAddress) {
		super();
		this.username = username;
		this.password = password;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
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
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
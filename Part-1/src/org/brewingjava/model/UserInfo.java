package org.brewingjava.model;

public class UserInfo {
	private String fname;
	private String lname;
	private String userName;
	private String billing;
	private String shipping;
	
	public UserInfo() {
	}
	
	public UserInfo(String fname, String lname, String userName, String billing, String shipping) {
		this.fname = fname;
		this.lname = lname;
		this.userName = userName;
		this.billing = billing;
		this.shipping = shipping;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

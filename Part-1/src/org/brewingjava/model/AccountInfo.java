package org.brewingjava.model; 
 
public class AccountInfo { 
 
	private String username; 
	private byte[] password; 
	private String billing; 
	private String shipping; 
	private byte[] salt; 
 
	public AccountInfo() { 
	} 
 
	public String getUsername() { 
		return username; 
	} 
 
	public void setUsername(String username) { 
		this.username = username; 
	} 
 
	public byte[] getPassword() { 
		return password; 
	} 
 
	public void setPassword(byte[] password) { 
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
 
	public byte[] getSalt() { 
		return salt; 
	} 
 
	public void setSalt(byte[] salt) { 
		this.salt = salt; 
	} 
 
} 

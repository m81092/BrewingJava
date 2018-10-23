package org.brewingjava.model;

import java.util.ArrayList;
import java.util.List;

public class PO {

	String username;
	List<Books> cartInfo = new ArrayList<Books>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Books> getCartInfo() {
		return cartInfo;
	}
	public void setCartInfo(List<Books> cartInfo) {
		this.cartInfo = cartInfo;
	}
	
	
}

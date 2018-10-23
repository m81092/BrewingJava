package org.brewingjava.dao;

import org.brewingjava.model.PO;

public interface OrderDAO {

	public int createOrder(PO orderDetails);
	public boolean confirmOrder(int id, boolean payement);
	
}

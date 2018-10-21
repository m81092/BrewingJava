package org.brewingjava.dao;

public interface OrderDAO {

	public boolean confirmOrder(int id, String username, boolean payement);
}

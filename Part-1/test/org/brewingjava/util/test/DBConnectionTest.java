package org.brewingjava.util.test;

import static org.junit.Assert.*;

import org.brewingjava.util.DBConnection;
import org.brewingjava.util.DBConnectionProps;
import org.junit.Test;

public class DBConnectionTest {
	private DBConnection connection;
	
	@Test
	public void getInstanceTest() {
		assertNotNull(DBConnection.getInstance());
	}

	@Test
	public void setUpPoolTest() throws Exception {
		connection = new DBConnection(new DBConnectionProps());
		assertNotNull(connection.setUpPool());
	}
}

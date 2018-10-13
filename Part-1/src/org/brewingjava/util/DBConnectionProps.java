package org.brewingjava.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DBConnectionProps {

	private static final String DB_PROERTIES_FILE = "db.properties";

	private static final String DB_DRIVER_NAME = "JDBC_DRIVER";

	private static final String DB_DRIVER_URL = "JDBC_DB_URL";

	private static final String DB_USERNAME = "JDBC_USER";

	private static final String DB_PASSWORD = "JDBC_PASS";

	private String driver;

	private String url;

	private String username;

	private String password;

	public DBConnectionProps() {

		readProperties();

	}

	private void readProperties() {

		try {

			driver = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_DRIVER_NAME);

			url = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_DRIVER_URL);

			username = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_USERNAME);

			password = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_PASSWORD);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public String getDriver() {

		return driver;

	}

	public void setDriver(String driver) {

		this.driver = driver;

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

	public String getUrl() {

		return url;

	}

	public void setUrl(String url) {

		this.url = url;

	}

}
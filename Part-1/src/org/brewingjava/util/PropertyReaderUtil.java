<<<<<<< HEAD
package org.brewingjava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtil {

	private static boolean debugOnOff = false;

	private static PropertyReaderUtil instance;

	private PropertyReaderUtil() {
	}

	public static PropertyReaderUtil getInstance() {

		if (instance == null)

			instance = new PropertyReaderUtil();

		return instance;

	}

	public String getPropertyValue(String propertiesFile, String propertyKey)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();

		String value = "";
		String path = "";
		// check file exists
		// make changes in your system with your own path
		if (propertiesFile == "db.properties") {
			path = "C:\\Users\\Admin\\Downloads\\eclipse\\workspace\\BrewingJava-Mudit\\Part-1\\WebContent\\resources\\db.properties";
		} else if (propertiesFile == "queries.properties") {
			path = "C:\\Users\\Admin\\Downloads\\eclipse\\workspace\\BrewingJava-Mudit\\Part-1\\WebContent\\resources\\queries.properties";
		}

		System.out.println("file is here" + new File(".").getAbsoluteFile());
		try (FileInputStream fis = new FileInputStream(path)) {

			try {
				System.out.println("got the file");
				prop.load(fis);

				value = prop.getProperty(propertyKey);

				debugOnOff = Boolean.valueOf(prop.getProperty("DEBUG"));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		// debug works as logger so use it to save your time
		// Make an entry in DB.properties file for debug
		if (debugOnOff) {

			System.out.println(String.format("Key : %s ; Value : %s", propertyKey, value));

		}

		return value;

	}

=======
package org.brewingjava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtil {

	private static boolean debugOnOff = false;

	private static PropertyReaderUtil instance;

	private PropertyReaderUtil() {
	}

	public static PropertyReaderUtil getInstance() {

		if (instance == null)

			instance = new PropertyReaderUtil();

		return instance;

	}

	public String getPropertyValue(String propertiesFile, String propertyKey)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();

		String value = "";
		String path = "";
		// check file exists
		//make changes in your system with your own path
		if (propertiesFile == "db.properties") {
			path = "C:\\Users\\Hp\\git\\BrewingJava\\Part-1\\WebContent\\resources\\db.properties";
		} else if (propertiesFile == "queries.properties") {
			path = "C:\\Users\\Hp\\git\\BrewingJava\\Part-1\\WebContent\\resources\\queries.properties";
		}

		System.out.println("file is here" + new File(".").getAbsoluteFile());
		try (FileInputStream fis = new FileInputStream(path)) {

			try {
				System.out.println("got the file");
				prop.load(fis);

				value = prop.getProperty(propertyKey);

				debugOnOff = Boolean.valueOf(prop.getProperty("DEBUG"));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		//debug works as logger so use it to save your time
		//Make an entry in DB.properties file for debug
		if (debugOnOff) {

			System.out.println(String.format("Key : %s ; Value : %s", propertyKey, value));

		}

		return value;

	}

>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git
}
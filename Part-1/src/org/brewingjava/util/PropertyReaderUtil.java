package org.brewingjava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtil {

    

    private static boolean debugOnOff = false;

    private static PropertyReaderUtil instance;

   

    private PropertyReaderUtil() {}

   

    public static PropertyReaderUtil getInstance() {

           if (instance == null)

                  instance = new PropertyReaderUtil();

           return instance;

    }

   

    public String getPropertyValue(String propertiesFile, String propertyKey) throws FileNotFoundException, IOException {

           Properties prop = new Properties();

           String value = "";
           //check file exists

           System.out.println("file is here"+new File(".").getAbsoluteFile());
           try (FileInputStream fis = new FileInputStream("E:\\softwares\\eclipse-jee-photon-R-win32-x86_64\\eclipse\\db.properties")) {

                  try {
System.out.println("got the file");
                        prop.load(fis);

                        value = prop.getProperty(propertyKey);

                        debugOnOff = Boolean.valueOf(prop.getProperty("DEBUG"));

                  } catch (IOException e) {

                        e.printStackTrace();

                  }

           }

          

           if (debugOnOff) {

                  System.out.println(String.format("Key : %s ; Value : %s", propertyKey, value));

           }

          

           return value;

    }

}
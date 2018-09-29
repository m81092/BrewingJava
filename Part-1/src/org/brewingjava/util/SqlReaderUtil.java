package org.brewingjava.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Util class used to parse sql queries in XML file
 */
public class SqlReaderUtil {
	
	// TODO: Need to add relative file path
	private static final String XML_FILE_PATH = "C:/Users/VRUSHALI/git/BrewingJava/Part-1/WebContent/WEB-INF/bookstore-queries.xml";
	private static final String QUERY_TAG = "query";
	
	/**
	 * Parse sql queries in XML file and store it in array
	 * 
	 * @param context
	 * @param xml
	 * @param sqlArr
	 * @throws FileNotFoundException 
	 */
	public void parseXmlQueries(ServletContext context, String xml, String[] sqlArr) throws FileNotFoundException {
		InputStream inputStream  = new FileInputStream(XML_FILE_PATH);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder builder = new StringBuilder();
		String line;
		
		try {
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			
			xml = builder.toString();
			reader.close();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
							
			Element element = doc.getDocumentElement();
			NodeList nodeList = element.getChildNodes();
			
			int arrayIndex = 0;
			for (int index = 0; index < nodeList.getLength(); index++) {
				
				if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) nodeList.item(index);
					String sqlQuery = currentElement.getElementsByTagName(QUERY_TAG).item(0).getTextContent();
					sqlArr[arrayIndex] = sqlQuery.trim();
					arrayIndex++;
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}

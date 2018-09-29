package org.brewingjava.dao.categories;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.brewingjava.model.Categories;
import org.brewingjava.util.SqlReaderUtil;
import org.brewingjava.util.DBConnection;

public class CategoriesDAOImpl implements CategoriesDAO {
	@Context ServletContext context;
	// Array to store dynamic sql queries from XML
	static String[] sqlArr = new String[10];
	static String xml = null;
	SqlReaderUtil SqlReader = new SqlReaderUtil();
	
//	static String sql = "select bookid, title, price, author, category from book;";
//	static String username = "root", password = "admin", url = "jdbc:mysql://localhost/bookstore";

	ArrayList<Categories> cList = new ArrayList<>();
	
	private DBConnection dbConnection;
	public CategoriesDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public ArrayList<Categories> getCategories() {
		// Read sql queries from XML file
		try {
			SqlReader.parseXmlQueries(context, xml, sqlArr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			Connection connection = dbConnection.getDataSource().getConnection();
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(url, username, password);

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlArr[0]);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");

				Categories cat = new Categories(bookid, title, price, author, category);
				cList.add(cat);
			}
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		}
		return cList;
	}
}

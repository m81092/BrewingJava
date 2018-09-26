package org.brewingjava.dao.categories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Categories;

public class CategoriesDAOImpl implements CategoriesDAO {

	static String username = "root", password = "admin", url = "jdbc:mysql://localhost/part0";
	static String sql = "select bookid, title, price, author, category from book;";
	ArrayList<Categories> cList = new ArrayList<>();

	@Override
	public ArrayList<Categories> getCategories() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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

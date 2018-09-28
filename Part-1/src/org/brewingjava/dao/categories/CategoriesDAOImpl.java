package org.brewingjava.dao.categories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import org.brewingjava.model.Categories;
import org.brewingjava.util.DBConnection;

public class CategoriesDAOImpl implements CategoriesDAO {

	static String sql = "select bookid, title, price, author, category from book;";
	ArrayList<Categories> cList = new ArrayList<>();
	private DBConnection dbConnection;
	public CategoriesDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public ArrayList<Categories> getCategories() {
		try {
			Connection connection = dbConnection.getDataSource().getConnection();
			Statement stmt = connection.createStatement();
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

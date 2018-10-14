package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import org.brewingjava.model.Books;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class BookDAOImpl implements BookDAO {

	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	ArrayList<Books> cList = new ArrayList<>();
	private DBConnection dbConnection;
	public BookDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public ArrayList<Books> getAllBooks() {
		try {
			String QueryId = "ALL_BOOKS";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");

				Books cat = new Books(bookid, title, price, author, category);
				cList.add(cat);
			}
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public Books getBookInfo(String id) {
		Books book=new Books();
		try {
			String QueryId = "BOOK_INFO";
			Connection connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			query = String.format(query, id);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");
				book = new Books(bookid, title, price, author, category);
			}
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		}
		return book;
	}
	
}

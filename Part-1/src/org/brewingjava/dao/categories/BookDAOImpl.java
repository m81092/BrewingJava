package org.brewingjava.dao.categories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.brewingjava.model.Book;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class BookDAOImpl implements BookDAO {

	static String sql = "select * from book;";
	private static final String QUERY_PROERTIES_FILE = "query.properties";
	ArrayList<Book> cList = new ArrayList<>();
	private DBConnection dbConnection;
	private static final String QUERY_ID = "ALL_BOOKS";
	
	//Default constructor
	public BookDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public ArrayList<Book> selectAll() {
		
		String query = "";
		try {
			Connection connection = dbConnection.getDataSource().getConnection();
			query = PropertyReaderUtil.getInstance().getPropertyValue(QUERY_PROERTIES_FILE, QUERY_ID);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");

				Book book = new Book(bookid, title, price, author, category);
				cList.add(book);
			}
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		}
		return cList;
	}
}

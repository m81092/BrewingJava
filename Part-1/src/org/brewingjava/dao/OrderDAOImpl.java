package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.brewingjava.model.Books;
import org.brewingjava.model.PO;
import org.brewingjava.model.UserInfo;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

public class OrderDAOImpl implements OrderDAO {
	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	String QueryId = "";

	private DBConnection dbConnection;

	public OrderDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	@Override
	public int createOrder(PO orderDetails) {

		int purchaseOrderID = 0;
		Connection connection = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		HashMap<Integer, Float> bookMap = new HashMap<Integer, Float>();
		try {
			connection = dbConnection.getDataSource().getConnection();
			stmt = connection.createStatement();
			stmt1 = connection.createStatement();
			String userName = orderDetails.getUsername();
			UserInfo userDetails = getUserDetails(userName);
			String fname = userDetails.getFname();
			String lname = userDetails.getLname();
			String address = userDetails.getShipping();
			List<Books> cartDetails = orderDetails.getCartInfo();
			int bookId = 0;
			float price = 0;
			QueryId = "CREATE_ORDER_1";
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			query = String.format(query, lname, fname, address);
			System.out.println(query);
			int countRows = stmt.executeUpdate(query);
			System.out.println("first query result:" + countRows);
			if (countRows != 0) {

				for (Books book : cartDetails) {
					bookId = book.getBookid();
					price = book.getPrice();
					if(bookMap.containsKey(bookId)) {
						float tempPrice = bookMap.get(bookId)+price;
						bookMap.put(bookId, tempPrice);
					}
					else {
						bookMap.put(bookId, price);
					}
				}
				for(Map.Entry<Integer,Float> entry : bookMap.entrySet() ) {
					QueryId = "CREATE_ORDER_2";
					query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
					query = String.format(query, entry.getKey(), entry.getValue());
					stmt1.addBatch(query);
					query = "";
				}
				int count[] = stmt1.executeBatch();
				System.out.println(count);
				query = "SELECT LAST_INSERT_ID();";
				rs = stmt1.executeQuery(query);
				while (rs.next()) {
					purchaseOrderID = rs.getInt(1);
					System.out.println(purchaseOrderID);
				}
			} else {
				purchaseOrderID = 0;

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return purchaseOrderID;
	}
	

	@Override
	public boolean confirmOrder(int id, boolean payement) {
		Connection connection = null;
		Statement stmt = null;
		boolean result=false;
		try {
			String queryConfirm;
			if(payement)
				queryConfirm = "CONFIRM_ORDER";
			else
				queryConfirm = "DENY_ORDER";
			
			connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, queryConfirm);
			query = String.format(query, id,id);
			stmt = connection.createStatement();
			int rs = stmt.executeUpdate(query);
			if(rs==1)
				result = true;
			else {
				queryConfirm="DENIED_STATUS";
				query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, queryConfirm);
				query = String.format(query, id);
				stmt.executeUpdate(query);
			}
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		} finally {
			if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqle) {
						System.out.println(sqle);
						sqle.printStackTrace();
					}
				}

				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException sqle) {
						System.out.println(sqle);
						sqle.printStackTrace();
					}
				}
		}
		return result;
	}

	public UserInfo getUserDetails(String username) {
		UserInfo userDetails = new UserInfo();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			QueryId = "USER_DETAILS";
			connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			stmt = connection.createStatement();
			query = String.format(query, username);
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				userDetails.setFname(rs.getString("fname"));
				userDetails.setLname(rs.getString("lname"));
				userDetails.setShipping(rs.getString("shippingaddress"));
			}
			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return userDetails;
	}

}

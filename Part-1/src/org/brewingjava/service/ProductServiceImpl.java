package org.brewingjava.service;

import java.util.ArrayList;

import org.brewingjava.dao.BookDAO;
import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.model.Books;

public class ProductServiceImpl implements ProductService {

	public ArrayList<Books> getAllBooks() {

		ArrayList<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		bookList = dao.getAllBooks();

		return bookList;
	}
	
	public ArrayList<Books> getBookInfo(String id) {
		ArrayList<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		Books book = dao.getBookInfo(id);
		bookList.add(book);
		return bookList;
	}

}

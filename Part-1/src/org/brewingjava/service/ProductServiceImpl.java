package org.brewingjava.service;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.dao.BookDAO;
import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.model.Books;

public class ProductServiceImpl implements ProductService {

	@Override
	public ArrayList<Books> getAllBooks() {
		// TODO Auto-generated method stub
		ArrayList<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		bookList = dao.getAllBooks();

		return bookList;
	}

	@Override
	public List<Books> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		bookList = dao.getBooksByCategory(category);

		return bookList;
	}

	public ArrayList<Books> getBookInfo(int id) {
		ArrayList<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		Books book = dao.getBookInfo(id);
		bookList.add(book);
		return bookList;
	}
	


}

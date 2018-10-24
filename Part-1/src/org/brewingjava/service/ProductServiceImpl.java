package org.brewingjava.service;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import org.brewingjava.dao.BookDAO;
import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.dao.EventHandlerDAO;
import org.brewingjava.dao.EventHandlerDAOImpl;
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

	public ArrayList<Books> getBookInfo(int id, String event) {
		ArrayList<Books> bookList = new ArrayList<Books>();
		ArrayList<Books> bookEventList = new ArrayList<Books>();
		Books eventBook = new Books();
		eventBook.setBookid(id);
		bookEventList.add(eventBook);
		EventHandlerDAO eventDao = new EventHandlerDAOImpl();
		eventDao.createEvent(bookEventList, event);
		BookDAO dao = new BookDAOImpl();
		Books book = dao.getBookInfo(id);
		bookList.add(book);
		return bookList;
	}
}

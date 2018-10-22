package org.brewingjava.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.model.Books;
import org.junit.Assert;
import org.junit.Test;

public class BookDAOImplTest {
	private static final String BOOK_TITLE = "CLEAN CODE: A HANDBOOK OF AGILE SOFTWARE CRAFTSMANSHIP";
	private static final float BOOK_PRICE = 1599.0f;
	private static final String BOOK_CATEGORY = "Computers";
	private static final String BOOK_AUTHOR = "Robert C. Martin";
	private static final int BOOK_ID = 132350882;
	private BookDAOImpl dao;

	@Test
	public void getAllBooksTest() {
		dao = new BookDAOImpl();
		ArrayList<Books> list = dao.getAllBooks();
		assertNotNull(list);
		
		assertEquals(6, list.size());
		
		assertEquals(BOOK_ID, list.get(0).getBookid());
		assertEquals(BOOK_AUTHOR, list.get(0).getAuthor());
		assertEquals(BOOK_CATEGORY, list.get(0).getCategory());
		Assert.assertEquals(BOOK_PRICE, list.get(0).getPrice(), 0.0002);
		assertEquals(null, list.get(0).getStatus());
		assertEquals(BOOK_TITLE, list.get(0).getTitle());
	}
	
	@Test
	public void getBooksByCategoryTest() {
		dao = new BookDAOImpl();
		List<Books> list = dao.getBooksByCategory(BOOK_CATEGORY);
		assertNotNull(list);
		
		assertEquals(2, list.size());
		
		assertEquals(BOOK_ID, list.get(0).getBookid());
		assertEquals(BOOK_AUTHOR, list.get(0).getAuthor());
		assertEquals(BOOK_CATEGORY, list.get(0).getCategory());
		Assert.assertEquals(BOOK_PRICE, list.get(0).getPrice(), 0.0002);
		assertEquals(null, list.get(0).getStatus());
		assertEquals(BOOK_TITLE, list.get(0).getTitle());
	}
	
	@Test
	public void getBookInfoTest() {
		dao = new BookDAOImpl();
		Books book = dao.getBookInfo(BOOK_ID);
		assertNotNull(book);
		
		assertEquals(BOOK_ID, book.getBookid());
		assertEquals(BOOK_AUTHOR, book.getAuthor());
		assertEquals(BOOK_CATEGORY, book.getCategory());
		Assert.assertEquals(BOOK_PRICE, book.getPrice(), 0.0002);
		assertEquals(null, book.getStatus());
		assertEquals(BOOK_TITLE, book.getTitle());
	}
}

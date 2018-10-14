package org.brewingjava.dao;

import java.util.ArrayList;

import org.brewingjava.model.Books;

public abstract interface BookDAO {
	
	public ArrayList<Books> getAllBooks();
	public Books getBookInfo(int id);
}

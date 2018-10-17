package org.brewingjava.dao;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;

public abstract interface BookDAO {
	
	public ArrayList<Books> getAllBooks();
	public List<Books> getBooksByCategory(String category);
	public Books getBookInfo(int id);

}

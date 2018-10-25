package org.brewingjava.dao;

import java.util.ArrayList;
<<<<<<< HEAD

import org.brewingjava.model.Books;

public abstract interface BookDAO {
	
	public ArrayList<Books> getAllBooks();
	public Books getBookInfo(String id);
=======
import java.util.List;

import org.brewingjava.model.Books;

public abstract interface BookDAO {
	
	public ArrayList<Books> getAllBooks();
	public List<Books> getBooksByCategory(String category);
	public Books getBookInfo(int id);

>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git
}

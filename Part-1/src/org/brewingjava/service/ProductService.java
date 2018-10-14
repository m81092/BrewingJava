package org.brewingjava.service;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;

public interface ProductService {

	//All the methods are implemented in Class ProductServiceImpl**
	public ArrayList<Books> getAllBooks();
	public List<Books> getBooksByCategory(String category);
	public ArrayList<Books> getBookInfo(int id);

}

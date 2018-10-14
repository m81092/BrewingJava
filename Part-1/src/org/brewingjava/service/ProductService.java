package org.brewingjava.service;

import java.util.ArrayList;

import org.brewingjava.model.Books;

public interface ProductService {

	//All the methods are implemented in Class ProductServiceImpl**
	public ArrayList<Books> getAllBooks();
	public ArrayList<Books> getBookInfo(String id);
}

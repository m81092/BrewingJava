package org.brewingjava.dao.categories;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Book;

public interface BookDAO {
	
	public List<Book> selectAll();

}

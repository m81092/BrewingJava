package org.brewingjava.dao;

import java.util.ArrayList;

import org.brewingjava.model.Books;

public interface EventHandlerDAO {
	
	public boolean createEvent(ArrayList<Books> bookIdList, String eventType);

}

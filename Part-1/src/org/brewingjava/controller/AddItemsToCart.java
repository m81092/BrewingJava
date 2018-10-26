package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brewingjava.model.Books;

/**
 * Servlet implementation class AddItemsToCart
 */
@WebServlet("/AddItemsToCart")
public class AddItemsToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession mysession = request.getSession();
		String category = (String)mysession.getAttribute("category");
		//mysession.setAttribute("idList", idList);
		ArrayList idList = mysession.getAttribute("idList")!=null?(ArrayList) mysession.getAttribute("idList"):new ArrayList();
		System.out.println(category);
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		System.out.println("BookId: "+bookId);
		if(bookId != 0) {
			Books book = new Books();
			book.setBookid(bookId);
			idList.add(book);
			System.out.println(idList.size());
			String msg= "Book added successfully to cart";
			mysession.setAttribute("idList", idList);
			mysession.setAttribute("displayMsg", msg);
			response.sendRedirect("ShowBooks?category="+category);
			
		}
	}

}

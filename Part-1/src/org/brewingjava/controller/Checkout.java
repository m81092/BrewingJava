package org.brewingjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brewingjava.model.Books;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession mysession = request.getSession();
		List<Books> cartList = (List<Books>) mysession.getAttribute("CartList");
		float price;
		for (Books book : cartList) {
			price = book.getPrice();
			System.out.println("in checkout serv value of price before tax " + price);
			book.setPrice((price + (price * (float)0.13)));
			System.out.println("in checkout serv value of price after tax " + price);
		}
		// Setting the updated price in session
		mysession.setAttribute("CartList", cartList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Checkout.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

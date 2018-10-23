package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brewingjava.dao.categories.CategoriesDAOImpl;
import org.brewingjava.model.Categories;

/**
 * Servlet implementation class ShowDetails
 */
@WebServlet("/ShowCategories")
public class ShowCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CategoriesDAOImpl cdao = new CategoriesDAOImpl();
		ArrayList<Categories> categories = new ArrayList<>();
		categories = cdao.getCategories();
		System.out.println(categories);
		request.setAttribute("Categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

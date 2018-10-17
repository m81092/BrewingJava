package org.brewingjava.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class ShowDetails
 */
@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		HttpSession mysession = request.getSession();
		mysession.setAttribute("category", category);
		System.out.println(category);
		String baseURI = "http://localhost:8080/Part-1";
		Client client = ClientBuilder.newClient();
		WebTarget target = null;
		if (category.equals("All")) {
		 target = client.target(baseURI).path("/REST/WebService/AllBooks");
		}
		else {
		 target = client.target(baseURI).path("/REST/WebService/Categories").queryParam("category", category);
		}
		String result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		System.out.println(result);
		List<Books> allBooksList = new ArrayList<Books>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Books bookVo = new Books();
				bookVo.setAuthor(jsonObj.getString("author"));
				bookVo.setBookid(jsonObj.getInt("bookid"));
				bookVo.setCategory(jsonObj.getString("category"));
				bookVo.setPrice(jsonObj.getLong("price"));
				bookVo.setTitle(jsonObj.getString("title"));
				allBooksList.add(bookVo);
			}

			request.setAttribute("allBook", allBooksList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
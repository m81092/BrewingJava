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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.Books;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class BookInfo
 */
@WebServlet("/BookInfo")
public class BookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		System.out.println(bookId);
		String baseURI = "http://localhost:8080/Part-1";
		Client client = ClientBuilder.newClient();
		WebTarget target = null;
		if (bookId != 0) {

			target = client.target(baseURI).path("/REST/WebService/BookInfo").queryParam("bookId", bookId);
			String result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
			System.out.println(result);
			List<Books> allBooksinfo = new ArrayList<Books>();
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
					allBooksinfo.add(bookVo);
				}

				request.setAttribute("Bookdetails", allBooksinfo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("BookInfo.jsp");
				dispatcher.include(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

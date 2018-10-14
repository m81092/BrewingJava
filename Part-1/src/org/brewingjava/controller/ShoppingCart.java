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
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.Books;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baseURI = "http://localhost:8080/Part-1";
		Client client = ClientBuilder.newClient();
		HttpSession session = request.getSession();
		ArrayList idList = new ArrayList<>();
		idList.add(1627794247);
		if(session.getAttribute("idList")!=null) {
			idList = (ArrayList) session.getAttribute("idList");
			session.setAttribute("idList", "");
		}
		WebTarget target;
		String res2;
		List<Books> allBooksList = new ArrayList<Books>();
		try {
			for(int j=0;j<idList.size();j++) {
				target = client.target(baseURI).path("/REST/WebService/BookInfo").queryParam("bookId", idList.get(j));
				res2 = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
				JSONArray jsonArr = new JSONArray(res2);
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
			}
			List CartList =  session.getAttribute("CartList")!=null ? (ArrayList)session.getAttribute("CartList") : new ArrayList<>();
			for(Books book:allBooksList) {
				CartList.add(book);
			}
			session.setAttribute("CartList", CartList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}

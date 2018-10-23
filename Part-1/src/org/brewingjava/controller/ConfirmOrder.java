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

@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int poId = 0;
		String msg="";
		try {
			System.out.println("in ConfirmOrder servlet");
			poId = Integer.parseInt(request.getParameter("purchaseOrderID"));
			System.out.println(poId);
			String baseURI = "http://localhost:8080/Part-1";
			Client client = ClientBuilder.newClient();
			WebTarget target = null;
			if (poId != 0) {
				target = client.target(baseURI).path("/REST/WebService/confirmOrder").queryParam("POId", poId);
				msg = target.request(MediaType.TEXT_PLAIN).get().readEntity(String.class);
				System.out.println(msg);
			}
			else
				msg = "Error Processing your request!!!";
		} catch (NumberFormatException e) {
			if (poId == 0) {
				msg = "Error Processing your request!!!";
			}
		} 
			HttpSession mySession = request.getSession();
			mySession.removeAttribute("CartList");
			request.setAttribute("Message", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
			dispatcher.include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

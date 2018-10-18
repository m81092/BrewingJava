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

import org.brewingjava.model.AccountInfo;
import org.brewingjava.util.PasswordEncryptionService;
import org.json.JSONObject;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String epass = null;
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		try {
			epass = PasswordEncryptionService.generateSecurePassword(pass, PasswordEncryptionService.salt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		String baseURI = "http://localhost:8080/Part-1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(baseURI).path("/REST/WebService/login").queryParam("username", name)
				.queryParam("password", epass);
		String result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		System.out.println("in the login servlet and val of res2 is " + result);
		if (!result.equals("")) {
			List<AccountInfo> accountinfoList = new ArrayList<AccountInfo>();
			AccountInfo accountinfo = new AccountInfo();
			try {
				// Use JSON Object
				JSONObject jsonObj = new JSONObject(result);
				// Set values in account info object 
				accountinfo.setUsername(jsonObj.getString("username"));
				accountinfo.setBilling(jsonObj.getString("billing"));
				accountinfo.setShipping(jsonObj.getString("shipping"));
				accountinfoList.add(accountinfo);
				request.setAttribute("UserDetails", accountinfoList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Checkout.jsp");
				dispatcher.include(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				}
		} else {
			String error = "Invalid Username or Password!";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.include(request, response);
		}
	}
}

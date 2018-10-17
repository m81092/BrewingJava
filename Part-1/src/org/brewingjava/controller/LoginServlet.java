package org.brewingjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.brewingjava.util.PasswordEncryptionService;

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

		System.out.println("in the login serv and value of name string " + name);
		System.out.println("in the login serv and value of salt ");
		System.out.println("in the login serv and value of epass " + epass);
		String baseURI = "http://localhost:8080/Part-1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(baseURI).path("/REST/WebService/login").queryParam("username", name)
				.queryParam("password", epass);
		String res2 = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		System.out.println("in the login servlet and val of res2 is " + res2);
		if (!res2.equals("")) {
			request.setAttribute("userDetails", res2);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Checkout.jsp");
			dispatcher.include(request, response);
		} else {
			String error2 = "Invalid Username or Password!";
			request.setAttribute("error2", error2);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.include(request, response);

		}

	}

}

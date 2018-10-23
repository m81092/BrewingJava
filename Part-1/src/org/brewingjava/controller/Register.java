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

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.UserDetails;
import org.brewingjava.model.UserInfo;
import org.brewingjava.util.PasswordEncryptionService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String epass = null;
		String password = request.getParameter("password");
		if (!password.equals("")) {
			// Generating the salt and the encrypted password if password is not empty
			try {
				epass = PasswordEncryptionService.generateSecurePassword(password, PasswordEncryptionService.salt);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Set accountInfo values
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setUsername(request.getParameter("accountname"));
			accountInfo.setPassword(epass);
			
			// Set userInfo values
			UserInfo userInfo = new UserInfo();
			userInfo.setFname(request.getParameter("fname"));
			userInfo.setLname(request.getParameter("lname"));
			userInfo.setUserName(request.getParameter("accountname"));
			userInfo.setBilling(request.getParameter("billing"));
			userInfo.setShipping(request.getParameter("shipping"));

			// Create UserDetails class object
			UserDetails userDetails = new UserDetails(accountInfo, userInfo);
			
			String baseURI = "http://localhost:8080/Part-1";
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(baseURI).path("/REST/WebService/createUser");
			String res = target.request(MediaType.TEXT_PLAIN).put(Entity.json(userDetails), String.class);
			System.out.println(res);
			if (res.equals("true")) {

				request.setAttribute("accountname", request.getParameter("accountname"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.include(request, response);
			} else {

				String error = "This Account name already exists. Try another!";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
				dispatcher.include(request, response);
			}
		}
	}
}
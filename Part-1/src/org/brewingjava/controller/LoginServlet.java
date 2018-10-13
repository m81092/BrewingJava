package org.brewingjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brewingjava.dao.AccountInfoDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AccountInfoDao dao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		dao = new AccountInfoDao();
		
		boolean success = dao.validateLogin(name, pass);
		
		if(success) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Homepage.jsp");
			dispatcher.include(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Login Failed <br/>");
			out.println("<a href='login.jsp'>Click Here</a>");
			out.println("to login <br/>");
			out.println("</body>");
			out.println("</html>");
		}	
	}
}

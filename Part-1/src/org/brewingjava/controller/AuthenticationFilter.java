package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brewingjava.model.AccountInfo;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/Checkout")
public class AuthenticationFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession mySession = req.getSession();
		AccountInfo accountDetails = (AccountInfo) mySession.getAttribute("accountInfo");
		if (accountDetails != null) {
			ArrayList checkCartList = (ArrayList) mySession.getAttribute("CartList");
			if (checkCartList.size() != 0) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect("Welcome.jsp");
			}
		} else {
			resp.sendRedirect("Login.jsp");

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

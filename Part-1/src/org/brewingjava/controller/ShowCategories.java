package org.brewingjava.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
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
		/*CategoriesDAOImpl cdao = new CategoriesDAOImpl();
		ArrayList<Categories> categories = new ArrayList<>();
		categories = cdao.getCategories();
		System.out.println(categories);
		request.setAttribute("Categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
		dispatcher.forward(request, response);*/
		String BaseUrl = getpath(request);
		HttpsURLConnection con = null;
		BufferedReader reader=null;
		try {
			URL url = new URL(BaseUrl+"/Product");
			con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			if(con.getResponseCode()!=200) {
				 throw new RuntimeException("HTTP GET Request Failed with Error code : "
                         + con.getResponseCode());
			}
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String output ="Response: ", temp=null;
			while((temp=reader.readLine())!=null)
			{
				
				output+=temp;
			}
			System.out.println(output);
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(con!=null)
				con.disconnect();
			if(reader!=null) {
				reader.close();
			}
		}
		
		System.out.println(request.getServletPath()+"\n"+ request.getServletContext().getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String getpath(HttpServletRequest request) {
		String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	}

}

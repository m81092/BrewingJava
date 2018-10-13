package org.brewingjava.webservice;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.brewingjava.model.Books;
import org.brewingjava.service.ProductService;
import org.brewingjava.service.ProductServiceImpl;

@Path("/WebService")
public class ProductCatalogueService {
	@GET
	@Path("/Categories")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Books> getAllCategories(@QueryParam("category") String category) {
		System.out.println("in side ");
		System.out.println(category);
		ProductService ps = new ProductServiceImpl();
		return ps.getAllBooks();
	}
	
	@GET
	@Path("/BookInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Books getBookInfo(@QueryParam("id") String id) {
		System.out.println("Service: Fetching Book Info");
		System.out.println(id);
		ProductService ps = new ProductServiceImpl();
		return ps.getBookInfo(id);		//We have to handle the null value if book is not their.
	}

//Another way to hit WebService through POST method (Keep it in code)
	/*
	 * @POST
	 * 
	 * @Path("/Categories")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getAllCategories(@QueryParam("category") String category) {
	 * System.out.println("in side "); System.out.println(category);
	 * 
	 * return Response.status(200).entity(getAllCategoriesList(category)).build(); }
	 */

}

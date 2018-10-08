package org.brewingjava.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.brewingjava.dao.categories.CategoriesDAOImpl;
import org.brewingjava.model.Categories;

@Path("/Product")
public class ProductCatalog {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchCategories() {
		CategoriesDAOImpl cdao = new CategoriesDAOImpl();
		ArrayList<Categories> categories = new ArrayList<>();
		categories = cdao.getCategories();
		System.out.println(categories);
		return Response.status(200).entity(categories).build();
	}
	
}

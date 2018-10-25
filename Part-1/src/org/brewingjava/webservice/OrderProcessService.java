<<<<<<< HEAD
package org.brewingjava.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.Books;
import org.brewingjava.service.OrderService;
import org.brewingjava.service.OrderServiceImpl;
import org.brewingjava.service.ProductService;
import org.brewingjava.service.ProductServiceImpl;

@Path("/WebService")
public class OrderProcessService {

	@PUT
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean createAccount(AccountInfo accountInfo) {
		
		OrderService os = new OrderServiceImpl();
		return os.createAccount(accountInfo);
	}
	
	@GET
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public AccountInfo getAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		
		//System.out.println("in OP WS and the val of password is " +password);
		OrderService os = new OrderServiceImpl();
		return (os.getAccount(username, password) != null) ? os.getAccount(username, password) : null;
	}
}
=======
package org.brewingjava.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;
import org.brewingjava.service.OrderService;
import org.brewingjava.service.OrderServiceImpl;

@Path("/WebService")
public class OrderProcessService {

	@PUT
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean createAccount(UserDetails userDetails) {
		
		OrderService os = new OrderServiceImpl();
		return os.createAccount(userDetails);
	}
	
	@GET
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		
		//System.out.println("in OP WS and the val of password is " +password);
		OrderService os = new OrderServiceImpl();
		return (os.getAccount(username, password) != null) ? os.getAccount(username, password) : null;
	}
	
	@PUT
	@Path("/createOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int createOrder(PO purchaseOrder) {
		
		OrderService os = new OrderServiceImpl();
		return os.createOrder(purchaseOrder);
	}
	
	@GET
	@Path("/confirmOrder")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String confirmOrder(@QueryParam("POId") int id) {
		System.out.println("Service: Confirming Order");
		System.out.println(id);
		OrderService os = new OrderServiceImpl();
		return os.confirmOrder(id, true);		//payement is passed as true. Set it as false in service if id is divisible by 5.
	}
	
}
>>>>>>> branch 'Mudit' of https://github.com/m81092/BrewingJava.git

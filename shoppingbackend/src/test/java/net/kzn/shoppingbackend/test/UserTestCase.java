package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user;
	
	private Cart cart;
	
	private Address address;

	@BeforeClass
	public static void init()
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("net.kzn.shoppingbackend");
	context.refresh();
	userDAO=(UserDAO) context.getBean("USERDAO1");
	}
	
	/*@Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("neeraj");
		user.setLastName("pal");
		user.setRole("USER");
		user.setEmail("neeraj@gmail.com");
		user.setContactNumber("123456789");
		user.setPassword("12345");
		
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		address=new Address();
		address.setAddressLineOne("Ram bigha");
		address.setAddressLineTwo("palamu");
		address.setCity("japla");
		address.setCountry("india");
		address.setState("jharkhand");
		address.setBilling(true);
		
		//link user with address using user id
	    address.setUserId(user.getId1());
		
		assertEquals("failed to add address",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER"))
		{
			//ADD CART FOR THIS USER CUSTOMER
			cart=new Cart();
	     	cart.setUser(user);
			
			assertEquals("failed to add cart",true,userDAO.addCart(cart));

			
			//ADD SHIPPING ADDRESS FOR THIS USER
			
			address=new Address();
			address.setAddressLineOne("Vaisali");
			address.setAddressLineTwo("tangol");
			address.setCity("Hajipur");
			address.setCountry("india");
			address.setState("Bihar");
			//set shipping to true
			address.setShipping(true);
			//link it with the user
			address.setUserId(user.getId1());
			
			assertEquals("failed to add address",true,userDAO.addAddress(address));

			
			
		}
	}*/

	
		
  /* @Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("neeraj");
		user.setLastName("pal");
		user.setRole("USER");
		user.setEmail("neeraj@gmail.com");
		user.setContactNumber("123456789");
		user.setPassword("12345");

		if(user.getRole().equals("USER"))
		{
			//ADD CART FOR THIS USER CUSTOMER
			cart=new Cart();
	     	cart.setUser(user);
	     	//attach cart with user
	     	user.setCart(cart);
			
		}
		assertEquals("failed to add user",true,userDAO.addUser(user));

		
	}*/
	
	
     @Test
     public void testupdateCart()
     {
    	 //get user
    	 user=userDAO.getByEmail("neeraj@gmail.com");
    	
    	 //get the use cart
    	 cart=user.getCart();
    	 
    	 cart.setCartLines(5);
    	cart.setGrandTotal(50001);
    	 
    	 assertEquals("failed to update cart",true, userDAO.updateCart(cart));
    	  
     }
}
	





















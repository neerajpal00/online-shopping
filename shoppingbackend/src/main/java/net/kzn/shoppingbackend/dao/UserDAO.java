package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	//add a cart
	boolean updateCart(Cart cart);
	
	Address getBillingAddress(User user);
	
	List<Address> getShippingAddress(User user);
	

}

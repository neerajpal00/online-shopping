package net.kzn.omlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.kzn.omlineshopping.model.RegisterModel;
import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	// example for composite model and Handler
	
	
	@Autowired
	UserDAO USERDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);

	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);

	}
	
	
	public String validateUser(User user, MessageContext error)
	{
		String transitionValue="success";
				
		//checking password and reenter password matching
				if(!(user.getPassword().equals(user.getRepassword())))
				{
					error.addMessage(new MessageBuilder()
							.error()
							.source("repassword")
							.defaultText("password does not match")
							.build()
							);
					transitionValue="failure";
				}
					
		//checking the uniqueness of email u can not enter duplicate email
				
				if(USERDAO.getByEmail(user.getEmail()) != null)
				{
					error.addMessage(new MessageBuilder()
							.error()
							.source("email")
							.defaultText("email already exists")
							.build()
							);
					
					
					transitionValue="failure";

				}
				
				
				return transitionValue;
	}
	
	
	
	
	
	
	
	
	public String saveAll(RegisterModel registerModel) {
		 String transitionValue="success";
		 
		 //for save user detail and address in data base
		 //first fetch the user
		User user=registerModel.getUser();
		if(user.getRole().equals("USER"))
		{
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
		}
		 //second save user in database
		USERDAO.addUser(user);
		
		
		//FIRST FETCH THE ADDRESS
		
		Address address=registerModel.getBilling();
		address.setUser(user);;
		address.setBilling(true);
		
		USERDAO.addAddress(address);
		
		 
		 
		 return transitionValue;

	}

}

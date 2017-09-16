package net.kzn.omlineshopping.handler;

import org.springframework.stereotype.Component;

import net.kzn.omlineshopping.model.RegisterModel;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	// example for composite model and Handler

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);

	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);

	}
	
	
	public String saveAll(RegisterModel registerModel) {
		 String transitionValue="success";
		 
		 
		 
		 return transitionValue;

	}

}

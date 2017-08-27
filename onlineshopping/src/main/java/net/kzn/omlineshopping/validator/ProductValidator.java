package net.kzn.omlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.kzn.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clas) {
		// support only for Product class
		return Product.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors error) {

		Product product = (Product)target;
		
		//check whether file has been selected or not
		
		if(product.getFile1()==null || product.getFile1().getOriginalFilename().equals(""))
		{
			
			error.rejectValue("file1", null, "Please select an image file to upload");
			return;
		}
		
		//use for validate use only .png, .jpeg and .gif image content type  (image/.gif) 
		
		if(!(
				product.getFile1().getContentType().equals("image/jpeg") ||
				product.getFile1().getContentType().equals("image/gif")  ||
				product.getFile1().getContentType().equals("image/png")  
			  )) 
		{
			error.rejectValue("file1", null, "Please use only image file to upload");

			return;
			
		}
		
		
	}

}

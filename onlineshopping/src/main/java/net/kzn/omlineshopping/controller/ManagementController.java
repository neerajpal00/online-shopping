package net.kzn.omlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.omlineshopping.util.FileUploadUtility;
import net.kzn.omlineshopping.validator.ProductValidator;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false) String operation1) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts", true);

		Product nproduct = new Product();

		// set by default
		nproduct.setActive(true);
		nproduct.setSupplierId(1);

		mv.addObject("product11", nproduct);
		
		
		if(operation1!=null)
		{
			if(operation1.equals("product"))
			{
				mv.addObject("message", "Product Added Successfully");
			}
		}

		return mv;

	}
	
	
	//HANDDE PRODUCT SUBMISSION
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product11") Product mProduct,BindingResult results,Model model,HttpServletRequest request)
	{
		
		// custom ProductValidation added here for image file call validate method
		
		ProductValidator productValidator=new ProductValidator();
	//	productValidator.validate(target, error);
		productValidator.validate(mProduct, results);
		
		
		
		
		//check if has any error
		
		if(results.hasErrors())
		{
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			
			model.addAttribute("message", "Validation failed due to Product Submission");

			return "page";
		}
		
		logger.info(mProduct.toString());
		
		//create a new Product record
		productDAO.add(mProduct);
		
		//for multipart file upload
		if(!mProduct.getFile1().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mProduct.getFile1(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}

	
	//returning categories for all request
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	
}

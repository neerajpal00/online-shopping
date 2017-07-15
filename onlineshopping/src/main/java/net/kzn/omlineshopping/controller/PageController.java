package net.kzn.omlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.daoimpl.CategoryDAOImpl;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	 CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*
	 * * method to load all products from navbar
	 */
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	/*
	 * * url from sidebar
	 */
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to fetch single catogory
		Category category=null;
		
		category=categoryDAO.get(id);

		mv.addObject("title", category.getName());
		
		//passing list of categories
		
		mv.addObject("categories", categoryDAO.list());
		
		//passing single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	

}

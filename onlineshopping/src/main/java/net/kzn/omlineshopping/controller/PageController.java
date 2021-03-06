package net.kzn.omlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Home");
		logger.info("inside PageController - INFO");
		logger.debug("inside PageController-DEBUG");

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	/*
	 * * method to load all products from navbar
	 */

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	/*
	 * * url from sidebar
	 */
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch single catogory
		Category category = null;

		category = categoryDAO.get(id);
		
		if(category==null) throw new ProductNotFoundException();

		mv.addObject("title", category.getName());

		// passing list of categories

		mv.addObject("categories", categoryDAO.list());

		// passing single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();

		
		// -----------update the view Count-----------------
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		// ---------------------------------
		mv.addObject("title", product.getName());
		mv.addObject("product1", product);

		mv.addObject("userClickShowProduct", "true"); // use in master page
														// concept

		return mv;
	}

}

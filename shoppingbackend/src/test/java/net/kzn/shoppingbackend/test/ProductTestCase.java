package net.kzn.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init()
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("net.kzn.shoppingbackend");
	context.refresh();
	productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testAddProduct()
	{
		product=new Product();
		product.setId(6);
		product.setName("television");
		product.setDescription("description for television");
	//	product.setImageURL("cat_5.png");
		assertEquals("successfully added category",true,productDAO.add(product));
		
	}

}

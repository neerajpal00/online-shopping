package net.kzn.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("net.kzn.shoppingbackend");
	context.refresh();
	categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setId(6);
		category.setName("Laptop");
		category.setDescription("description for television");
		category.setImageURL("cat_3.png");
		assertEquals("successfully added category",true,categoryDAO.add(category));
		
	}

}

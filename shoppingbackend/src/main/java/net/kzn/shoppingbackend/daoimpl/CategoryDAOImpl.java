package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Override
	public List<Category> list() {
		
		
		List<Category> categories=new ArrayList<Category>();
		
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for televion");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		
	    category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
		// TODO Auto-generated method stub
		return categories;
	}

}

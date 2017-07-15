package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	
	@Autowired
	SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for televion");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		//return categories;
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();

	}

	@Override
	public Category get(int id) {
		
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);


		/*for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null; // if not match with id then return null
*/	
		}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

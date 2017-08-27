package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		// return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		String queryname = "from Category where active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("active", true);

		List<Category> list = query.list();

		return list;
	}

	@Override
	public Category get(int id) {

		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId1) {
		try {
			return  (Product) sessionFactory.getCurrentSession().get(Product.class, productId1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Product> list() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		return false;

	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		return false;

	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		return false;

	}

	@Override
	public List<Product> listActiveProducts() {
		String queryname = "from Product where active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("active", true);

		List<Product> list = query.list();

		return list;
	}

	@Override
	public List<Product> listActiveProductsByCategory(int category) {
		String queryname = "from Product where active=:active AND categoryId=:categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("active", true);
		query.setParameter("categoryId", category);

		List<Product> list = query.list();

		return list;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String queryname = "from Product where active=:active order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(count);

		List<Product> list = query.list();

		return list;
	}

}

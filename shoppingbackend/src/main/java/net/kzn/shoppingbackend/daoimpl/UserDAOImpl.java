package net.kzn.shoppingbackend.daoimpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.User;


@Repository("USERDAO1")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public boolean addUser(User user) {
			try {
				sessionFactory.getCurrentSession().save(user);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
			return false;

		}
	
	@Override
	public boolean addAddress(Address address) {
			try {
				sessionFactory.getCurrentSession().save(address);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
			return false;

		}
	

	@Override
	public boolean updateCart(Cart cart) {
			try {
				sessionFactory.getCurrentSession().update(cart);
				return true;
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
			return false;

		}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		//String selectQuery="from User where email=:email";
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			User user = (User) criteria.add(Restrictions.eq("email", email))
			                             .uniqueResult();
			
			return user;
			//return  (User) sessionFactory.getCurrentSession().get(User.class,id1);


					
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}	

		
	}

	@Override
	public Address getBillingAddress(User user) {
		String queryname = "from Address where user=:user1 AND billing=:billing1";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("user1", user);
		query.setParameter("billing1", true);

		Address address= (Address) query.uniqueResult();

		return address;
	}

	@Override
	public List<Address> getShippingAddress(User user) {
		String queryname = "from Address where user=:user1 AND shipping=:shipping1";
		Query query = sessionFactory.getCurrentSession().createQuery(queryname);
		query.setParameter("user1", user);
		query.setParameter("shipping1", true);

		List<Address> list= query.list();

		return list;
	}

}

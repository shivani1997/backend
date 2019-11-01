package com.niit.daoimpl;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.dbconfig.DBConfig;
import com.niit.model.CartItem;
import com.niit.model.Users;


@Transactional
public class CartItemDaoImpl implements CartItemDao
{
	SessionFactory sessionFactory;
	@Autowired
	Transaction tx;
	public void addCart(CartItem cart) {
		sessionFactory.getCurrentSession().save(cart);
		
	}

	public void deleteCart(CartItem cart) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	public void updateCart(CartItem cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(cart);
		
	}

	public void displayCart(CartItem cart) {
		// TODO Auto-generated method stub
		
	}

	public List<Users> displayUsers() 
	{
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Users").list();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public Users displayUserById(Users user) 
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where userid= :userid");
			 query.setParameter("userid", user.getUserid());
			 return (Users)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	public Users displayUserByUserName(Users user) {
		// TODO Auto-generated method stub
		try 
		{
			Criteria ctx=sessionFactory.getCurrentSession().createCriteria(Users.class);
			return (Users)ctx.add(Restrictions.eq("username",user.getUsername())).list().get(0);
		} 
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	



	

}

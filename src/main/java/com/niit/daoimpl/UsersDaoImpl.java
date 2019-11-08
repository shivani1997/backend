package com.niit.daoimpl;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UsersDao;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Users;

@Transactional
public class UsersDaoImpl implements UsersDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		user.setEnabled(true);
		user.setAuthority("user");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		sessionFactory.getCurrentSession().save(user);
		return true;
		
	}

	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(user);
		
	}

	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
		
		
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
			System.out.println("inside method...........");
			Query query=sessionFactory.getCurrentSession().createQuery("com.niit.model.User where username:username");
			query.setParameter("username", user.getUsername());
			Users u=(Users)query.getResultList().get(0);
			System.out.println("inside method...................");
			System.out.println(u.getUsername());
			System.out.println(u.getAuthority());
			System.out.println(u.isEnabled());
			return u;
		} 
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	


}

package com.niit.daoimpl;
import com.niit.dao.ProductDao;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Product;
import com.niit.model.Users;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProduct(Product product) 
	{
		product.setStatus("A");
		sessionFactory.getCurrentSession().save(product);
	}

	public void deleteProduct(Product product) 
	{
		sessionFactory.getCurrentSession().delete(product);
	}

	public void updateProduct(Product product) 
	{
		sessionFactory.getCurrentSession().update(product);
	}

	public List<ProductDao> displayProducts()
	{
		try
		{
			//HQL - Hibernate Query Language
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product").list();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public Product displayProductById(Product product)
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where productid= :productid");
			 query.setParameter("productid", product.getProductid());
			 return (Product)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public Product displayProductByName(Product product) 
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where productname= :productname");
			 query.setParameter("productname", product.getProductname());
			 return (Product)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
}

	public void deleteProduct(ProductDao product) {
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(ProductDao product) {
		// TODO Auto-generated method stub
		
	}

	public ProductDao displayProductById(ProductDao product) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDao displayProductByName(ProductDao product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getProductid() {
		// TODO Auto-generated method stub
		return null;
	}
}

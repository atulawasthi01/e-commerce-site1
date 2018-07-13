package com.niit.shoppingbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Product;

@Transactional
@Component
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean addProduct(Product product) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(product);
			//category.setCategoryId((Integer)session.save(category));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.update(product);
			return true;
		}
		catch(HibernateException exception)
		{
	         exception.printStackTrace();
	         return false;
		}
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
	    try {
	         List<Product> product = (List<Product>)session.createQuery("FROM Product").list();
	         return product;
	      } 
	      catch (HibernateException exception) {
	         exception.printStackTrace();
	         return null;
	      }
	}

	public boolean deleteProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Product product = (Product)session.get(Product.class,productId);
			session.delete(product);
			return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public Product getProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Product product = (Product)session.get(Product.class,productId);
			return product;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	public List<Product> getProductListByCategoryId(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			String hql = "FROM Product P WHERE P.categoryId = :category_id";
			Query query = session.createQuery(hql);
			query.setParameter("category_id",categoryId);
			List<Product> results = query.list();
	         return results;
		}
		catch (HibernateException exception) {
	         exception.printStackTrace();
	         return null;
	      }
	}

}

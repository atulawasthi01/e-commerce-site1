package com.niit.shoppingbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Category;
@Transactional
@Component
public class CategoryRepositoryImpl implements CategoryRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		try{
			Session session = sessionFactory.getCurrentSession();
			System.out.println(category.getCategoryDescription()+" "+category.getCategoryName());
			session.save(category);
			//category.setCategoryId((Integer)session.save(category));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.update(category);
			return true;
		}
		catch(HibernateException exception)
		{
	         exception.printStackTrace();
	         return false;
		}
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
	    try {
	    	Query query = session.createQuery("From Category");
	         List<Category> categoryList = (List<Category>)query.getResultList();
	         if(categoryList == null)
	        	 return null;
	         return categoryList;
	      } 
	      catch (HibernateException exception) {
	         exception.printStackTrace();
	         return null;
	      }
	}

	public boolean deleteCategory(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.delete(getCategoryById(categoryId));
			return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public Category getCategoryById(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Category category = (Category)session.get(Category.class,categoryId);
			return category;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

}

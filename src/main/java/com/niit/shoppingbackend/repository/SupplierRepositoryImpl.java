package com.niit.shoppingbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Product;
import com.niit.shoppingbackend.model.Supplier;
@Transactional
@Component
public class SupplierRepositoryImpl implements SupplierRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(supplier);
			//category.setCategoryId((Integer)session.save(category));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.update(supplier);
			return true;
		}
		catch(HibernateException exception)
		{
	         exception.printStackTrace();
	         return false;
		}
	}

	public List<Supplier> getAllSuppliers() {
		Session session = sessionFactory.getCurrentSession();
	    try {
	         List<Supplier> supplier = (List<Supplier>)session.createQuery("FROM Supplier").list();
	         return supplier;
	      } 
	      catch (HibernateException exception) {
	         exception.printStackTrace();
	         return null;
	      }
	}

	public boolean deleteSupplier(int supplierId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Supplier supplier = (Supplier)session.get(Supplier.class,supplierId);
			session.delete(supplier);
			return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierById(int supplierId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Supplier supplier = (Supplier)session.get(Supplier.class,supplierId);
			return supplier;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

}

package com.niit.shoppingbackend.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Item;

@Transactional
@Component
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.save(item);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean updateItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.update(item);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public Item getItemByProductIdAndCustomerId(int productId,int customerId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			String hql = "From Item  WHERE productId = :product_id and customerId = :customer_id";
			Query query = session.createQuery(hql);
			query.setParameter("product_id", productId);
			query.setParameter("customer_id", customerId);
			List<Item> results = (List<Item>)query.getResultList();
			if(results.isEmpty()){
				System.out.println("hello fraands");
				return null;
			}
			else return results.get(0);
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return null;
		}
	}

	public List<Item> getItemListByCartId(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			String hql = "From Item where cart_cartid = :cartId";
			Query query = session.createQuery(hql);
			query.setParameter("cartId", cartId);
			List<Item> results = (List<Item>)query.getResultList();
			return results;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return null;
		}
	}

	public boolean increaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			item.setQuantity(item.getQuantity()+1);
			session.update(item);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean decreaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			item.setQuantity(item.getQuantity()-1);
			session.update(item);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
		
	}

	public boolean deleteItem(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			
			session.delete(item);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

}

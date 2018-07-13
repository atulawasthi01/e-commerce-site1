package com.niit.shoppingbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.Customer;
import com.niit.shoppingbackend.model.Item;

@Transactional
@Component
public class CartRepositoryImpl implements CartRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.save(cart);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}
	
	public Cart getCartBYCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			System.out.println("i m here");
			Query query = session.createQuery("From Cart C where C.customerId = :CI");
			query.setParameter("CI", customerId);
			List<Cart> cartList = query.list();
			System.out.println("i m here");
			return cartList.get(0);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}

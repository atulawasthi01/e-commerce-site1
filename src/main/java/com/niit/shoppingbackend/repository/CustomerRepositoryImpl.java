package com.niit.shoppingbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Author;
import com.niit.shoppingbackend.model.BillingAddress;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.Customer;
import com.niit.shoppingbackend.model.Item;
import com.niit.shoppingbackend.model.ShippingAddress;

@Transactional
@Component
public class CustomerRepositoryImpl implements CustomerRepository{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCustomer(Customer customer) {
		try{
			Session session = sessionFactory.getCurrentSession();
			
			ShippingAddress shippingAddress = customer.getShippingAddress();
			BillingAddress billingAddress = customer.getBillingAddress();
			shippingAddress.setBillingAddress(billingAddress);
			shippingAddress.setCustomer(customer);
			billingAddress.setShippingAddress(shippingAddress);
			billingAddress.setCustomer(customer);
			
			session.saveOrUpdate(customer);
			session.saveOrUpdate(shippingAddress);
			session.saveOrUpdate(billingAddress);
			session.saveOrUpdate(customer);
			session.saveOrUpdate(shippingAddress);
			
			Cart cart = new Cart();
			cart.setCustomer(customer);
			cart.setCustomerId(customer.getCustomerId());
			session.save(cart);
			
			Author author = new Author();
			author.setUserName(customer.getEmail());
			session.save(author);
			
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public boolean updateCustomer(Customer customer) {
		try{
			Session session = sessionFactory.getCurrentSession();
			ShippingAddress shippingAddress = customer.getShippingAddress();
			BillingAddress billingAddress = customer.getBillingAddress();
			shippingAddress.setBillingAddress(billingAddress);
			shippingAddress.setCustomer(customer);
			billingAddress.setShippingAddress(shippingAddress);
			billingAddress.setCustomer(customer);
			session.saveOrUpdate(customer);
			session.saveOrUpdate(shippingAddress);
			session.saveOrUpdate(billingAddress);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return false;
		}
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Customer customer = (Customer) session.get(Customer.class, customerId);
			return customer;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return null;
		}
	}

	public Customer getCustomerByEmail(String customerEmail) {
		Session session = sessionFactory.getCurrentSession();
		try{
			String hql = "From Customer  WHERE email = :customer_email";
			Query query = session.createQuery(hql);
			query.setParameter("customer_email", customerEmail);
			List<Customer> results = (List<Customer>) query.getResultList();
			if(results.isEmpty()){
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
	

}

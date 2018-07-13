package com.niit.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingbackend.model.Author;
import com.niit.shoppingbackend.model.BillingAddress;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Customer;
import com.niit.shoppingbackend.model.Item;
import com.niit.shoppingbackend.model.Product;
import com.niit.shoppingbackend.model.ShippingAddress;
import com.niit.shoppingbackend.model.Supplier;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.niit")
public class HibernateConfiguration {
	
	@Bean("dataSource")
	public DataSource geth2DataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("atul");
		dataSource.setPassword("atul");
		return dataSource;
		
	}
	@Autowired
	@Bean("sessionFactory")
	public  SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);

		sessionFactory.addAnnotatedClass(Author.class);
		sessionFactory.addAnnotatedClass(Product.class);
		sessionFactory.addAnnotatedClass(Category.class);
		sessionFactory.addAnnotatedClass(Supplier.class);
		sessionFactory.addAnnotatedClass(Customer.class);
		sessionFactory.addAnnotatedClass(ShippingAddress.class);
		sessionFactory.addAnnotatedClass(BillingAddress.class);
		sessionFactory.addAnnotatedClass(Item.class);
		sessionFactory.addAnnotatedClass(Cart.class);
		sessionFactory.addProperties(getHibernateProperties());
		
		return sessionFactory.buildSessionFactory();
		
	}
	public Properties getHibernateProperties()
	{

		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	@Autowired
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

}

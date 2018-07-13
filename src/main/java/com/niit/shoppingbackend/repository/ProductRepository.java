package com.niit.shoppingbackend.repository;

import java.util.List;
import com.niit.shoppingbackend.model.Product;

public interface ProductRepository {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	List<Product> getAllProducts();
	boolean deleteProduct(int productId);
	Product getProductById(int productId);
	List<Product> getProductListByCategoryId(int categoryId);
	
}

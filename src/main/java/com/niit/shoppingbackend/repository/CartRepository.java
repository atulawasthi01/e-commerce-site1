package com.niit.shoppingbackend.repository;

import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.Customer;

public interface CartRepository {

	boolean addCart(Cart cart);
	Cart getCartBYCustomer(int customerId);


}

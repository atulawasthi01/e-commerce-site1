package com.niit.shoppingbackend.repository;

import java.util.List;

import com.niit.shoppingbackend.model.Item;

public interface ItemRepository {
	
	boolean addItem(Item item);
	boolean updateItem(Item item);
	Item getItemByProductIdAndCustomerId(int productId,int customerId);
	List<Item> getItemListByCartId(int cartId);
	boolean increaseQuantity(int itemId);
	boolean decreaseQuantity(int itemId);
	boolean deleteItem(int itemId);
	
	

}

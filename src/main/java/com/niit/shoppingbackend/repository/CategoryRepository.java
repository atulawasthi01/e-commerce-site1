package com.niit.shoppingbackend.repository;

import java.util.List;

import com.niit.shoppingbackend.model.Category;

public interface CategoryRepository {

	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	List<Category> getAllCategories();
	boolean deleteCategory(int categoryId);
	Category getCategoryById(int categoryId);
}

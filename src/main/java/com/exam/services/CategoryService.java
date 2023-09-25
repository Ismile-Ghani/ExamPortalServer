package com.exam.services;

import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {
	
	Category addCategory(Category category);
	
	Set<Category> getCategories();
	
	Category getCategory(Long cId);
	
	Category updateCategory(Category category);
	
	 void deleteCategory(Long cId);
	
	

}

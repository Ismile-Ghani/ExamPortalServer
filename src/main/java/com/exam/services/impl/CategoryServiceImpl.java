package com.exam.services.impl;

import java.util.LinkedHashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository crepo;
	

	@Override
	public Category addCategory(Category category) {
		
		return this.crepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		Set<Category> allCategory = new LinkedHashSet<>(this.crepo.findAll()); 
		
		return allCategory;
	}

	@Override
	public Category getCategory(Long cId) {
		
		
		return this.crepo.findById(cId).get();
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.crepo.save(category);
	}

	@Override
	public void deleteCategory(Long cId) {
		this.crepo.deleteById(cId);
		
	}

}

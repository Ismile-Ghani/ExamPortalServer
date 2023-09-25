package com.exam.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.addCategory(category));
	}
	
	
	@GetMapping("/{cId}")
	public ResponseEntity<?> getCategory(@PathVariable("cId") long cId) {
		return ResponseEntity.ok(this.categoryService.getCategory(cId));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return ResponseEntity.ok( new LinkedHashSet(this.categoryService.getCategories()));
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	
	
	@DeleteMapping("/{cId}")
	public void deleteCategory(@PathVariable("cId") long cId) {
		this.categoryService.deleteCategory(cId);
		//return "Record with id" + cId + "deleted";
		}

}

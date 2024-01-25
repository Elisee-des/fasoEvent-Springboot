package com.admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin_user.dto.CategoryDto;
import com.admin_user.model.Category;
import com.admin_user.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categorieRepository;

	@Autowired
	public CategoryService(CategoryRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	public void ajoutCategory(Category category)
	{
		categorieRepository.save(category);
	}
	
	public List<Category> getAllCategories()
	{
		return categorieRepository.findAll();
	}
	
	
}

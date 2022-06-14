package com.example.ServiceImplementation;



import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CrudRepository.CategoryRepo;
import com.example.Exception.CustomException;
import com.example.MainModel.Category;
import com.example.Service.CategoryService;



@Service
public class CategoryServiceImpli implements CategoryService{

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpli.class);
	
	@Autowired
	private CategoryRepo repository; 

	@Override
	public Iterable<Category> getAllCategory() {
		logger.info("Category Service Implementation : getAllCategory() method");
		return repository.findAll(); 
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		logger.info("Category Service Implementation : saveCategory() method");
		return repository.save(category); 
	}

	@Override
	public Category getCategoryById(Integer Id) {
		logger.info("Category Service Implementation : getCategoryById() method");
		Category category=repository.findById(Id);
		if(category==null) {  
			throw new CustomException("Category id "+Id+" incorrect..");
		}
		return category;
	}

	@Override
	public void deleteCategory(Integer id) {
		logger.info("Category Service Implementation : deleteCategory() method");
		repository.deleteById(id);
	}

}



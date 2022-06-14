package com.example.CrudRepository;
import java.io.Serializable;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MainModel.Category;



	
@Repository
		public interface CategoryRepo extends CrudRepository<Category, Serializable>{
			
			public Category findById(Integer Id);

		
	}








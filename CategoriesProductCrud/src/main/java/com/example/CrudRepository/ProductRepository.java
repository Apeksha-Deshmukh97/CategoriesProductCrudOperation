package com.example.CrudRepository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MainModel.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Serializable>{
	
	
		
		public Product findById(Integer Id);

	}



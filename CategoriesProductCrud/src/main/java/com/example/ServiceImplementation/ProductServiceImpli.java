package com.example.ServiceImplementation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CrudRepository.ProductRepository;
import com.example.Exception.CustomException;
import com.example.MainModel.Product;
import com.example.Service.ProductService;



@Service
public class ProductServiceImpli implements ProductService{

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpli.class);
	
	@Autowired
	private ProductRepository repository; 

	@Override
	public Iterable<Product> getAllProduct() {
		logger.info("Product Service Implementation : getAllProduct() method");
		return repository.findAll(); 
	}

	@Override
	@Transactional
	public Product saveProduct(Product product) {
		logger.info("Product Service Implementation : saveProduct() method");
		return repository.save(product); 
	}

	@Override
	public Product getProductById(Integer Id) {
		logger.info("Product Service Implementation : getProductById() method");
		Product product=repository.findById(Id);
		if(product==null) {  
			throw new CustomException("Product id "+Id+" incorrect..");
		}
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		logger.info("Product Service Implementation : deleteProduct() method");
		repository.deleteById(id);
	}


}



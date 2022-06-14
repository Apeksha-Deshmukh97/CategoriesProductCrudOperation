package com.example.Service;

import com.example.MainModel.Product;

public interface ProductService {

	
	public Iterable<Product> getAllProduct();
	public Product saveProduct(Product product);
	public <optional>Product getProductById(Integer Id);
	public void deleteProduct(Integer id);
	
}



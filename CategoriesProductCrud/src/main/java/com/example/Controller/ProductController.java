package com.example.Controller;
	import java.util.Collections;

	import java.util.Map;
	import javax.servlet.http.HttpServletRequest;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;

import com.example.MainModel.Product;
import com.example.Service.ProductService;


	@RestController
	@RequestMapping("/api")
	public class ProductController {

		private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

		@Autowired
		private ProductService productService;

		
		 // This method is used to get all the product details
		  
	
		@GetMapping("/products")
		public @ResponseBody Iterable<Product> getAllProduct() throws Exception {
			logger.info("Product Rest Controller Implementation : getAllProduct() method");
			return productService.getAllProduct(); //calling
		}

		
		 // This method is used to store the product details .
	

		@PostMapping("/products")
		public ResponseEntity<Product> createProduct(@RequestBody Product product, HttpServletRequest request)
				throws Exception {
			Product createdProduct = this.productService.saveProduct(product); 
			logger.info("Product Rest Controller Implementation : createProduct() method");
			return ResponseEntity.ok().body(createdProduct);
		}

		
		//  This method is used to get the product details by using id
		
		@GetMapping("/products/{id}")   
		public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
			Product product = productService.getProductById(id); 
			logger.info("Product Rest Controller Implementation : getProductById() method");
			return ResponseEntity.ok().body(product);
		}

		
		//  This method is used to delete the product details of user by using id.
		 

		@DeleteMapping("/products/{id}")
		public Map<String, String> deleteProductById(@PathVariable("id") Integer id) throws Exception {
			Product product = productService.getProductById(id); 
			logger.info("Product Rest Controller Implementation : deleteProductById() method");
			if (product != null) { 
				productService.deleteProduct(id); 
				return Collections.singletonMap("success", "Record Deleted Successfully");
			} else {
				return Collections.singletonMap("failure", "your passing id is wrong");
			}

		}

		//This method is used to update the record
		
		@PutMapping("/products/{id}")
		public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer id, @RequestBody Product product) {
			Product products = productService.getProductById(id);
			products.setProductId(product.getProductId());
			products.setAmount(product.getAmount());
			products.setProductDescription(product.getProductDescription());
			products.setProductName(product.getProductName());
			products.setQuantity(product.getQuantity());
			Product products2 = productService.saveProduct(products);
			return ResponseEntity.ok().body(products2);
		}

	}


package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.Response;

@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addProduct(@RequestBody Product product){
		ResponseEntity<Response> r = null;
		Response response = productService.addProduct(product);
		if(response.isResult()) {
			r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		}
		else {
			new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500));
		}
		return r;
		
		}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId){
		Product product = productService.getProductById(productId);
		return  ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok().body(products);
		}
	

	@PutMapping("/update")
	public ResponseEntity<Response> updateProduct(@RequestBody Product product){
		Response response = productService.updateProduct(product);
		 ResponseEntity<Response> r = null;
			if(response.isResult()) {
				r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
			}
			else {
				new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500));
			}
			return r;
			
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Response> deleteProduct(@PathVariable int productId){
		Response response = productService.deleteProduct(productId);
		 ResponseEntity<Response> r = null;
		if(response.isResult()) {
			r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		}
		else {
			new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500));
		}
		return r;
		
		}
	
	

}


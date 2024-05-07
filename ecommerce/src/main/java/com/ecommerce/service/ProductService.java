package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;

public interface ProductService {
	
	public Response addProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
     public Response updateProduct(Product product);
	public Response deleteProduct(int productId);
	
	
	

}

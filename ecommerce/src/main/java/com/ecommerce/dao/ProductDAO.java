package com.ecommerce.dao;


import java.util.List;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;

public interface ProductDAO {
	
	public Response addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int productId);
    public Response updateProduct(Product product);
	public Response deleteProduct(int productId);
	

}

package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductDAO;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;

@Service
public class ProductServiceImpl implements ProductService{

	  @Autowired
      ProductDAO productDAO;

	@Override
	@Transactional
	public Response addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			productDAO.addProduct(product);
			return new Response();
		}
		catch(Exception e) {
			return new Response();
		}
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

 	@Override
	@Transactional
	public Response updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			productDAO.updateProduct(product);
			return new Response();
		}
		catch(Exception e) {
			return new Response();
		}
	}

	@Override
	@Transactional
	public Response deleteProduct(int productId) {
		// TODO Auto-generated method stub
		try {
			productDAO.deleteProduct(productId);
			return new Response();
		}
		catch(Exception e) {
			return new Response();
		}
	}

}

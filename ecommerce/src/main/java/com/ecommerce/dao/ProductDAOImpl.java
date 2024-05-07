package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;


@Repository

public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Response addProduct(Product product) {
		// TODO Auto-generated method stub
    try {
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(product);
    	tx.commit();
    	session.close();
    	return new Response();
    } catch(Exception e) {
    	return new Response();
    }
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
        session.close();
		return products;
	}

  @SuppressWarnings("deprecation")
	@Override
	public Response updateProduct(Product product) {
		// TODO Auto-generated method stub
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(product);
            tx.commit();
            session.close();
            return new Response();
        } catch (Exception e) {
            return new Response();
        }

	}

	
	

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
	        Product product = session.get(Product.class, productId);
	        session.close();
	        return product;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Response deleteProduct(int productId) {
		// TODO Auto-generated method stub
		 try {
	            Session session = sessionFactory.openSession();
	            Transaction tx = session.beginTransaction();
	            Product product = session.get(Product.class, productId);
	            session.delete(product);
	            tx.commit();
	            session.close();
	            return new Response();
	        } catch (Exception e) {
	            return new Response();
	        }
	}

}

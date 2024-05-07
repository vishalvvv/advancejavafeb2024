package com.usermgt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usermgt.model.User;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String createUser(User user) {
		String result ="fail";
		Session session = sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		 try {
			   session.save(user); 
			  // tx.commit();
			   result ="success";   
		 }
		 catch(Exception e) {
			 System.out.println("inside catch");
			  System.out.println(e);
			  
			 
		 }
		return result;
	}
	@Override
	public List getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List list =query.list();
		System.out.println(list.size());
		return list;
	}
	@Override
	public boolean deleteUser(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		boolean result = false;
		  long l = userId;
		try
		{
			User user = session.get(User.class,l);
			session.delete(user);
			result= true;
		}
		catch(Exception e) {
			 System.out.println(e);
		}
	
		return result;
	}
	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class,userId);
		return user;
	}
	@Override
	public boolean updateUser(User user) {
		boolean result = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			result = true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
		return result;
		
		
	}

}

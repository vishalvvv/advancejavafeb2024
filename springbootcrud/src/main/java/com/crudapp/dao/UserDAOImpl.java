package com.crudapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.utils.ActionResponse;
import com.crudapp.model.User;

import jakarta.persistence.Query;

@Repository
public class UserDAOImpl implements UserDAO {

	 @Autowired
	 SessionFactory sessionFactory;
	 
	public ActionResponse register(User user) {
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		ActionResponse ar = new ActionResponse();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			session.persist(user);
			tx.commit();
			
			ar.setAction("user_registration");
			ar.setResponse("success");
			
		}catch(Exception e) {
			System.out.println(e);
			ar.setAction("user_registration");
			ar.setResponse("failure");
		}
		return ar;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		 Query query = session.createQuery("from User u");
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public ActionResponse deleteUser(long userId) {
		ActionResponse ar = new ActionResponse();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			User user = session.get(User.class, userId);
			  session.remove(user);
			tx.commit();
			
			ar.setAction("user_delete");
			ar.setResponse("success");
			
		}catch(Exception e) {
			System.out.println(e);
			ar.setAction("user_delete");
			ar.setResponse("failure");
		}
		return ar;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResponse updateUser(User user) {
		
		ActionResponse ar = new ActionResponse();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			session.update(user);
			tx.commit();
			
			ar.setAction("user_update");
			ar.setResponse("success");
			
		}catch(Exception e) {
			System.out.println(e);
			ar.setAction("user_update");
			ar.setResponse("failure");
		}
		return ar;
	}

}

package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;
import com.ecommerce.utils.EmailDetails;
import com.ecommerce.utils.Response;

@Repository
public class UserDAOImpl implements UserDAO {

	 @Autowired
	 SessionFactory sessionFactory;
	 @Autowired 
	 private JavaMailSender javaMailSender;
	@Override
	public Response register(User user) {
		 Response response = new Response(); 
		
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
			response.setMessage("Registration successful");
			response.setOperation("user_registration");
			response.setResult(true);
		}
		catch (Exception e) {
			 System.out.println(e);
			    response.setMessage("Registration successful");
				response.setOperation("user_registration");
				response.setResult(false);
				response.setError(e.getMessage());
		}
		return response;
	}
	@SuppressWarnings("deprecation")
	@Override
	public Response login(User user) {
		 Response response = new Response();
			try {
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				List list = session.createQuery("from User where email= :email").setParameter("email", user.getEmail()).list();
			//	User u1 =(User)list.get(0);
				  if (!list.isEmpty()) {
			            User retrievedUser = (User) list.get(0); // Casting to User object
			            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			            
			            if (passwordEncryptor.checkPassword(user.getPassword(), retrievedUser.getPassword())) {
			                response.setMessage("Login successful");
			                response.setOperation("user_login");
			                response.setResult(true);
			            } else {
			                response.setMessage("Incorrect password");
			                response.setOperation("user_login");
			                response.setResult(false);
			            }
			        } else {
			            response.setMessage("User not found");
			            response.setOperation("user_login");
			            response.setResult(false);
			        }
			        
			        tx.commit();
			}
			catch (Exception e) {
				 System.out.println(e);
				  response.setMessage("Login unsuccessful");
					response.setOperation("user_login");
					response.setResult(false);
					response.setError(e.getMessage());
				 
			}
			return response;
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public Response forgotPassword(User user) {
		
		 Response response = new Response(); 
		 
		 try {
				Session session = sessionFactory.openSession();
				
				List list = session.createQuery("from User where email= :email").setParameter("email", user.getEmail()).list();
				User u1 =(User)list.get(0);
				System.out.println("u1" + u1);
				
				System.out.println("password:" + u1.getPassword());
				  if(u1.getUsername().length() == 0) {
					  response.setMessage("mail not sent");
						response.setOperation("forgot_password");
						response.setResult(false);
						response.setError("Email not found");
				  }
				  else {
					   EmailDetails emailDetails = new EmailDetails();
					     emailDetails.setMsgBody("Click the  link to reset your password <a href='https://www.digital-lync.com'>Reset Password</a>");
					     emailDetails.setRecipient(user.getEmail());
					     emailDetails.setSubject("Password Reset - ECommerce");
					   String msg = sendSimpleMail(emailDetails);
					   System.out.println("msg"+ msg);
					  response.setMessage("mail sent");
						response.setOperation("forgot_password");
						response.setResult(true);
						
				  }
				 // tx.commit();
				
			}
			catch (Exception e) {
				 System.out.println(e);
				
			}
			return response;
		
	}
	
	
	
	
	public String sendSimpleMail(EmailDetails details)
	 {

	     // Try block to check for exceptions
	     try {

	         // Creating a simple mail message
	         SimpleMailMessage mailMessage
	             = new SimpleMailMessage();

	         // Setting up necessary details
	         mailMessage.setFrom("vishalchandra504@gmail.com");
	         mailMessage.setTo(details.getRecipient());
	         mailMessage.setText(details.getMsgBody());
	         mailMessage.setSubject(details.getSubject());

	         // Sending the mail
	         javaMailSender.send(mailMessage);
	         return "Mail Sent Successfully...";
	     }

	     // Catch block to handle the exceptions
	     catch (Exception e) {
	         return "Error while Sending Mail";
	     }
	 }
	@SuppressWarnings("deprecation")
	@Override
	public Response changePassword(User user) {
		// TODO Auto-generated method stub
		Response response = new Response();
		try {
			 Session session = sessionFactory.openSession();
		        
		        // Query the database to find the user by email or username
		        Query query = session.createQuery("FROM User WHERE email = :email OR username = :username");
		        query.setParameter("email", user.getEmail());
		        query.setParameter("username", user.getUsername());
		        User existingUser = (User) query.uniqueResult();
		        
		        if (existingUser != null) {
		            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		            String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		            existingUser.setPassword(encryptedPassword);
		            session.update(existingUser);
		            response.setMessage("Password changed successfully");
		            response.setOperation("changePassword");
		            response.setResult(true);
		}
		        else {
		            response.setMessage("User not found");
		            response.setOperation("changePassword");
		            response.setResult(false);
		        }
		}
			catch(Exception e) {
			System.out.println(e);
			 response.setMessage("Failed to change password");
		        response.setOperation("changePassword");
		        response.setResult(false);
		        response.setError(e.getMessage());
		
	}
		return response;
	
	}
}

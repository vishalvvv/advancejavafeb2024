package com.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.utils.ActionResponse;
import com.crud.utils.EmailDetails;
import com.crudapp.dao.UserDAO;
import com.crudapp.model.User;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	 UserDAO userdao;
	 @Autowired 
	 private JavaMailSender javaMailSender;
	 
	 @Transactional
	public ActionResponse register(User user) {
		// TODO Auto-generated method stub
		System.out.println("In Service");
		ActionResponse response = userdao.register(user);
		EmailDetails emailDetails = new EmailDetails();
		 emailDetails.setRecipient(user.getEmail());
		 emailDetails.setMsgBody("You are registered successfully!");
		 emailDetails.setSubject("Registration");
		String res =sendSimpleMail(emailDetails);
		System.out.println(res);
		return response;
	}

     @Transactional
	public List<User> getUsers() {
		return userdao.getUsers();
	}

	@Transactional
	public ActionResponse deleteUser(long userId) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(userId);
	}

	@Transactional
	public ActionResponse updateUser(User user) {
		// TODO Auto-generated method stub
		return  userdao.updateUser(user);
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

}

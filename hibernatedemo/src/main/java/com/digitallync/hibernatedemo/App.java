package com.digitallync.hibernatedemo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
      Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
      SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
     Session session= sessionFactory.openSession();
     Transaction tx=session.beginTransaction();
     tx.begin();
     // insert operation
  //   User user=new User();
 //   Scanner sc=new Scanner(System.in);
  //   System.out.println("Enter emailId");
  //  String emailId = sc.next();
  //   user.setEmailId(emailId);
   //  System.out.println("Enter password");
   // String password=sc.next();
   //  user.setPassword(password);
  //   System.out.println("Enter role");
   //  String role=sc.next();
  //  user.setRole(role);
  //   System.out.println("Enter username");
  //   String username=sc.next();
  //   user.setUsername(username);
   //  session.save(user);
  //   tx.commit();
   //  System.out.println("User saved successfully");
     
     
     // list users
      Query query = session.createQuery("from User");
     List list = query.list();
     Iterator it = list.iterator();
     while(it.hasNext()) {
    	 User user = (User)it.next();
    	 System.out.println(user.getUserId() +"\t"+ user.getEmailId() +"\t"+ user.getPassword());
    }
     
     tx.commit();
     System.out.println("User listed successfully");
     
     
     // update users
     
     // working code 
//      Scanner sc = new Scanner(System.in);
 //    System.out.println("Enter the user ID to update");
 //    int userIdToUpdate=sc.nextInt();
     // Check if the user with the specified ID exists
 //   User existingUser = session.get(User.class, userIdToUpdate);
  //   if (existingUser != null) {
   //     System.out.println("Enter new username:");
   //     existingUser.setUsername(sc.next());

   //     System.out.println("Enter new password:");
   //     existingUser.setPassword(sc.next());

    //     System.out.println("Enter new emailId:");
    //     existingUser.setEmailId(sc.next());

     //    System.out.println("Enter new role:");
      //   existingUser.setRole(sc.next());

         // Save the updated user information
    //    session.update(existingUser);
         
   //     System.out.println("User updated successfully");
 //    }
 //   else {
  //  	 System.out.println("User with ID " + userIdToUpdate + "not found");
 //    }
  //  tx.commit();
     
    
      
     // delete users
     
    
     // working code
 //    Scanner sc = new Scanner(System.in);
 //   System.out.println("Enter the user ID to delete:");
 //   int userIdToDelete = sc.nextInt();
    
 //   User userToDelete = session.get(User.class,userIdToDelete);
 //   if(userToDelete!=null) {
   // 	session.delete(userToDelete);
   // 	tx.commit();
  //  	System.out.println("User deleted successfully");
  //  }
  //  else {
  //  	System.out.println("User with ID " + userIdToDelete + "not found");
  //  }
    
    
    
     
    }
}

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
   //  Transaction tx=session.beginTransaction();
   //  tx.begin();
     User user = (User)session.get(User.class,1);
     System.out.println(user.getUsername()+"\t"+user.getPassword()+"\t"+user.getRole()+"\t"+user.getEmailId());
 //    System.out.println("-----------------------");
   User user2 = (User)session.get(User.class,1);
     System.out.println(user2.getUsername()+"\t"+user2.getPassword()+"\t"+user2.getRole()+"\t"+user2.getEmailId());
  //   System.out.println("---------------------");
     Session session2 = sessionFactory.openSession();
     User user3 = (User)session2.get(User.class, 1);
     System.out.println(user3.getUsername()+"\t"+user3.getPassword()+"\t"+user3.getRole()+"\t"+user3.getEmailId());
     
     Session session3 = sessionFactory.openSession();
     User user4=(User)session3.get(User.class,1);
     System.out.println(user4.getUsername()+"\t"+user4.getPassword()+"\t"+user4.getRole()+"\t"+user4.getEmailId());
     
    	User user5=(User)session3.get(User.class,1);
    	System.out.println(user5.getUsername()+"\t"+user5.getPassword()+"\t"+user5.getRole()+"\t"+user5.getEmailId());
    	
    	session.close();
    	System.out.println("----------------------");
    	
    //	StandardServiceRegistry ssr2 = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    //    Metadata meta2 = new MetadataSources(ssr).getMetadataBuilder().build();
   //     Metadata meta2 = new MetadataSources(ssr2).getMetadataBuilder().build();
        
    //	
    //	SessionFactory sessionFactory2=meta2.getSessionFactoryBuilder().build();
    //	Session session4=sessionFactory2.openSession();
    //	User user6=(User)session4.get(User.class,1);
    //	System.out.println(user6.getUsername()+"\t"+user6.getPassword()+"\t"+user6.getRole()+"\t"+user6.getEmailId());
    		 
    		 
    		 
    		 
    		 
    		 
    		 
     
     
     
    // tx.commit();
    
     
     
     
      
     
     
     
    }
}

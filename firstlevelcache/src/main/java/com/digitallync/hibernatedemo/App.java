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
     User user = (User)session.get(User.class,1);
     System.out.println(user.getUsername()+"\t"+user.getPassword()+"\t"+user.getRole()+"\t"+user.getEmailId());
     System.out.println("-----------------------");
   User user2 = (User)session.get(User.class,1);
     System.out.println(user2.getUsername()+"\t"+user2.getPassword()+"\t"+user2.getRole()+"\t"+user2.getEmailId());
     System.out.println("---------------------");
     User user3 = (User)session.get(User.class, 2);
     System.out.println(user3.getUsername()+"\t"+user3.getPassword()+"\t"+user3.getRole()+"\t"+user3.getEmailId());
     
     User user4 = (User)session.get(User.class, 2);
     System.out.println(user4.getUsername()+"\t"+user4.getPassword()+"\t"+user4.getRole()+"\t"+user4.getEmailId());
     User user5 = (User)session.get(User.class, 2);
     System.out.println(user5.getUsername()+"\t"+user5.getPassword()+"\t"+user5.getRole()+"\t"+user5.getEmailId());
     User user6 = (User)session.get(User.class, 2);
     System.out.println(user6.getUsername()+"\t"+user6.getPassword()+"\t"+user6.getRole()+"\t"+user6.getEmailId());
     User user7 = (User)session.get(User.class, 2);
     System.out.println(user7.getUsername()+"\t"+user7.getPassword()+"\t"+user7.getRole()+"\t"+user7.getEmailId());
     User user8 = (User)session.get(User.class, 2);
     System.out.println(user8.getUsername()+"\t"+user8.getPassword()+"\t"+user8.getRole()+"\t"+user8.getEmailId());
     
     
     tx.commit();
    
     
     
     
      
     
     
     
    }
}

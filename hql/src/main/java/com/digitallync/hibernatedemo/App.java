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
     
         String hqlQuery="FROM User";
         Query query = session.createQuery(hqlQuery);
         List list = query.list();
         Iterator it = list.iterator();
         while(it.hasNext()) {
        	 User user=(User)it.next();
        	 System.out.println(user.getEmailId()+"\t"+user.getUsername());
         }
         
     
     
     
     
     
     
     
   
     
     
     
    }
}

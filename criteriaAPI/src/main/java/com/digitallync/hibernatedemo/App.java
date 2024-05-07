package com.digitallync.hibernatedemo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;



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
      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(User.class);
    //  criteria.add(Restrictions.lt("salary",50000L));
      criteria.add(Restrictions.gt("salary",60000L));
      List list = criteria.list();
      Iterator it = list.iterator();
      while(it.hasNext()) {
    	   User user =(User)it.next();
    	   System.out.println(user.getEmailId()+"\t"+user.getUsername());
      }
      
     
      
      
     
   //  User user = new User();
   //  user.setUsername("michelle");
   //  user.setEmailId("michellew@gmail.com");
   //  user.setPassword("michelle123");
   //  user.setRole("srmgr");
   //  user.setSalary(25000L);
     
  //   user.setUsername("scarlett");
  //   user.setEmailId("scarlettj@gmail.com");
   //  user.setPassword("scarlett123");
   //  user.setRole("director");
   //  user.setSalary(80000L);
     
     
  //   user.setUsername("sakshi");
   //  user.setEmailId("sakshim@gmail.com");
  //   user.setPassword("sakshi123");
   //  user.setRole("hrbp");
   //  user.setSalary(40000L);
     
     
     
     
     
   //  session.save(user);
  //   tx.commit();
     
     
     
     
         
     
     
     
     
     
     
     
   
     
     
     
    }
}

package com.digitallync.hibernatemappings;

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
         try {
             // Create and save a Laptop
             Laptop laptop = new Laptop();
             laptop.setLid(107);
             laptop.setLname("sony");
             session.save(laptop);
             
             // Create and save a Student
             Student student = new Student();
             student.setName("zen");
             student.setRollno(7);
             student.setMarks(64);
    //     student.setLaptop(laptop);
             student.getLaptop().add(laptop);
             
             laptop.getStudent().add(student);
         
             session.save(student);
             
             // Commit the transaction
             tx.commit();
         } catch (Exception e) {
             // Rollback the transaction if an error occurs
             if (tx != null) {
                 tx.rollback();
             }
             e.printStackTrace();
         } finally {
             // Close the session and session factory
             session.close();
             sessionFactory.close();
         }
    }
}

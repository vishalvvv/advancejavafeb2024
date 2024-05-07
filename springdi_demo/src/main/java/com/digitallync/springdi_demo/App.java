package com.digitallync.springdi_demo;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer)context.getBean("customer");
        System.out.println(customer.getAccount().getBalance());
        System.out.println(customer.getAccount().getAccountId());
    }
}

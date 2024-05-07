package xyz.hibernate.basichiberante;

/**
 * Hello world!
 *
 */
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta =  new MetadataSources(ssr).getMetadataBuilder().build();
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    System.out.println("factory:"+ factory);
       Session session= factory.openSession();
       Transaction tx = session.beginTransaction();
         Employee employee= new Employee();
         employee.setName("kiran");
         employee.setAddress("hyd");
         employee.setRole("Developer");
         session.save(employee); 
         tx.commit();
         
    }
}

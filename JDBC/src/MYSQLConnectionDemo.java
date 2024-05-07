import java.sql.Connection;
import java.sql.DriverManager;


public class MYSQLConnectionDemo {
	
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			// load the driver class
			
			try {

			
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// provide connection details
			
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/715am","root","sequel123");
				
				System.out.println(connection);
				connection.close();
				System.out.println(connection.isClosed());
		}
			
			
			catch(Exception e) {
				System.out.println("inside catch block");
				System.out.println(e);
			}
			
		}

	}




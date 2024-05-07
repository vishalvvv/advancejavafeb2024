
import java.sql.Connection;
import java.sql.DriverManager;

	public class DBUtil {

		public static Connection getConnection() {
			Connection connection=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/715am","root","sequel123");
				return connection;
			}
			catch(Exception e) {
				System.out.println(e);
				return connection;
			}
			
		}

	}




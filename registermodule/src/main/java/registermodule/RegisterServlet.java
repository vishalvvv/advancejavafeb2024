package registermodule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	Connection connection = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		  ServletContext context= config.getServletContext();
		
		  String driverclass = context.getInitParameter("driverclass");
		  String url = context.getInitParameter("url");
		  String username = context.getInitParameter("username");
		  String password = context.getInitParameter("password");
		  
		  System.out.println(driverclass);
		  System.out.println(url);
		  System.out.println(username);
		  System.out.println(password);
		  // Create the object for DBConnectionDetails class and use setter methods and assign the db values and send to getConnection function
		
		   DBConnectionDetails db= new DBConnectionDetails(); 
		     db.setDriverClassName(driverclass);
		     db.setPassword(password);
		     db.setUrl(url);
		     db.setUsername(username);
		  
		  connection = getConnection(db);
		//System.out.println("getConnection" + connection);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   PrintWriter out = resp.getWriter();
		   out.print("<html>\r\n"
		   		+ "<head>\r\n"
		   		+ "\r\n"
		   		+ "</head>\r\n"
		   		+ "\r\n"
		   		+ "<body>\r\n"
		   		+ "<center>\r\n"
		   		+ " <h1>Register here</h1>\r\n"
		   		+ "    <form action=\"./register\" method=\"post\">\r\n"
		   		+ "    <input type=\"text\" name=\"username\" placeholder=\"username here\"> <br><br>\r\n"
		   		+ "    <input type=\"text\" name=\"email\" placeholder=\"email here\"> <br><br>\r\n"
		   		+ "    <input type=\"password\" name=\"password\" placeholder=\"password here\"> <br><br>\r\n"
		   		+ "    <button>Register</button>\r\n"
		   		+ "    </form>\r\n"
		   		+ "\r\n"
		   		+ "    </center>\r\n"
		   		+ "</body>\r\n"
		   		+ "</html>\r\n"
		   		+ "");
		   
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  System.out.println("DO POST CALED");
		  String username = req.getParameter("username");
		  String password = req.getParameter("password"); 
		  String email = req.getParameter("email"); 
		  
		  System.out.println(username);
		  System.out.println(password);
		  System.out.println(email);
		  
		  String query= "insert into User values('"+username+"','"+password+"','"+email+"')";
try {
	 connection.createStatement().execute(query);
	 resp.getWriter().print("<h1> Registration Successful </h1>");
}catch(Exception e) {
	 System.out.println(e);
}
		  
		  
		  
	}
	
	private  Connection getConnection(DBConnectionDetails details) {
		// get the values and incorporate in the required positions.
		 Connection connection = null;
		  try {
			  Class.forName(details.getDriverClassName());
			   connection=DriverManager.getConnection(details.getUrl(),details.getUsername(),details.getPassword());
			   return connection;
		  }
		  catch(Exception e) {
			   System.out.println(e);
			   return connection;
		  }
	}
	
}

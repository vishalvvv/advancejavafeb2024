package registermodule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		   out.print("<html>\r\n"
		   		+ "<head>\r\n"
		   		+ "\r\n"
		   		+ "</head>\r\n"
		   		+ "\r\n"
		   		+ "<body>\r\n"
		   		+ "<center>\r\n"
		   		+ " <h1>Login here</h1>\r\n"
		   		+ "    <form action=\"./login\" method=\"post\">\r\n"
		   		+ "    <input type=\"text\" name=\"email\" placeholder=\"email here\"> <br><br>\r\n"
		   		+ "    <input type=\"password\" name=\"password\" placeholder=\"password here\"> <br><br>\r\n"
		   		+ "    <button>Login</button>\r\n"
		   		+ "    </form>\r\n"
		   		+ "\r\n"
		   		+ "    </center>\r\n"
		   		+ "</body>\r\n"
		   		+ "</html>\r\n"
		   		+ "");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DO POST CALED");
		
		PrintWriter out= response.getWriter();
		  
		  String password = request.getParameter("password"); 
		  String email = request.getParameter("email"); 
		  
		 
		  System.out.println(password);
		  System.out.println(email);
		  
		  String query= "select password,username from user where email='"+email+"'";
try {
	ResultSet rs = connection.createStatement().executeQuery(query);
	   String passwordFromDB = "";
	   String username = "";
	  while(rs.next()) {
		   passwordFromDB = rs.getString("password");
		   username= rs.getString("username");
		   
	  }
	  
	   if(passwordFromDB.length() > 0) {
		        if(passwordFromDB.contentEquals(password)) {
		        	  HttpSession session =  request.getSession();
		        	  session.setAttribute("username", username);
		        	  out.print("<h1>Welcome: "+username +"</h1>");
		        	  out.print("<a href='./inbox'>Inbox</a> &nbsp;&nbsp;&nbsp;");
		        	  out.print("<a href='./outbox'>Outbox</a>");
		        }
		        else {
		        	out.print("<h1>Login Failure</h1>");
		        }
	   }
	   else {
		   out.print("<h1>User not found</h1>");
	   }
	 
}
catch(Exception e) {
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

package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Third extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		
		System.out.println("do get  called");
		
		PrintWriter out=resp.getWriter();
		
		out.print("<html><head></head><body><h1 style='text-align:center; color:red'>this response is from servlet</h1><form><input type='text' placeholder='username here'</form></body></html>");
		
		
		
	}
	

}

package javabeanandservelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<B>Hello!");
		pw.close();
	}
}

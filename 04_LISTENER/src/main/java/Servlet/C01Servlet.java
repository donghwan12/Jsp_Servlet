package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test1")
public class C01Servlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String val=(String)req.getServletContext().getAttribute("CTX_ATTR1");
		out.println("<h1>Servlet ContextListner Test</h1>");
		out.println("CTX_ARR1: "+val);
	}

	
	
}

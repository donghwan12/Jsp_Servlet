package Servlet.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tpye.Role;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username"); //다운캐스팅
		Role role=(Role)session.getAttribute("role"); //다운 캐스팅
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>MainPage</h1>");
		out.println("<div>Username:"+username+"</div>");
		out.println("<div>Role: "+role.name()+"</div>");
	}

}

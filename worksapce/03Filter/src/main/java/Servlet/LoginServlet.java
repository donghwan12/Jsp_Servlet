package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tpye.Role;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Servlet/login...");
		String method =req.getMethod();
		if(method.contains("GET")) {
			System.out.println("GET/login...");
			req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
			return;
		}
		
		//1 파라미터받기
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//2 유효성 체크
		if(!isValid(username,password)) {
			return ;
		}
		
		//3서비스실행
//		if(!username.equals("user1")) {
//			return ;
//		}
//		if(!password.equals("1234")) {
//			return;
//		}
		HttpSession session=req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("role", Role.ROLE_User); //로그인하는 역할을 부여한다
		
		//4
		resp.sendRedirect(req.getContextPath()+"/main");
				
	}

	private boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}

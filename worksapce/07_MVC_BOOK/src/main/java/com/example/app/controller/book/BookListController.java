package com.example.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;

public class BookListController  implements SubController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookListController's execute() invoke");
		
		try {
			
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(request, response);
				return ;
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기..or new ServletException("message") 처ㅣ
		}
		
	}

}

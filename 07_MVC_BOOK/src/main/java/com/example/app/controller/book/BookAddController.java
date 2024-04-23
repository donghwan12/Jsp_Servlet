package com.example.app.controller.book;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.commo.dao.common.ConnectionPool;
import com.example.app.domain.commo.dto.BookDto;
import com.example.app.domain.commo.service.BookService;
import com.example.app.domain.commo.service.BookServiceImpl;

public class BookAddController implements SubController{
	
	private BookService bookService;
	private ConnectionPool connectionPool;
	
	public BookAddController() {
		try {
			
			bookService=BookServiceImpl.getInstance();
			connectionPool=ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookAddController's execute() invoke ");
		
		try {
			
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/book/add.jsp").forward(request, response);
				return ;
			}
			
			//post 요청(etc method)
			//1
			
			//add.jsp에있는 요소들을 가져온다.
			String bookcode=request.getParameter("bookCode");
			String bookname=request.getParameter("bookName");
			String publisher=request.getParameter("publisher");
			String isbn=request.getParameter("isbn");
			
			//2 유효성체크
			if(!isValid(bookcode,bookname,publisher,isbn)) {
				return ;
			}
			
			//3
			BookDto bookdto=new BookDto(Integer.parseInt(bookcode),bookname,publisher,isbn);
			

			boolean isadded=bookService.bookRegister(bookdto);
			//4
			if(isadded) {
				//등록이 돼었다면
				response.sendRedirect(request.getContextPath()+"/book/list");
			}else {
				//등록실패
				request.getRequestDispatcher("WEB-INF/view/book/add.jsp").forward(request, response);
			}
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기..or new ServletException("message") 처리
			try {
				//롤백처리 
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	private boolean isValid(String bookcode, String bookname, String publisher, String isbn) {
		if(bookcode==null) {
			return false;
		}
		if(bookcode.isEmpty()) {
			return false;
		}
		if(bookname==null|| bookname.isEmpty()) {
			return false;
		}
		if(publisher==null|| publisher.isEmpty()) {
			return false;
		}
		
		return true;
	}
	

}
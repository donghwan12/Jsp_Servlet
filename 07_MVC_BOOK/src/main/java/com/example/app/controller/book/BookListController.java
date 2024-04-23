package com.example.app.controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.commo.dao.common.ConnectionPool;
import com.example.app.domain.commo.dto.Criteria;
import com.example.app.domain.commo.service.BookService;
import com.example.app.domain.commo.service.BookServiceImpl;

public class BookListController  implements SubController{

	private BookService bookService;
	private ConnectionPool connectionPool;
	
	public BookListController(){
		
		try {		
			bookService = BookServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookListController's execute() invoke");
		
		try {
			
			String method = request.getMethod();
			String type=request.getParameter("type");
			String keyword=request.getParameter("keyword");
			//1
			//1000건 -> 한페이지에 10건 -> 100페이지
			//PageNo : 1
			//Amount : 10건
			String pageNo =  request.getParameter("pageNo");
			
			Criteria criteria = null;
			if(pageNo==null) {  //페이지를 번호를 안받앗을때
				criteria = new Criteria(); //pageno=1 amount=10			
			}
			else { //페이지 번호를 받앗을때 
				if(type==null||keyword==null|| type.isEmpty() ||keyword.isEmpty()) { //페이지번호를 받았는데 tpye과 key코드를 아무것도 안받앗을댄
					criteria= new Criteria(Integer.parseInt(pageNo),10);
				}else {
					criteria = new Criteria(Integer.parseInt(pageNo),10,type,keyword); //pageno=1 amount=10
				}
			}
			
			
			//2
			
			//3
			Map<String,Object> returnValue =  bookService.getAllBooks(criteria);
			
			//4
			request.setAttribute("list", returnValue.get("list"));
			request.setAttribute("pageDto", returnValue.get("pageDto"));
			request.setAttribute("count", returnValue.get("count"));
			
			request.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(request, response);
							
		
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기..or new ServletException("message") 처ㅣ
		}
		
	}

}
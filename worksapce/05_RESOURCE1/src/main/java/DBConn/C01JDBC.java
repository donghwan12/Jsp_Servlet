package DBConn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbTEst_jdbc")
public class C01JDBC extends HttpServlet{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url;
	private String id;
	private String pw;
	
	//init
	@Override
	public void init() throws ServletException { //한번실행될떄 db연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 url="jdbc:mysql://localhost/bookdb"; //db에 연결할 url
			 id="root";
			 pw="1234";
			 conn = DriverManager.getConnection(url,id,pw);
			System.out.println("Connection conn:"+conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //mysql 경로
		
	}
	
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("DB Connection:"+conn);
	}

	
	//destroy
	//doget...
}

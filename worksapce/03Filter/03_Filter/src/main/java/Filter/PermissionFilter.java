package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Tpye.Role;

public class PermissionFilter implements Filter{

	
	// /user 	Role.Role_user
	// /admin  Roel.Role_MEMBER
	
	Map<String,Role>pageGradeMap=new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String path=filterConfig.getServletContext().getContextPath(); //경로를 꺼내와서 담아준다. 
		
		pageGradeMap.put(path+"/user",Role.ROLE_User);
		pageGradeMap.put(path+"/member",Role.ROLE_MEMBER);
		pageGradeMap.put(path+"/admin",Role.ROLE_ADMIN);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//전
		System.out.println("PermissionFilter Start");
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		
		Role userRole=(Role)session.getAttribute("role"); //session에 있는 role 을 꺼내와서 userRole에 담아준다,현재 접속 USER의 Role이다
		if(userRole==null) {//로그인을 할때 role 을 입력을안한경우
			throw new ServletException("익명계정으로는 접근이 불가합니다");
		}
		
		//계정 로그인을 한상태
		//PageGradeMap에서 어떤요청(/user,/member,/admin )이 있는지 확인을해서 해당 페이지 권한을 추출한다
		String reqURI=req.getRequestURI(); //URI 경로를 꺼내온다
		System.out.println("URI"+reqURI);
		Role pageRole=pageGradeMap.get(reqURI); //URI를꺼내와서 pageRole 에담아준다
		
		//접속계정:Role_USER(0), 요청페이지:Role_member(1),ROLE_ADMIN(2)
		if(userRole.ordinal()<pageRole.ordinal()) { //userRole에 저장되어있는 오디널 번호보다 접근하는 페이지가 더 높다면?
			throw new ServletException("해당권한으로는 접근이 불가합니다.");
		}
		
		
		chain.doFilter(request, response);		
		//후
		System.out.println("PermissionFilter end");
	}

}

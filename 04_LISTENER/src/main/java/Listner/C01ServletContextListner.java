package Listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C01ServletContextListner implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("C01ServletContextListner's contextInitialized...invoke");
		sce.getServletContext().setAttribute("CTX_ATTR1", "CTX_ATTR1_VALUE");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("C01ServletContextListner's contextDestroyed..invoke");
	}

}

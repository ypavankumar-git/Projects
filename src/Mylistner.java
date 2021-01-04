

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Mylistner
 *
 */
//@WebListener("/*")
public class Mylistner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Mylistner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Sesion created");
         se.getSession().setMaxInactiveInterval(20);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se,HttpServletResponse res )  { 
    	System.out.println("Sesion destroyed");
    	
    	

    }

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Sesion destroyed");
		
	}
	
}

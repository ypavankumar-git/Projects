

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Myfilter
 */
//@WebFilter("/*")
public class Myfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Myfilter() {
        System.out.println("Filter initialised");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpSession session=hrequest.getSession();
		if(session != null && !session.isNew()) {
			
			hrequest.getSession().removeAttribute("uname");
			hrequest.getSession().removeAttribute("upass");
			 
			HttpServletResponse hresponse=(HttpServletResponse)response;
			hresponse.sendRedirect("sessionexpiry");
		}
		else {
			chain.doFilter(request,response);
			System.out.println("perfect/////");}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

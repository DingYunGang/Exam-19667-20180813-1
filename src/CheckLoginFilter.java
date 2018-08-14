

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

import org.apache.catalina.User;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter("/CheckLoginFilter")
public class CheckLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
    	
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
         System.out.println("-------进入了过滤器-----------");
		HttpServletRequest request1 = (HttpServletRequest)request;  
	        HttpServletResponse response1 = (HttpServletResponse) response;  
	        User user = (User)request1.getSession().getAttribute("ABC");  
	        if(user==null){  
	            response1.sendRedirect(request1.getContextPath()+"/index.jsp"); 
	            return;  
	        }  
	        chain.doFilter(request,response);  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

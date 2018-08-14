

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(filterName = "Filter",urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public Filter() {
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
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse resp =(HttpServletResponse) response;
	    String Path = req.getServletPath();
	    
	    HttpSession  session = req.getSession();
	    String flag = (String) session.getAttribute("flag");
	    System.out.println(flag+"------");
	    if(Path != null && Path.equals("/login.jsp")|| (Path.equals("/index.jsp") ||
	    (Path.equals("/loginServlet")))) {
		chain.doFilter(request, response);
	    }else {
	    	if(flag != null &&flag.equals("login_success")) {
	    		chain.doFilter(request, response);
	    	}else if (flag != null &&flag.equals("login_error")) {
	    		req.setAttribute("msg", "µÇÂ½Ê§°Ü");
	    		req.setAttribute("return_uri", Path);
	    		RequestDispatcher rd =  req.getRequestDispatcher("/login.jsp");
	    		rd.forward(req, resp);
	    	}else {
	    		req.setAttribute("msg", "ÉÐÎ´µÇÂ½");
	    		req.setAttribute("return_uri", Path);
	    		RequestDispatcher rd =  req.getRequestDispatcher("/login.jsp");
	    		rd.forward(req, resp);
	    	}
	    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

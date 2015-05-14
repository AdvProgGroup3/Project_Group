package project;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class CheckedIn
 */
@WebFilter("/CheckedIn")
public class CheckedIn implements Filter {

    /**
     * Default constructor. 
     */
	private static String uri;
	private static String CHECKIN_REDIRECT="CHECKIN_REDIRECT";
    public CheckedIn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(request instanceof HttpServletRequest){
			HttpServletRequest req= (HttpServletRequest) request;
			uri=req.getRequestURI();
			HttpSession session= req.getSession(true);
			if((boolean)session.getAttribute("status")==true){
				req.setAttribute(CHECKIN_REDIRECT, uri);
				req.getRequestDispatcher("/CheckInPage").forward(request, response);
				
		
			}else{
				req.setAttribute(CHECKIN_REDIRECT, uri);
				req.getRequestDispatcher("/SpacesList").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

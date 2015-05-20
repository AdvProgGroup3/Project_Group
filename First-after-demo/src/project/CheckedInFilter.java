package project;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
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
@WebFilter("/CheckedInFilter")
public class CheckedInFilter implements Filter {

    /**
     * Default constructor. 
     */
//	private static String uri;
//	private static String CHECKIN_REDIRECT="CHECKIN_REDIRECT";
	private ServletContext context;
    public CheckedInFilter() {
        // TODO Auto-generated constructor stub
    }
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("CheckedInFilter initialized");
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
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        System.out.println(uri);
        
        System.out.println(uri.endsWith("SpacesList"));
//        System.out.println(uri.endsWith("CheckInServlet"));
       
        HttpSession session = req.getSession(false);
        try{
        	System.out.println("ini session "+ session.getAttribute("status"));
        }catch (Exception e){
        	System.out.println("ini session "+ session);
        }
        
        boolean status;
		// pass the request along the filter chain
        try{
        	status=(boolean)session.getAttribute("status");
        }catch(Exception e){
        	status=true;
        }

//
        	if((((session==null ) || (session!=null&& status==false))
        			&& !uri.endsWith("CheckInServlet"))){
        		 this.context.log("Unauthorized access request");
                 res.sendRedirect("CheckInServlet");
        	}else{
        		chain.doFilter(request, response);
        	}

        

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}

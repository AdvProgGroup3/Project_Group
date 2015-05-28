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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class CheckedIn
 */
@WebFilter("/CheckedOutFilter")
public class CheckedOutFilter implements Filter {

    /**
     * Default constructor. 
     */
//	private static String uri;
//	private static String CHECKIN_REDIRECT="CHECKIN_REDIRECT";
	private ServletContext context;
    public CheckedOutFilter() {
        // TODO Auto-generated constructor stub
    }
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("CheckedOutFilter initialized");
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
        String uri_long=req.getServletPath();
        this.context.log("Requested Resource::"+uri);
        System.out.println(uri);
//        System.out.println(uri.endsWith("SpacesList"));
        System.out.println(uri.endsWith("Checkin.jsp"));
        System.out.println(req.getParameter("areaId"));
//        Cookie[] cookies=req.getCookies();
//        for (int i=0;i<cookies.length;i++){
//        	System.out.println(cookies[i].getName());
//        	System.out.println(cookies[i].getValue());
//        }
        HttpSession session = req.getSession(false);
        try{
        	System.out.println("ini session Check out "+ session.getAttribute("status"));
        }catch (Exception e){
        	System.out.println("ini session Check out "+ session);
        }
        
		// pass the request along the filter chain

//
        
//        System.out.println(uri_long);
        
        
        boolean status;
        try{
        	status=(boolean) session.getAttribute("status");
        }catch (Exception e){
        	status=false;
        }
        	
        	if(((session!=null&& status==true)&&req.getParameter("areaId")==null
        			&& uri.endsWith("Checkin.jsp"))){
        		this.context.log("Unauthorized access request");
        		
                res.sendRedirect("CheckInServlet?areaId="+session.getAttribute("areaId"));
        	}else{
        		chain.doFilter(request, response);
        		
        	}
        	
        	
        	
    		
    		

        

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}

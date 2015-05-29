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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
 
    private ServletContext context;
     
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
         
        HttpSession session = req.getSession(false);
        System.out.println("session"+session);
        System.out.println("uri"+uri);
        String role=null;
        Cookie[] cookies=req.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals("role")) role = cookie.getValue();
			    
				}
			}
        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet")|| uri.endsWith("Register.jsp")
        		||uri.endsWith("RegisterSuccess.jsp"))){
            this.context.log("Unauthorized access request");
            res.sendRedirect("login.html");
        }else if(session!=null && !role.equals("admin")&& uri.endsWith("RegisterMaster.jsp")) {
        	this.context.log("Unauthorized access request");
            res.sendRedirect("LoginSuccess.jsp");
        	
        }else if(session!=null && uri.endsWith("Register.jsp")){
        	this.context.log("Unauthorized access request");
            res.sendRedirect("LoginSuccess.jsp");
        }else if(uri.indexOf("/css")>0 || uri.indexOf("/js")>0||uri.indexOf("/img")>0|| uri.indexOf("/fonts")>0||uri.indexOf("/less")>0){
        	chain.doFilter(request, response);
        }else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
         
         
    }
 
     
 
    public void destroy() {
        //close any resources here
    }
 
}
package booking;
// Import required java libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import project.DatabaseBridge;

// Extend HttpServlet class 
@WebServlet("/DisplayLocation")
public class DisplayLocation extends HttpServlet {
	private String areaId;
 
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException
	  {
	      // Do required initialization
	     
	  }

	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
	  {
	      // Set response content type
	      response.setContentType("text/html");
	      int userId=0;
	      String userName=null;
	      String sessionID=null;
	      Cookie[] cookies=request.getCookies();
	      if(cookies !=null){
				for(Cookie cookie : cookies){
				    if(cookie.getName().equals("user")) userName = cookie.getValue();
				    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
				    if(cookie.getName().equals("id")) userId=Integer.parseInt(cookie.getValue());
					}
				}
	      DatabaseBridge bridge=new DatabaseBridge(userId);
	      boolean check=bridge.check();
	      if(check){
	      
		      Control control=new Control(userId);
		      if(control.checkUserID()){
		    	  areaId=control.getAreaID();
		    	  request.setAttribute("areaId", areaId.toUpperCase());
		      }
		      
		      request.getRequestDispatcher("/BookingSuccess.jsp").forward(request, response);
	      }else{
	    	  response.sendRedirect("BookingServlet");
	      }
	      // Actual logic goes here.
	      
	  }
  
	  public void destroy()
	  {
	      // do nothing.
	  }
}
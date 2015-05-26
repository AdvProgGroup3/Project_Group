package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;



/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/SpacesList")
public class SpacesList extends HttpServlet {
//	private  int count=0;
	
//	private static String uri;
	private ServletContext context;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpacesList() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }
    public void init(ServletConfig config) throws ServletException{
		// TODO Auto-generated method stub
		super.init(config);
		this.context = config.getServletContext();
	    this.context.log("SpacesList initialized");
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String areaId=null;
		ShowParkingSpace showSpaces=null;
		
		String sessionID=null;
		String userName=null;
		int userId=0;
		
		Cookie[] cookies=request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals("user")) userName = cookie.getValue();
			    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			    if(cookie.getName().equals("id")) userId=Integer.parseInt(cookie.getValue());
			}
			}
		System.out.println("cookies "+userId);
		DatabaseParkingSpace dbSpace= new DatabaseParkingSpace(null, 0);
		dbSpace.setAction(Action.TOLIST);
		dbSpace.connect();
		Map p=dbSpace.getList();
//		response.setHeader("Refresh",areaId);
//		CheckInOrNot checkInOrNot= new CheckInOrNot(userId);
//		Cookie cookie= new Cookie("checkInOrNot",String.valueOf(checkInOrNot.getCheckInOrNot()));
//		response.addCookie(cookie);
		response.setContentType("text/html");
//		HttpSession session= request.getSession(true);
//		session.setAttribute("user_id", userId);
//		session.setAttribute("checkInStatus", false);
//		session.setAttribute("areaId", null);
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
//	    PrintWriter out = response.getWriter();
//		uri=request.getRequestURI();
//		session.setAttribute("URI_LISTS", uri);
//		session.setAttribute("status", null);
//		if(session.getAttribute("status")==null || (boolean)session.getAttribute("status")==true){
//		session.setAttribute("status", false);
		
		
//		showSpaces=new ShowParkingSpace(userId);
//		Map p=(Map) showSpaces.getList();
		System.out.println("ss2"+p);
	   
	    
//	     Object data="<form action=CheckInServlet method=GET >"
//	     		+ "<a class='list-group-item active'><span class='badge'>"+p.size()+"</span>SPACES</a>";
	     		
	     request.setAttribute("size", p.size());
	     for (int i=0; i<=12;i++){
	    	 try{
				String front="a";
				if(i<10){
					front+="0";
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						System.out.println(front+": "+p.get(front));
						request.setAttribute(front, front);
					}
					
				}
				else{
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						System.out.println(front+": "+p.get(front));
						request.setAttribute(front, front);
					}
				}
			} catch(Exception e){
				
			}
	     }
//	     	request.setAttribute("count", count);
//	    	request.setAttribute("session", session);
//		    request.setAttribute("data", data);
		    request.getRequestDispatcher("/Checkin.jsp").forward(request, response);

//		} else{
//			try{
//				response.sendRedirect((String)session.getAttribute("URI_CHECKIN"));
//			}catch (Exception e){
//				System.out.println("ga ada urinya" +e);
//			}
//		}
		
			 
//			 request.setAttribute("data", data);
//			 request.getRequestDispatcher("/Checkin.jsp").forward(request, response);
		
	     
	     
	     
	     	     

	}
	public void destroy(){
		super.destroy();
	
//		count=0;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

}


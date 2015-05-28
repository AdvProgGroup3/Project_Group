package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
@WebServlet("/CheckInServlet")
public class CheckInServlet extends HttpServlet {
//	private  int userId=0;
//	private  int count;
	private String areaId=null;
//	private static ShowParkingSpace showSpaces;
	private static CheckInData checkInData=null;
	private static CheckIn checkIn=null;
//	private static String uri;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInServlet() {
        super();
        // TODO Auto-generated constructor stub
//        showSpaces=new ShowParkingSpace(userId);
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		System.out.println("cookies "+userId);
		
		HttpSession session= request.getSession(true);
//		if((boolean)session.getAttribute("status")==false){
		areaId=request.getParameter("areaId");
//		uri= request.getRequestURI();
//		session.setAttribute("URI_CHECKIN",uri);
		request.setAttribute("areaId", areaId);
		checkInData=new CheckInData(userId, Area.valueOf(areaId.toUpperCase()));
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
//	    PrintWriter out = response.getWriter();
//		
		
		
		checkIn=new CheckIn(checkInData);
		String fill=checkIn.getFill(); //status sebelom msk
		boolean status=checkIn.checkIn();
 		
// 		boolean checkInOrNot=checkIn.getCheckInOrNot();
// 		Cookie cookie=new Cookie("checkInOrNot",String.valueOf(checkInOrNot));
// 		response.addCookie(cookie);
 		System.out.println("F"+fill);
 		System.out.println("brp:"+checkIn.getWarn().size());
 		Object data;
 		
 		if(fill.equals("empty")&& checkIn.getWarn().size()==0){
 			
 			data="<form action=CheckOutServlet method=GET >";
	    		

 			data+="<div class='list-group-item'>" 
 					+ "<br/>"
 					+ "<br/>"
 					+ "<button type='submit' class='btn btn-info' name='areaId' value='"+areaId+"'>Check Out</button>"
 					+ "</div>";
 			session.setAttribute("object", checkIn);
     		session.setAttribute("status", true);
     		session.setAttribute("areaId", areaId);
     		request.setAttribute("session", session);
     		request.setAttribute("data", data);
     		checkIn.setStatus(true);
 		    request.getRequestDispatcher("/Checkout.jsp").forward(request, response);
	     		
	    		
 		} else if(fill.equals("fill")) {
 			checkIn.setStatus(false);
 			response.setHeader("fillInMessage", "This place has been used");
// 			checkIn.setStatus(true);
// 			session.setAttribute("object", checkIn);
 			response.sendRedirect("CheckOutServlet");
 			
 		}else if(fill.equals("empty")&&!areaId.equals(checkIn.getWarn().get("areaId"))){
 			checkIn=new CheckIn(new CheckInData(userId, Area.valueOf(checkIn.getWarn().get("areaId").toString().toUpperCase())));
 			checkIn.setStatus(true);
 			data="<form action=CheckOutServlet method=GET >";
    		

 			data+="<div class='list-group-item'>"
 					+ "<br/>"
 					+ "<br/>"
 					+ "You have checked in. Go check out first!" 
 					+ "<br/>"
 					+ "<br/>"
 					+ "<button type='submit' class='btn btn-info' name='areaId' value='"+checkIn.getWarn().get("areaId")+"'>Check Out</button>"
 					+ "</div>";
 			
 			session.setAttribute("object", checkIn);
     		session.setAttribute("status", true);
     		session.setAttribute("areaId", areaId);
     		request.setAttribute("session", session);
     		request.setAttribute("data", data);
 		    request.getRequestDispatcher("/Checkout.jsp").forward(request, response);
 		}
	     		
	     		
	     		
	     		
	     		

	     
	     
	     
//		}   else{
//				try{
//					response.sendRedirect((String)session.getAttribute("URI_LISTS"));
//				}catch (Exception e){
//					System.out.println("ga ada urinya" +e);
//			}
//		}
	     
	     

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//	public void init(ServletConfig config) throws ServletException{
//		// TODO Auto-generated method stub
//		super.init(config);
//		String initial=config.getInitParameter("initial");
//		try{
//			count=Integer.parseInt(initial);
//		}catch (Exception e){
//			count=0;
//		}
////		showSpaces=null;
//		uri=null;
//		areaId=null;
//		checkInData=null;
//	}

}


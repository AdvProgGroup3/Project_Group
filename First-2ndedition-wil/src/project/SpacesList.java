package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	private  int userId=0;
	private String areaId;
	private static ShowParkingSpace showSpaces;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpacesList() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setHeader("Refresh",areaId);
		
		response.setContentType("text/html");
		HttpSession session= request.getSession(true);
//		session.setAttribute("user_id", userId);
//		session.setAttribute("checkInStatus", false);
//		session.setAttribute("areaId", null);
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
//	    PrintWriter out = response.getWriter();
		
		session.setAttribute("status", null);
		if(session.getAttribute("status")==null || (boolean)session.getAttribute("status")==true){
			session.setAttribute("status", false);
		try{
			if(request.getParameter("areaId")!=null)
				areaId=request.getParameter("areaId");
			else
				areaId=null;
		} catch(Exception e){
			areaId=null;
		}
		
		if(areaId!=null){
			CheckIn x=(CheckIn) session.getAttribute("object");
			boolean status= x.checkOut();
			session.setAttribute("status", status);
		}
		showSpaces=new ShowParkingSpace(userId);
	     Map p= (Map) showSpaces.getList().get(0);
	    
	     Object data="<form action=CheckInPage method=GET >"
	     		+ "<a class='list-group-item active'><span class='badge'>"+p.size()+"</span>SPACES</a>";
	     		

	     for (int i=0; i<=12;i++){
	    	 try{
				String front="a";
				if(i<10){
					front+="0";
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						
						data+="<div class='list-group-item'>" 
								+ "Area ID: "+front+"<br/></br>"
								+ "Status: Empty"
								+ "<br/>"
								+ "<br/>"
								+ "<button type='submit' name='areaId' value='"+front+"'>Check In</button>"
								+ "</div>";
					}
					
				}
				else{
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						
						data+="<div class='list-group-item'>" 
								+ "Area ID: "+front+"<br/></br>"
								+ "Status: Empty"
								+ "<br/>"
								+ "<br/>"
								+ "<button type='submit' name='areaId' value='"+front+"'>Check In</button>"
								+ "</div>";
					}
				}
			} catch(Exception e){
				
			}
	     }
	    
	    	
		    request.setAttribute("data", data);
		    request.getRequestDispatcher("/Checkin.jsp").forward(request, response);

		} 
		
			 
//			 request.setAttribute("data", data);
//			 request.getRequestDispatcher("/Checkin.jsp").forward(request, response);
		
	     
	     
	     
	     	     

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void destroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


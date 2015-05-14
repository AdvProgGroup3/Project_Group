package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/CheckInPage")
public class CheckInPage extends HttpServlet {
	private  int userId=0;
	private String areaId;
	private static ShowParkingSpace showSpaces;
	private static CheckInData checkInData;
	private static CheckIn checkIn;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInPage() {
        super();
        // TODO Auto-generated constructor stub
        showSpaces=new ShowParkingSpace(userId);
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		
		HttpSession session= request.getSession(true);
		if((boolean)session.getAttribute("status")==false){
		areaId=request.getParameter("areaId");
		request.setAttribute("areaId", areaId);
		checkInData=new CheckInData(userId, Area.valueOf(areaId.toUpperCase()));
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
//	    PrintWriter out = response.getWriter();
//		
	    Object data="<form action=SpacesList method=GET >";
	    		

	    data+="<div class='list-group-item'>" 
				+ "<br/>"
				+ "<br/>"
				+ "<button type='submit' name='areaId' value='"+areaId+"'>Check Out</button>"
				+ "</div>";
	     		
	    		
	     		checkIn=new CheckIn(checkInData);
	     		boolean status=checkIn.checkIn();
	     		
	     		session.setAttribute("object", checkIn);
	     		session.setAttribute("status", status);
	     		request.setAttribute("data", data);
	 		    request.getRequestDispatcher("/Checkout.jsp").forward(request, response);
	     		
	     		

	     
	     
	     
		}   
	     
	     

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}


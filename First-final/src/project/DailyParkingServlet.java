package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DailyParkingServlet
 */
@WebServlet("/DailyParkingServlet")
public class DailyParkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyParkingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String date = (String) request.getParameter("date");
	    DailyParking test = new DailyParking();
	    ArrayList hasil = test.DailyParkingM(date);
	    Object data = "";
//	   for i in hasil:
//		   <tr>
//		   for j in i:
//			 <td>j</td>  
//		   </tr>
	    
	    request.setAttribute("date", date);
	    
	    System.out.println(hasil);
	    for(int i=0; i<hasil.size(); i++){
	    	data+="<tr>";
	    	ArrayList list2=(ArrayList) hasil.get(i);
	    	System.out.println(list2);
	    	for(int j=0; j<list2.size();j++){
	    		data+="<td>"
	    				+ list2.get(j)+"</td>";
	    	}
	    	data+="</tr>";
	    }
	    	System.out.println(data);
	    	request.setAttribute("data",data);
	    	request.getRequestDispatcher("/daily.jsp").forward(request, response);
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}



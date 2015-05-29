package booking;
import project.*;

import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.JSObjectListAdapter;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		DatabaseBridge bridge= new DatabaseBridge(userId);
		boolean check=bridge.check();
		if(!check){
			DatabaseParkingSpace dbSpace= new DatabaseParkingSpace(null, 0);
			dbSpace.setAction(Action.TOLIST);
			dbSpace.connect();
			Map p=(Map)dbSpace.getList();
			System.out.println(p);
			Collection set= new HashSet() ;
			Collection set2= new HashSet();
			for (int i=1; i<=12; i++){
				String a="a";
				if(i<10){
					a+="0";
					
					set.add("'"+a+i+"'");
					if(p.containsKey(a+i) && (int)p.get(a+i)==0)
						set2.add("'"+a+i+"'");
				}else{
					set.add("'"+a+i+"'");
					if(p.containsKey(a+i)&& (int)p.get(a+i)==0)
						set2.add("'"+a+i+"'");
				}
			}
			System.out.println(set);
			System.out.println(set2);
			System.out.println(set.removeAll(set2));
			System.out.println(set);
			
			ArrayList<String> list=new ArrayList<String>(set);
			Object lists=list;
			System.out.println(lists);
			request.setAttribute("data", p);
			request.setAttribute("data2", lists);
			request.getRequestDispatcher("booking.jsp").forward(request, response);
		}else{
			response.sendRedirect("DisplayLocation");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

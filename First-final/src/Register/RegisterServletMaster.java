package Register;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;



/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/RegisterServletMaster")
public class RegisterServletMaster extends HttpServlet {
	private static String username;
	private static String password;
	private static int npm;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServletMaster() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
//	    PrintWriter out = response.getWriter();
		int userId=0;
		String userName=null;
		String sessionID=null;
		String role=null;
		
		Cookie[] cookies=request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals("user")) userName = cookie.getValue();
			    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			    if(cookie.getName().equals("id")) userId=Integer.parseInt(cookie.getValue());
			    if(cookie.getName().equals("role")) role=cookie.getValue();
				}
			}
		if(role.equals("admin")){
		
		    npm = Integer.parseInt((String) request.getParameter("inputnpm"));
		    password = (String) request.getParameter("inputpassword");
		    username = (String) request.getParameter("inputusername");
		    
		    RegisterTest test = new RegisterTest();
		    test.setOrder("master");
		    boolean tReg=test.Register(username, password, npm);
		     
		    if (tReg){
		    	request.getRequestDispatcher("/RegisterSuccessMaster.jsp").forward(request, response);
		    }else{
		    	request.getRequestDispatcher("/RegisterFailedMaster.jsp").forward(request, response);
		    }
		}else{
			response.sendRedirect("LoginSuccess.jsp");
		}
		
//	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}


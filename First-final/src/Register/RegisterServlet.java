package Register;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;



/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static String username;
	private static String password;
	private static int npm;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	    
	    npm = Integer.parseInt((String) request.getParameter("inputnpm"));
	    password = (String) request.getParameter("inputpassword");
	    username = (String) request.getParameter("inputusername");
	    
	    RegisterTest test = new RegisterTest();
	    test.setOrder("normal");
	    boolean tReg=test.Register(username, password, npm);
	     
	    if (tReg){
	    	request.getRequestDispatcher("/RegisterSuccess.jsp").forward(request, response);
	    }else{
	    	request.getRequestDispatcher("/RegisterFailed.jsp").forward(request, response);
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


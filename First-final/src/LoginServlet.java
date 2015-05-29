
 
import java.io.IOException;
import java.io.PrintWriter;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost/adprog";
    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";
    private static int id=0;

		
		public static boolean login(String uname,String pass) 
		{
			Connection conn = null;
			Statement stmt = null;
			try{
				//STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				//STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");


				//STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();

		
		String sql3 = "SELECT * FROM Membership WHERE username='"+uname+"';" ;
		ResultSet rs= stmt.executeQuery(sql3);
		String password = null;
		
		
		while(rs.next())
		{
				password = rs.getString("password");
				id=rs.getInt("id");
		}
		
		if(password!=null)
		{
			if(password.equals(pass))
			{
				System.out.println("Log In Successfully");
				return true;
			}
			
			else
			{
				System.out.println("Your password is incorrect");
				
			}
		}
		else
		{
			System.out.println("Your username is unregistered yet");
			
		}	


	}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		System.out.println("Do not connect to DB - Error: " + e);
	}finally{
		//finally block used to close resources
		try{
			if(stmt!=null)
				conn.close();
		}catch(SQLException se){
		}// do nothing
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}//end finally try
	}//end try
	System.out.println("Goodbye!");
	return false; 
    }
		
	public static List getRoleFaculty(String uname) 
		{
			Connection conn = null;
			Statement stmt = null;
			try{
				//STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				//STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");


				//STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();

		
		String sql3 = "SELECT * FROM faculty_database WHERE username='"+uname+"';" ;
		ResultSet rs= stmt.executeQuery(sql3);
		String role = null;
		String faculty=null;
		
		while(rs.next())
		{
				role = rs.getString("role");
				faculty=rs.getString("faculty");
//				id=rs.getInt("id");
		}
		
		if(role!=null && faculty!=null)
		{
			List roleFaculty= new ArrayList();
			roleFaculty.add(role);
			roleFaculty.add(faculty);
			return roleFaculty;
			
		}
		else
		{
			System.out.println("Your username is unregistered yet");
			
		}	


	}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		System.out.println("Do not connect to DB - Error: " + e);
	}finally{
		//finally block used to close resources
		try{
			if(stmt!=null)
				conn.close();
		}catch(SQLException se){
		}// do nothing
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}//end finally try
	}//end try
	System.out.println("Goodbye!");
	return null;
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        
         
        if(login(user,pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //setting session to expiry in 30 mins
            List role=getRoleFaculty(user);
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            Cookie userId= new Cookie("id", Integer.toString(id));
            Cookie roleC= new Cookie("role", (String) role.get(0));
            Cookie faculty=new Cookie("faculty", (String) role.get(1));
            roleC.setMaxAge(30*60);
            userId.setMaxAge(30*60);
            userName.setMaxAge(30*60);
            faculty.setMaxAge(30*60);
            response.addCookie(userName);
            response.addCookie(userId);
            response.addCookie(roleC);
            response.addCookie(faculty);
            response.sendRedirect("LoginSuccess.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
 
    }
 
}
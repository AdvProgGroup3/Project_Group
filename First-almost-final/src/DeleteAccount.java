

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			String username=(String) request.getParameter("inputusername");
			
			
			if(username!=null){
				DatabaseDelete dbDelete=new DatabaseDelete();
				List list= (List)dbDelete.search(username);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/DeleteAccount.jsp").forward(request, response);
			}
			try{
				String deleteId=(String)request.getParameter("deleteId");
				if(deleteId!=null){
					DatabaseDelete dbDelete=new DatabaseDelete();
					dbDelete.delete(Integer.parseInt(deleteId));
					response.sendRedirect("DeleteAccount.jsp");
				}
			}catch (Exception e){
				
			}
		}else{
			response.sendRedirect("LoginSuccess.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

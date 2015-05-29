import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class DatabaseDelete {
	private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost/adprog";
    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";
    private static int id=0;

		
	public static List search(String uname) 
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
				

		
		String sql3 = "SELECT * FROM Membership inner join faculty_database on membership.npm=faculty_database.npm WHERE membership.username Like'%"+uname+"%' or faculty_database.faculty Like '%"+uname+"%';" ;
		
		ResultSet rs= stmt.executeQuery(sql3);
		String username = null;
		int id;
		String faculty=null;
		ArrayList list=new ArrayList();
		
		while(rs.next())
		{
				ArrayList list2= new ArrayList();
				id=rs.getInt("membership.id");
				username = rs.getString("membership.username");
				faculty=rs.getString("faculty_database.faculty");
				list2.add(id);
				list2.add(username);
				list2.add(faculty);
				list.add(list2);
				
				
		}
		return list;
		
			


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
	
	public static boolean delete(int id) 
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

	
		String sql3 = "DELETE  FROM Membership WHERE id="+id ;
		stmt.executeUpdate(sql3);
		return true;
			
	
	
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
	
}

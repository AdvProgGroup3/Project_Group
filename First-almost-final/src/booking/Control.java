package booking;
import java.sql.*;


public class Control {
	int User_id;
	String Area_id = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/adprog";

    //  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	  
	Connection conn = null;
	Statement stmt = null;
	
	public Control(int User_id){
		this.User_id = User_id;
	}
	
	public boolean checkUserID(){
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
		      System.out.println("Chekin User_ID into database...");

		      String sql = "SELECT user_id FROM booking";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int u_id = rs.getInt("user_id");
		         if (u_id == User_id){
		        	 rs.close();
		        	 System.out.println("User_id found in Database");
		        	 System.out.println("Disconnecting Database...");
		        	 return true;
		         }
		      }
		      rs.close();
		      System.out.println("User_id didn't found in Database");
		      System.out.println("Disconnecting Database...");
		      return false;
		      
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
	  	}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
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
	
	public String getAreaID(){
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
		      
		      System.out.println("Finding Area_id in database with the current user_id...");
		      String sql = "SELECT area_id FROM booking WHERE user_id ="+User_id;
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         Area_id = rs.getString("area_id");
		         
		      }
		      System.out.println("Disconnecting Database...");
		      rs.close();
		      return Area_id;
		      
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
	  	}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
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
	return "";
	}
}


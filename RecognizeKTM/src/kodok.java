import java.sql.*;

public class kodok {
	private int NPM;
	
	public kodok(int NPM){
		this.NPM = NPM;
	}
	
	public boolean checkNPM(){
		String NewNPM = "" + NPM;
		if (NewNPM.length() != 10){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean validationNPM(){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost/adprog";

	    //  Database credentials
		final String USER = "root";
		final String PASS = "";
		  
		Connection conn = null;
		Statement stmt = null;
		String username = null;
		
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

		      String sql = "SELECT username FROM membership WHERE npm="+NPM+";";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         username = rs.getString("username");
		         if (username.isEmpty()){
		        	 rs.close();
		        	 System.out.println("NPM didn't found in Database");
				     System.out.println("Disconnecting Database...");
				     return false;
		        	 
		         }
		      }
		      rs.close();
		      System.out.println("NPM found in Database");
		      System.out.println("WELCOME "+ username);
		      System.out.println("Disconnecting Database...");
		      return true;
		      
		      
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
}

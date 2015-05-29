package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;



public class DailyParking {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/adprog";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String date = "2015-05-18";
//		
//		DailyParkingM(date);
//	}


	public static ArrayList DailyParkingM(String date) {

		Connection conn = null;
		Statement stmt = null;
		ArrayList result;

		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");


			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql2 = "SELECT * FROM parking_lot WHERE DATE(`check_in_time`) = DATE('"+date+"')";
			ResultSet rs = stmt.executeQuery(sql2);
			
			result = extract(rs);


		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			return null;
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			System.out.println("Do not connect to DB - Error: " + e);
			return null;
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
				return null;
			}// do nothing
			try{
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
				return null;
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		return result;
	}//end Register
	
	private static ArrayList extract(ResultSet rs){
		ArrayList list=new ArrayList();
		try{
			while(rs.next()){
				ArrayList list2=new ArrayList();
				list2.add(rs.getString("area_id"));
				list2.add(rs.getInt("user_id"));
				list2.add(rs.getTimestamp("check_in_time"));
				list2.add(rs.getTimestamp("check_out_time"));
				list.add(list2);
			}
		}catch(Exception e){
			
			}
		return list;
		
	}
}

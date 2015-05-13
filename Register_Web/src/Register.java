//STEP 1. Import required packages
import java.sql.*;
import java.util.*;

public class Register {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/adprog";

	//  Database credentials
	private static final String USER = "root";
	private static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
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
			//
			//      String sql = "SELECT titel, interpret, jahr, id FROM cds";
			//      ResultSet rs = stmt.executeQuery(sql);
			//      
			//      //STEP 5: Extract data from result set
			//      while(rs.next()){
			//         //Retrieve by column name
			//         int id  = rs.getInt("id");
			//         String titel = rs.getString("titel");
			//         String interpret = rs.getString("interpret");
			//         int jahr = rs.getInt("jahr");
			//
			//         //Display values
			//         System.out.print("ID: " + id);
			//         System.out.print(", titel: " + titel);
			//         System.out.print(", interpret: " + interpret);
			//         System.out.println(", jahr: " + jahr);
			//      }
			//      rs.close();

			Scanner apa = new Scanner(System.in);
			String uname = "";
			String pass = "";
			String npm = "";
			do{
				System.out.print("Insert your Username: ");
				uname = apa.nextLine();
			}while(!uname.matches("[a-zA-Z0-9-_]+"));

			do{
				System.out.print("\nInsert your Password: ");
				pass = apa.nextLine();
			}while(!pass.matches("[a-zA-Z0-9-_]+"));

			do{
				System.out.print("\nInsert your NPM: ");
				npm = apa.nextLine();
			}while(!(npm.length()==10) && !pass.matches("[0-9]+"));

			apa.close();

			String sql2 = "INSERT INTO membership(username, password, npm) VALUES('"+ uname +"','" +pass+ "',"+Integer.parseInt(npm)+")";
			stmt.executeUpdate(sql2);


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
	}//end main
}//end JDBCExample
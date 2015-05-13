import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class test1 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/AdProg";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner apa = new Scanner(System.in);
		String uname = "";
		String pass = "";
		String npm = "";
		do{
			System.out.print("Insert your Username: ");
			uname = apa.nextLine();
		}while(!uname.matches("[a-zA-Z0-9-_.,]+"));

		do{
			System.out.print("\nInsert your Password: ");
			pass = apa.nextLine();
		}while(!pass.matches("[a-zA-Z0-9-_]+"));

		do{
			System.out.print("\nInsert your NPM: ");
			npm = apa.nextLine();
//			System.out.print(!(npm.length()==10) && !pass.matches("[0-9]+"));
		}while(!(npm.length()==10) || !pass.matches("[0-9]+"));

		apa.close();
		
		Register(uname, pass, Integer.parseInt(npm));
	}


	public static void Register(String uname,String pass,int npm) {

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

			String sql2 = "INSERT INTO Membership(username, password, npm) VALUES('"+ uname +"','" +pass+ "',"+npm+")";
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
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end Register
}

package project;

//STEP 1. Import required packages
import java.sql.*;
import java.util.Date;

public class DatabaseParkingSpace {
// JDBC driver name and database URL
private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
private static final String DB_URL = "jdbc:mysql://localhost/adprog";
//private ArrayList areaList= new ArrayList();
//  Database credentials
private static final String USER = "root";
private static final String PASS = "";
// Database data prompting result
private static  int data=0;
private static  Area areaID;
// Database action task
private static Action action;

public DatabaseParkingSpace(Area areaID, int data){
	this.areaID=areaID;
	this.data=data;
}

public   void setData(int data2){
	this.data=data2;
}
public  void setArea(Area area){
	this.areaID=area;
}
public int getData(){
	return data;
}

public static void setAction(Action action2){
	action=action2;
}
//public static String add(){
////	Statement stmt = null;
////	stmt = conn.createStatement();
//	String sql;
//	sql = "INSERT INTO parking_lot (area_id,user_id,check_out_time)"
//	  		+ " VALUES('"+data.getAreaId()+"',"+data.getId()+",NULL)";
//	return sql;
//}
private static String update(){
	String sql;
//	Date date=new Date();
//	System.out.println(new Timestamp(date.getTime()));
	
	
	sql = "UPDATE parking_space set availability="+data
	  		+ " WHERE(area_id='"+areaID+"')";
	return sql;
}
private static String select(){
	String sql;
	sql = "SELECT availability FROM parking_space where area_id='"+areaID+"'";
	return sql;
}
private static int processQuery(ResultSet rs){
	try {
		while(rs.next()){
			System.out.println("a"+rs.getInt("availability"));
			return rs.getInt("availability");
		
		}	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return 0;
}





public  void connect () {
Connection conn = null;
Statement stmt = null;


try{
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
  System.out.println("Connecting to database...");
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

  //STEP 4: Execute a query
  System.out.println("Creating statement...");
  stmt = conn.createStatement();

  String sql;

   if(action==Action.UPDATE){
	
		  sql = update();
		  stmt.executeUpdate(sql);
	  
  }else if(action==Action.SELECT){
	  sql=select();
	  ResultSet rs=stmt.executeQuery(sql);
	  int dataNum=processQuery(rs);
	  setData(dataNum);
  }

  else{
	  //Database action is not recognized
	  //Don't execute anything!
	  sql=null;
  }
  

  
//
//  //STEP 5: Extract data from result set
//  while(rs.next()){
//     //Retrieve by column name
//     int id  = rs.getInt("id");
//     int age = rs.getInt("jahr");
//     String first = rs.getString("interpret");
//     String last = rs.getString("titel");
//
//     //Display values
//     System.out.print("ID: " + id);
//     System.out.print(", Year: " + age);
//     System.out.print(", interpret: " + first);
//     System.out.println(", titel: " + last);
//  }
  //STEP 6: Clean-up environment
//  rs.close();
  stmt.close();
  conn.close();
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
        stmt.close();
  }catch(SQLException se2){
  }// nothing we can do
  try{
     if(conn!=null)
        conn.close();
  }catch(SQLException se){
     se.printStackTrace();
  }//end finally try
}//end try
System.out.println("Goodbye!");

	}//end main
}//end FirstExample

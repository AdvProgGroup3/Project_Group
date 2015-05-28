package project;

//STEP 1. Import required packages
import java.sql.*;
import java.util.*;
import java.util.Date;
import booking.*;


public class DatabaseParkingLot {
// JDBC driver name and database URL
private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
private static final String DB_URL = "jdbc:mysql://localhost/adprog";
//private ArrayList areaList= new ArrayList();
//  Database credentials
private static final String USER = "root";
private static final String PASS = "";
// Database data prompting result
private static CheckInData data=null;
private static int status;
private static boolean checkInOrNot;
//private static boolean stranger; //if true there is other people on that spot
private static Map warn;
// Database action task
private static Action action;

public DatabaseParkingLot(CheckInData data,int status){
	this.data=data;
	this.status=status;
	this.warn=new HashMap();
			
}

public  void setData(CheckInData data){
	this.data=data;
}

public static void setAction(Action action2){
	action=action2;
}
public  void setStatus(int status){
	this.status=status;
}
//public  boolean getStranger(){
//	
//	return stranger;
//}

private static String add(){
//	Statement stmt = null;
//	stmt = conn.createStatement();
	String sql;
	sql = "INSERT INTO parking_lot (area_id,user_id,check_out_time)"
	  		+ " VALUES('"+data.getAreaId()+"',"+data.getId()+",NULL)";
	return sql;
}
private static String update(){
	String sql;
	Date date=new Date();
	System.out.println(new Timestamp(date.getTime()));
	
	
	sql = "UPDATE parking_lot set check_out_time='"+new Timestamp(date.getTime())
	  		+ "' WHERE(check_out_time is NULL and area_id='"+data.getAreaId()+"' and user_id="+data.getId()+")";
	System.out.println("sql");
	return sql;
}
private static String select(){
	String sql;
	sql = "SELECT * FROM parking_lot ";
	return sql;
}

private static String selectNull(){
	String sql;
	sql = "SELECT * FROM parking_lot where user_id="+data.getId()+" and check_out_time is NULL";
	return sql;
}
private static String extractNull(ResultSet rs){
	try {
		String areaId = null;
		while(rs.next()){
			areaId=rs.getString("area_id");
			
			
		}
		return areaId;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

private static String selectAvailable(){
	String sql;
	sql =  "SELECT * FROM parking_lot where area_id='"+data.getAreaId()+"' and check_out_time is NULL";
	return sql;
}

private static boolean nullChecker(ResultSet rs){
	
	try {
		rs.last();
		int size= rs.getRow();
		rs.beforeFirst();
		
		if(size!=0){
			return true;
		}
		else {
			return false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
private static boolean firstTime(ResultSet rs){
	try {
		while(rs.next()){
			int id=rs.getInt("user_id");
			if(id==data.getId())
				return true;
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
//private static String searchOtherUsers(){
//	String sql= "SELECT * FROM parking_lot where (check_out_time is NULL and user_id!="
//			+ data.getId()+" and area_id='"+data.getAreaId()
//			+"'" ;
//	return sql;
//	
//}
	
	
	
	
	
	
	       
public boolean getCheckInOrNot(){
	return checkInOrNot;
}
public Map getWarn(){
	return warn;
}



public static void connect () {
Connection conn = null;
Statement stmt = null;
Statement stmt2 = null;
Statement stmt3 = null;

try{
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
  System.out.println("Connecting to database...");
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

  //STEP 4: Execute a query
  System.out.println("Creating statement...");
  stmt = conn.createStatement();
  stmt2= conn.createStatement();
  stmt3= conn.createStatement();
  String sql;
  String sql2;
  String sql3;
  if(action==Action.INSERT){
	  sql=select();
	  sql2=selectAvailable();
	  sql3=selectNull();
	  ResultSet res=stmt.executeQuery(sql3);
	  ResultSet res2=stmt2.executeQuery(sql2);
	  ResultSet res3=stmt3.executeQuery(sql2);
	  boolean x=nullChecker(res);
	  boolean y=firstTime(res3);

	  res2.last(); 
	  int size = res2.getRow(); 
	  res2.beforeFirst();
	  System.out.println(x);
	  
	  System.out.println(size);
	  res2.close();
	  if(size==0 && (status==0||status==2) && x==false){
		  try{
			  Book book=new Book();
			  sql=add();
			  stmt.executeUpdate(sql);
			  book.delete(conn, data.getAreaId(), data.getId());
			  System.out.println("checked in");
			  
//			  checkInOrNot=true;
			  
		  }catch(Exception e){
			  System.out.println(e);
//			  checkInOrNot=false;
		  }
	  }

	  else{
		  sql=selectNull();
		  ResultSet rs=stmt.executeQuery(sql);
		  String areaIdNew= extractNull(rs);
		  warn.put("areaId",areaIdNew);
		  warn.put("status", status);
		  warn.put("userId",data.getId());
		  warn.put("message", "");
		  System.out.println("You have checked in or it has been used");
	  }
  }
  else if(action==Action.UPDATE && status==0 ){
	  	try{
		  sql = update();
		  stmt.executeUpdate(sql);
//		  checkInOrNot=false;
	  	} catch(Exception e){
	  		System.out.println(e);
//	  		checkInOrNot=true;
	  	}
	  
  }else if(action==Action.CHECKINORNOT){
	  sql=selectNull();
	  ResultSet rs=stmt.executeQuery(sql);
	  rs.last();
	  int numRow= rs.getRow();
	  rs.beforeFirst();
	  if(numRow!=0){
		  checkInOrNot=true;
	  }else{
		  checkInOrNot=false;
	  }
	  
  }//else if(action==Action.OTHERUSER){
//	  sql=searchOtherUsers();
//	  ResultSet rs= stmt.executeQuery(sql);
//	  rs.last();
//	  int numRow=rs.getRow();
//	  if(numRow!=0){
//		  stranger=true;
//	  }else{
//		  stranger=false;
//	  }
//	  
//  }

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
  stmt2.close();
  stmt3.close();
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

package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import booking.*;
public class DatabaseBridge {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/adprog";
	//private ArrayList areaList= new ArrayList();
	//  Database credentials
	private static final String USER = "root";
	private static final String PASS = "";
	private int userId;
	private String areaId;
	public DatabaseBridge(int userId){
		this.userId=userId;
		
	}
	public int getId(){
		return userId;
	}
	public String getAreaId(){
		return areaId;
	}
	public  boolean check(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/adprog","root","");
			Book book= new Book();
			boolean check=book.selfCheck(myConn, userId);
			areaId= book.getAreaId(myConn, userId);
			DatabaseParkingSpace dbSpace=new DatabaseParkingSpace(null, 0);
			dbSpace.setAction(Action.TOLIST);
			dbSpace.connect();
			System.out.println(areaId);
			Map list= (Map)dbSpace.getList();
			System.out.println(list);
			boolean check2=list.containsKey(areaId);
			System.out.println("ch2"+check2);
			System.out.println("ch"+check);
			if(check==true && check2==true)
				return true;
			
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}

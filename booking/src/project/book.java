package project;
import java.sql.*;
public class book {

	public static void check(Connection myConn) {
		// TODO Auto-generated method stub
		try{
			
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from parking_space");
			while (myRs.next()){
				if (myRs.getInt("availability")==0){
				System.out.println(myRs.getString("area_id")+" , "+myRs.getInt("availability"));
			
				}
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	public static void booking(Connection myConn,String area, int a){
		try{
			Statement myStmt = myConn.createStatement();
			String   sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
			myStmt.executeUpdate(sql);
			System.out.println("update success");
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			}
	}
}

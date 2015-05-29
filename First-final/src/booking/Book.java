package booking;
import java.sql.*;
import project.*;
public class Book {

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

	public static void booking(Connection myConn,Area area, int userId, int a){
		try{
			String sql;
			String sql2;
			String sql3;
			Statement myStmt = myConn.createStatement();
			Statement myStmt2=myConn.createStatement();
			Statement myStmt3 = myConn.createStatement();
			sql3="select * from booking where area_id='"+area+"' or user_id="+userId;
			ResultSet rs= myStmt3.executeQuery(sql3);
			
			rs.last();
			int size= rs.getRow();
			rs.beforeFirst();
			if (size == 0){
				sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
				sql2= "INSERT INTO booking (area_id,user_id) VALUES ('"+area+"',"+userId+")";
				myStmt.executeUpdate(sql);
				myStmt2.executeUpdate(sql2);
				System.out.println("update success");
			}
			else{
			    System.out.println("The place is already booked or you have booked once");
			}
			
			
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			}
	}
	public static void cancel (Connection myConn,Area area, int userId, int a){
		try{
			String sql;
			String sql2;
			Statement myStmt = myConn.createStatement();
			Statement myStmt2=myConn.createStatement();
//			if (b == 0){
				sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
				sql2= "delete from booking where area_id='"+ area+"' and user_id="+userId;
//			}
//			else{
//			    sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
//			}
			
			myStmt.executeUpdate(sql);
			myStmt2.executeUpdate(sql2);
			System.out.println("update success");
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			}
	}
	public static void delete (Connection myConn,Area area, int userId){
		try{
//			String sql;
			String sql2;
//			Statement myStmt = myConn.createStatement();
			Statement myStmt2=myConn.createStatement();
//			if (b == 0){
//				sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
				sql2= "delete from booking where area_id='"+ area+"' and user_id="+userId;
//			}
//			else{
//			    sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
//			}
			
//			myStmt.executeUpdate(sql);
			myStmt2.executeUpdate(sql2);
			
			System.out.println("delete success");
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			}
	}
	public static boolean selfCheck(Connection myConn,int userId){
		try{
//			String sql;
			String sql2;
//			Statement myStmt = myConn.createStatement();
			Statement myStmt2=myConn.createStatement();
//			if (b == 0){
//				sql = "UPDATE `parking_space` SET `availability`='"+a+"' WHERE `area_id` ='"+area+"';";
			sql2= "select * from booking where user_id="+userId;
			ResultSet rs= myStmt2.executeQuery(sql2);
				
			rs.last();
			int size= rs.getRow();
			rs.beforeFirst();
			if(size!=0){
				
				return true;
			}
//			myStmt.executeUpdate(sql);
			
			System.out.println("delete success");
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			}
		return false;
	}
	public static String getAreaId(Connection myConn,int userId){
		try{
			String sql;
			Statement myStmt=myConn.createStatement();
			sql="select * from booking where user_id="+userId;
			ResultSet rs= myStmt.executeQuery(sql);
			String areaId=null;
			while(rs.next()){
				areaId=rs.getString("area_id");
			}
			
			return areaId;
			
		}catch(Exception e){
			
		}
		return null;
	}
}

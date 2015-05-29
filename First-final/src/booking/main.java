package booking;

import java.sql.*;
import java.util.Scanner;
public class main {

	private static Scanner in;

	public static void main(String[] args) throws SQLException {
		in = new Scanner(System.in);
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adprog","root","");
		while (true){
		System.out.println("1. check available parking slot"
				+ "\n2. booking"
				+ "\n3. edit mode");
		int b = in.nextInt();
		if (b == 1){
			Book.check(myConn);
		}
		else if(b == 2){
			System.out.println("please enter area id (interger)");
			try{
				String area = in.next().toString();
				Statement myStmt = myConn.createStatement();
				ResultSet query = myStmt.executeQuery("select * from parking_space WHERE `area_id`='a"+area+"';");
				query.next();
				
				if (query.getInt("availability")==0){
					System.out.println("enter member id (if you dont have it enter 0)");
					int c = in.nextInt();
					if (c !=0 ){
						Book.booking(myConn, "A"+area, 2,c );
					}
					else{
					Book.booking(myConn, "A"+area, 2,0);
					}
				}
				else{
					System.out.println("that location is already taken");
				}
				
				
			}catch (Exception a){
				System.out.println("your input is wrong");;
			}
		}
		else if(b == 3){
			System.out.println("please enter the password");
			int pass = in.nextInt();
			if (pass == 1234){
				System.out.println("please enter area id");
				String area = in.next();
				System.out.println("please enter available");
				int avaible = in.nextInt();
				try{
					Book.booking(myConn,"a"+area, avaible,0);
				}catch (Exception a){
					System.out.println("your input is wrong");
				}
			}
			else{
				System.out.println("wrong password");
			}
		}
		else{
			System.out.println("wrong input");
		}
	}
		}

}

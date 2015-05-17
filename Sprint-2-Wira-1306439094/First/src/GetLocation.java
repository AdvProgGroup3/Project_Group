
import java.sql.*;
import java.util.*;

public class GetLocation {
   static int User_id;
   static String Area_id;
   
   public static void main(String[] args) {
	   System.out.println("Please Type your User Id(integer):   ");
	   Scanner input = new Scanner(System.in);
	   User_id = input.nextInt();
	   Control data = new Control(User_id);
	   if (data.checkUserID()){
		   Area_id = data.getAreaID();
		   if (Area_id.isEmpty()){
			   System.out.println("You are not booked parking area");
		   }
		   else{ 
			   System.out.println("Here is your booking parking area " + Area_id);
		   }
	   }
	   else{
		   System.out.println("User_ID not found");
	   }
	   
   }
}
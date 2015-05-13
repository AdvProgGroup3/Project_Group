package project;
import java.util.*;
public class main {
	public static void main(String[] args){
		boolean button=false;
		boolean status=true;
		String action;	
	
		CheckIn checkIn=null;
		while(status){
			Scanner in= new Scanner(System.in);
			System.out.println("Action list: check in, check out, exit");
			System.out.println("action:");
			action=in.nextLine().toLowerCase();
			CheckInData checkInData;
			if(action.equals("check in") && button==false){
				System.out.println("Area ID from 01-12");
				System.out.println("Area:");
				String areaId= in.nextLine();
				System.out.println("ID's type is integer");
				System.out.println("ID:");
				String Id= in.nextLine();
	
				checkInData=new CheckInData(Integer.parseInt(Id), Area.valueOf("A"+areaId));
				checkIn=new CheckIn(checkInData);
				button=checkIn.checkIn();
			} else if(action.equals("exit")){
				status=false;
			} else if(button==true || (action.equals("check out") || 
					action.equals("check in"))){
					
					button=checkIn.checkOut();
			}
			
		
		}	

	}
}

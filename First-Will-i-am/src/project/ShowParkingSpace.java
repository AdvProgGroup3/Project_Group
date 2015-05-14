package project;
import java.util.*;

public class ShowParkingSpace {
	private int userId;
	private int data=0;
	private DatabaseParkingSpace dbSpace;
	private ArrayList list;
	public ShowParkingSpace(int userId){
		this.userId=userId;
		this.dbSpace=new DatabaseParkingSpace(null, data);
		
		
	}
	public ArrayList getList(){
		ArrayList aa= new ArrayList();
		aa.add("09");
		dbSpace.setAction(Action.TOLIST);
		dbSpace.connect();
//		System.out.println("a"+dbSpace.getList());
		list= (ArrayList) dbSpace.getList();
		if (list==null)
			return aa ;
		else
			return list;
		
	}
	public int getUserId(){
		return userId;
	}
}

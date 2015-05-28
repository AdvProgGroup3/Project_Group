package project;
import java.util.*;

public class ShowParkingSpace {
	private int userId;
	private int data=0;
	private DatabaseParkingSpace dbSpace;
	
	public ShowParkingSpace(int userId){
		this.userId=userId;
		this.dbSpace=new DatabaseParkingSpace(null, data);
		
		
	}
	public Map getList(){
		
		Map aa= new HashMap();
		aa.put("09",9);
		dbSpace.setAction(Action.TOLIST);
		dbSpace.connect();
//		System.out.println("a"+dbSpace.getList());
		Map list= (Map) dbSpace.getList();
		if (list.size()==0)
			return aa ;
		else
			return list;
		
	}
	public int getUserId(){
		return userId;
	}
}

package project;

import java.util.Map;
//import java.util.;
//import java.util.Date;
//import java.sql.Timestamp;

public class CheckIn {
	private boolean status=false;
	private boolean checkInOrNot;
	private DatabaseParkingLot db;
	private DatabaseParkingSpace db2;
	private CheckInData checkInData=null;
	
	
	public CheckIn(CheckInData checkInData){
		this.checkInData=checkInData;
		this.db2=new DatabaseParkingSpace(checkInData.getAreaId(), 0);
		this.db=new DatabaseParkingLot(checkInData,db2.getData());
		
	}
	
	public void setStatus(boolean status){
		this.status=status;
	}
	public boolean checkIn(){
		if(status==false ){
			
			db2.setAction(Action.SELECT);
			db2.connect();
			if(db2.getData()==0){
				db.setStatus(db2.getData());
				db.setAction(Action.INSERT);
				db.setData(checkInData);
				db.connect();
				db.setAction(Action.CHECKINORNOT);
				db.connect();
				
				

				System.out.println("x"+getCheckInOrNot());
				if(getCheckInOrNot() && db.getWarn().size()==0){
					db2.setData(1);
					db2.setAction(Action.UPDATE);
					db2.connect();
					status=true;
				}
			}else{
				status=false;
			}
				
			
		}
		
		return status;
		

	}
	public boolean checkOut(){
		if(status==true ){
			
			
			db2.setAction(Action.SELECT);
			db2.connect();
			if(db2.getData()==1 ){
				db2.setData(0);
				db2.setAction(Action.UPDATE);
				db2.connect();
				db.setStatus(db2.getData());
				db.setAction(Action.UPDATE);
				db.connect();
				
				checkInOrNot=db.getCheckInOrNot();
				this.checkInData=null;
				status=false;
			}else{
				status=true;
			}
			
		}
		return status;
	}
	public boolean getCheckInOrNot(){
		checkInOrNot=db.getCheckInOrNot();
		return checkInOrNot;
	}
	public boolean getFillInOrNot(){
		return db2.getFillInOrNot();
	}
	public Map getWarn(){
		return db.getWarn();
	}
	
	public boolean getStatus(){
		return status;
	}
	
	
}

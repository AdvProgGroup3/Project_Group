package project;
//import java.util.;
//import java.util.Date;
//import java.sql.Timestamp;

public class CheckIn {
	private boolean status=false;
	private DatabaseParkingLot db;
	private DatabaseParkingSpace db2;
	private CheckInData checkInData=null;
	
	public CheckIn(CheckInData checkInData){
		this.checkInData=checkInData;
		this.db2=new DatabaseParkingSpace(checkInData.getAreaId(), 0);
		this.db=new DatabaseParkingLot(checkInData,db2.getData());
		
	}
	
	
	public boolean checkIn(){
		if(status==false ){
			status=true;
			db2.setAction(Action.SELECT);
			db2.connect();
			db.setStatus(db2.getData());
			db.setAction(Action.INSERT);
			db.setData(checkInData);
			db.connect();
			if(!db.getCheckInOrNot()){
				db2.setData(1);
				db2.setAction(Action.UPDATE);
				db2.connect();
			}
				
			
		}
		
		return status;
		

	}
	public boolean checkOut(){
		if(status==true){
			status=false;
			db2.setData(0);
			db2.setAction(Action.UPDATE);
			db2.connect();
			db.setStatus(db2.getData());
			db.setAction(Action.UPDATE);
			db.connect();
			this.checkInData=null;
			
		}
		return status;
	}
	
	
}

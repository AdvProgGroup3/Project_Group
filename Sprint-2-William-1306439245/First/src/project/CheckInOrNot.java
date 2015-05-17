package project;

public class CheckInOrNot {
//	private int checkInOrNot;
	private int userId;
	public CheckInOrNot(int userId){
		this.userId=userId;
		
	}
	public boolean getCheckInOrNot(){
		DatabaseParkingLot db= new DatabaseParkingLot(new CheckInData(userId, null), 0);
		return db.getCheckInOrNot();
	}

}

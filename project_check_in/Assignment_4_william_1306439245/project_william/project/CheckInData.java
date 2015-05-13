package project;
import java.sql.Timestamp;
public class CheckInData {
	private int id;
	private Area areaId;

//	private Timestamp timestamp;
	public CheckInData(int id, Area areaId ){
		this.areaId=areaId;
		this.id=id;
		
//		this.timestamp=timestamp;
		
	}
	public int getId(){
		return id;
	}
	public Area getAreaId(){
		return areaId;
	}

	public void setId(int id){
		this.id= id;
	}
	public void setAreaId(Area areaId){
		this.areaId= areaId;
	}

	
	
	

}

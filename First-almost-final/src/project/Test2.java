package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
//		Scenario 3
//		another user trying to get in to equipped parking space
		CheckInData checkInData=new CheckInData(4, Area.A01);
		CheckInData checkInData1=new CheckInData(5, Area.A05);
		CheckIn checkIn=new CheckIn(checkInData);
		CheckIn checkIn1=new CheckIn(checkInData1);
		boolean status= checkIn.checkIn();
		boolean status1=checkIn1.checkIn();
		assertEquals(true, status);
		assertEquals(false, status1);
		
	}

}

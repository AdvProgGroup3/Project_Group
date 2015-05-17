package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test3 {

	@Test
	public void test() {
//		Scenario 4
//		same user trying to check in twice
		CheckInData checkInData=new CheckInData(0, Area.A02);
//		CheckInData checkInData1=new CheckInData(1, Area.A01);
		CheckIn checkIn=new CheckIn(checkInData);
//		CheckIn checkIn1=new CheckIn(checkInData1);
		boolean status= checkIn.checkIn();
		boolean status1= checkIn.getCheckInOrNot();
		assertEquals(true, status1);

	}

}

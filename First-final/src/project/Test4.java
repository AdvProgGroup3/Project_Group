package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test4 {

	@Test
	public void test() {
//		Scenario 5
//		trying to check out without checking in
		CheckInData checkInData=new CheckInData(1, Area.A02);
//		CheckInData checkInData1=new CheckInData(1, Area.A01);
		CheckIn checkIn=new CheckIn(checkInData);
//		CheckIn checkIn1=new CheckIn(checkInData1);
		boolean status= checkIn.checkOut();
		
		assertEquals(false, status);
	}

}

package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
//		Scenario 1 & 2
//		ordinary check in and check out by  one user and one parking space
		CheckInData checkInData=new CheckInData(0, Area.A01);
		CheckIn checkIn=new CheckIn(checkInData);
		boolean status= checkIn.checkIn();
		assertEquals(true, status);
		status=checkIn.checkOut();
		assertEquals(false, status);
	}

}

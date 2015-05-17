import static org.junit.Assert.*;

import org.junit.Test;


public class testGetAreaID {

	@Test
	public void test() {
		System.out.println("test the getAreaID() method");
		int user_id = 1;
		
		Control data = new Control(user_id);
		assertEquals("a01", data.getAreaID());
		System.out.println("user_id = 1, expected area_id = a01\n");
	}

}

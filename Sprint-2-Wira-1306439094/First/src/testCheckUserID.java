import static org.junit.Assert.*;

import org.junit.Test;


public class testCheckUserID {

	@Test
	public void test() {
		System.out.println("test case about the user_id correctness in database");
		int User_id = 1;
		
		Control data = new Control(User_id);
		assertTrue(data.checkUserID());
		System.out.println("user_id = 1 expected value = true");
	}

}

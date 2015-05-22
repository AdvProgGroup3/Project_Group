import static org.junit.Assert.*;

import org.junit.Test;


public class Test1 {

	@Test
	public void test() {
		//If the login is success, using the correct username and correct password
		LoginServlet newSession = new LoginServlet();
		boolean loginSuccess = newSession.login("william", "xxxx");
		assertEquals(true, loginSuccess);
		
	}

}

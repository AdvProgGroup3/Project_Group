import static org.junit.Assert.*;

import org.junit.Test;


public class Test2 {

	@Test
	public void test() {
		//If the login is failed, using the correct username and wrong password
		LoginServlet newSession = new LoginServlet();
		boolean loginFailed = newSession.login("william", "william");
		assertEquals(false, loginFailed);
	}

}

import static org.junit.Assert.*;

import org.junit.Test;


public class Test3 {

	@Test
	public void test() {
		//If the login is failed, does not input the username and correct password
		LoginServlet newSession = new LoginServlet();
		boolean loginFailed = newSession.login("", "william");
		assertEquals(false, loginFailed);
	}

}

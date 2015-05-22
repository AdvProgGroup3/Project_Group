import static org.junit.Assert.*;

import org.junit.Test;


public class Test4 {

	@Test
	public void test() {
		//If the login is failed, input the correct username but does not input any password
		LoginServlet newSession = new LoginServlet();
		boolean loginFailed = newSession.login("", "");
		assertEquals(false, loginFailed);
	}
}

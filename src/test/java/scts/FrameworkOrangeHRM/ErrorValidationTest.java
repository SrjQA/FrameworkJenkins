package scts.FrameworkOrangeHRM;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import scts.testComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void e2eTest() throws IOException {
		// ADMIN Login-beforemethod in base test
		landingPage.loginApplication("Admin", "suraj**");
        Assert.assertEquals("Invalid credentials", landingPage.getErrorMessage());
	}
    @Test
    public void testError() {
    	System.out.println("Error test passed");
    }
}

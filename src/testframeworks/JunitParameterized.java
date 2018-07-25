package testframeworks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class JunitParameterized {
	String email;
	String password;
	String expectedResult;
	String browser;
	
	@Parameters
	// @paramters called 2 times.
	public static String[][] testData(){
		System.out.println("RUNNING PARAMETERS");
		// call utility function to get data from external source csv, database etc.,
		String[][] records = {
				{"Chrome", "tim@testemail.com", "password", "pass"},
				{"IE", "bademail@testemail.com", "badpassword", "fail"},
				{"firefox","jason@testemail.com", "jpassword", "pass"},
				{"firefox1","jason@testemail.com", "jpassword", "pass"}
		};
		return records;
	}
	
	// Contructor: receives @parameters for each iteration
	// called as many times as number of records.
	public JunitParameterized(String browser, String email, String password, String expectedValue) {
		System.out.println("RUNNING CONSTRUCTOR");
		this.browser = browser;
		this.email = email;
		this.password = password;
		this.expectedResult = expectedValue;
	}

	@Test
	// called as many times as number of records.
	public void test() {
		System.out.println("browser: " + browser);
		System.out.println("Username: " + email);
		System.out.println("Password: " + password);
		System.out.println("Expected Results: " + expectedResult);
		//Assert.assertEquals(expectedResult, "pass");
	}
	
	@Before
	// called everytime before executing @Test
	public void setup() {
		System.out.println("Before method");
	}
}

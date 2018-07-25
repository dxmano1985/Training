package testframeworks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNGIntro {
	
	@Test
	public void freddieLoginTest() {
		System.out.println("Execution login test");
		
	}
	

	
	@Test
	public void freddieFeatureTest() {
		String userId = "xavier";
		String actualId = "xavier1";
		Assert.assertEquals(userId, actualId);
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Setting up Test");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing");
	}
	

}

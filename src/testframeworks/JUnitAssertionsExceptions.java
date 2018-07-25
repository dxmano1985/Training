package testframeworks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class JUnitAssertionsExceptions {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@After
	public void tearDown() {

		driver.quit();

		System.out.println("Closing test");

	}

	@Test
	public void test() {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("badpassword");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		boolean expected = false;
		if (expected) {
			try {
				Assert.assertTrue("Logged in message is not as expected",
						driver.findElement(By.id("conf_message")).getText().equals("Logged in successfully1"));
			} catch (NoSuchElementException e) {
				fail("Unable to locate login successful message element");
			}
		} else {
			try {
			Assert.assertTrue("Logged in Fail message not as expected", driver.findElement(By.id("MainContent_lblTransactionResult")).getText()
					.equals("Invalid password, try again!"));
			}catch(NoSuchElementException e) {
				fail("Unable to locate login failure message element");
			}
		}
	}

}

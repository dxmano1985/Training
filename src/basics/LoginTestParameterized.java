package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class LoginTestParameterized {
public static void main(String [] args) throws InterruptedException {
	String[] usernames = {"tim@testemail.com", "abcd@testemail.com","jason@testemail.com"};
	String[] passwords = {"password", "thisisawrongpass", "jpassword"};
	String[] browserTypes = {"Chrome", "Firefox", "IE"};
	boolean[] expectations = {true, false, true};
	String passMessage = "Logged in successfully";
	String failMessage = "Invalid user name, try again!";
	
	
	int numberOfUsers = usernames.length;
	//open browser
	for(int i=0; i<numberOfUsers; i++) {

	String username = usernames[i];
	String password = passwords[i];	
	boolean expected = expectations[i];
	System.out.println("Test Data: Username - " + username + " Password: " + password + "Expectation: " + expected);
	
	String browserType = browserTypes[i];
	System.out.println("Browser type: " + browserType);
	WebDriver driver = DriverFactory.getDriver(browserType);
	//enter login

	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	driver.findElement(By.id("MainContent_btnLogin")).click();
	
	String pageText = driver.findElement(By.xpath("html/body")).getText();
	System.out.println("Expected: " + expected);
	if(expected) {
	if(pageText.contains(passMessage)) {
		System.out.println("Test passed");
	}else {
		System.out.println("Test Fail");
	}

	}else {
		if(pageText.contains(failMessage)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test Fail");
		}
	}
	//validate expected outcome
	// Invalid user name, try again!
	// Logged in successfully
	//close browser
	Thread.sleep(5000);
	driver.quit();
	}
}
}

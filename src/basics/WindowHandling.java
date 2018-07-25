package basics;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.Windows;

public class WindowHandling {

	WebDriver driver;

	@Test
	public void windowHandling() throws Throwable {
		
		//click CREATE ACCOUNT button to open Account Management page 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		Thread.sleep(2000);

		//String mainWindow = driver.getWindowHandle();
		/*
//Iterate thro
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}*/

		/*
		driver.switchTo().window(mainWindow);
		ArrayList<String> openWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(openWindows.get(1));
		*/
		
		// switch to Account Management window
		Windows.chooseWindowByTitle(driver, "Account Management");
		Thread.sleep(3000);
		
		//Fill the form in Account Management page
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("jason@testemail.com");
		
	}

	@Ignore
	@Test
	public void popupHandling() {
		// TODO Auto-generated method stub
		boolean accept = true;
		driver.findElement(By.id("delete_account")).click();
		System.out.println(driver.switchTo().alert().getText());
		if (accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver("chrome");
		driver.get("http://sdettraining.com/projects/windows.html");
	}

	@After
	public void tearDown() throws Throwable {
		Thread.sleep(3000);
		driver.quit();
	}

}

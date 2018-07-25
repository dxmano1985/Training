package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize browser settings
	System.setProperty("webdriver.gecko.driver", "C:\\Training\\SeleniumTraining\\softwares\\Jars\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		// Click Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		// Fill out the form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jason");;
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("jason@testemail.com");;
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("123456789");
		
		// radio button - use id tag. radio buttons are dependent
		driver.findElement(By.id("MainContent_Male")).click();
		
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("jpassword");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("jpassword");
		
		// select class for dropdown
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByValue("Canada");
		
		// checkbox: use id/name (independent)
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		
		driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click();
		
		if(driver.findElement(By.id("MainContent_lblTransactionResult")).getText().equals("Customer information added successfully")) {
			System.out.println("Test Success");
		}else {
			System.out.println("Test fail");
		}
		
		driver.quit();

	}

}

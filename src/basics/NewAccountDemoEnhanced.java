package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountDemoEnhanced {

	public static void main(String[] args) {
		// Declare variables
		WebDriver driver;

		// Define variables
		String browserType = "Chrome";
		String browserExecutablePath = "C:\\Training\\SeleniumTraining\\softwares\\Jars\\";
		String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		boolean occasionalUpdate = false;
		String creatAccountlinkText = "Create Account";

		if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			driver = new ChromeDriver();
			creatAccountlinkText = "CREATE ACCOUNT";
		} else if (browserType.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserExecutablePath + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", browserExecutablePath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			creatAccountlinkText = "CREATE ACCOUNT";
		}

		// TODO Auto-generated method stub

		// Initialize browser settings

		driver.get(url);
		// Click Create Account
		driver.findElement(By.linkText(creatAccountlinkText)).click();

		// Fill out the form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jason");
		;
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("jason@testemail.com");
		;
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("123456789");

		// radio button - use id tag. radio buttons are dependent
		/*
		if (gender.equals("Male")) {
			driver.findElement(By.id("MainContent_Male")).click();
		} else if (gender.equals("Female")) {
			driver.findElement(By.id("MainContent_Female")).click();
		}
		*/
		
		// radio button with selector
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='" + gender + "']")).click();

		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("jpassword");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("jpassword");

		// select class for dropdown
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByValue("Canada");
		 
		
		
		// checkbox: use id/name (independent)
		//driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		selectCheckbox(driver, weeklyEmail, "ctl00$MainContent$checkWeeklyEmail");
		selectCheckbox(driver, monthlyEmail, "ctl00$MainContent$checkMonthlyEmail");
		selectCheckbox(driver, occasionalUpdate, "ctl00$MainContent$checkUpdates");
		


		driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click();

		if (driver.findElement(By.id("MainContent_lblTransactionResult")).getText()
				.equals("Customer information added successfully")) {
			System.out.println("Test Success");
		} else {
			System.out.println("Test fail");
		}

		// driver.quit();

	}
	
	static void selectCheckbox(WebDriver driver, boolean desiredOption, String element) {
		if(desiredOption) {
			if(!driver.findElement(By.name(element)).isSelected()) {
				driver.findElement(By.name(element)).click();
			}else if(driver.findElement(By.name(element)).isSelected()) {
				driver.findElement(By.name(element)).click();
			}
		}
		
	}

}

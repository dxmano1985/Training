package advanced;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverFactory;

public class HomePageLinks {

	WebDriver driver;
	
	@Before
	public void setup() {
	driver = DriverFactory.getDriver("chrome");
	driver.get("http://sdettraining.com/projects/");
	}
	
	@Test
	public void testHomePageLinks() {
		
	}
	

public void testHomePage() {
	
	for (WebElement aTag : pages.Home.getAllLinks(driver)) {
		aTag.click();
		driver.navigate().back();
	}
}

	
}

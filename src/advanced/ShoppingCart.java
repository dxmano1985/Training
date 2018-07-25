package advanced;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.Home;
import pages.SearchPage;
import utilities.DriverFactory;
import utilities.GlobalConfigs;

public class ShoppingCart {
	WebDriver driver;

	@Test
	public void endToEndTest() {
		
		//SearchPage.searchForProduct(driver, "camera");
		
		SearchPage search = new SearchPage(driver);
		search.searchForProduct("tv");
		
		Products products =new Products(driver);
		products.addItemToCart("Panasonic HD TV");
	}
	

	public void smokeTest() {
		SearchPage search = new SearchPage(driver);
		search.clickSearch();
	}

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver("chrome");
		driver.get(GlobalConfigs.ROOT_URL);
		Home.shoppingCartApplication(driver).click();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}

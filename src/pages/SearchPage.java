package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	// Define instance level webdriver
	private WebDriver driver;
	
	// 1. Define (identify) all page web elements "up top" as web element
	
	@FindBy(name = "txtSearch")
	WebElement searchtxt;
	
	@FindBy(id = "Go")
	WebElement searchBtn;
	
	
	// 2. Create a constructor to initialize page elements
		// defines all web elements and attaches to the current browser state
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// 3. Create Object methods to perform page actions with elements
	//utilities
	public void setSearch(String product) {
		searchtxt.sendKeys(product);
	}
	public void searchForProduct(String product) {
		setSearch(product);
		clickSearch();
	}
	
	public void clickSearch() {
		searchBtn.click();
	}
	
	

	/*
	// Utility functions
	public static void searchForProduct(WebDriver driver, String product) {
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
	}
	
	// Search textbox	
	public static void searchProductText(WebDriver driver, String product) {
		
		driver.findElement(By.name("txtSearch")).sendKeys(product);
	}
	
	// Search Go button
	public static void clickSearch(WebDriver driver) {
		driver.findElement(By.id("Go")).click();
	}
	*/
}

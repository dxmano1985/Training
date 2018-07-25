package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// BAD WAY: this class is nothing more than old way of doing utility functions. we dont want this.
public class Home {
// We want to able to able to interact with any and all elements in the page
	
	// 1. Get all link tags
		
	public static List<WebElement> getAllLinks(WebDriver driver) {
		
		return driver.findElements(By.tagName("a"));
	}
	
	//2. click on Loan Delivery Application
	
	public static WebElement loanDeliveryApplication(WebDriver driver){
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]"));
	}
	
	//3. click on Account Management System
	public static WebElement accountManagementSystem(WebDriver driver){
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]"));
	}
	
	//3. click on Shopping Cart Application
	
	public static WebElement shoppingCartApplication(WebDriver driver){
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[3]"));
	}
	
}

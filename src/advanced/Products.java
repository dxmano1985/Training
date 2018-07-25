package advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

	WebDriver driver;
	String prodNamePath = "td[2]/font[2]/b";
	String addToCartPath = "td[3]/a";
	
	@FindBy(xpath = "/html/body/font/table[1]/tbody/tr")
	List<WebElement> searchResults;
	
	// Define all page elements as variables
	//WebElement addToCartBtn;
	
	// Add product to Cart
	
	// Test to see if we have the right products

	//Initialize web elements at instantiation
	public Products(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this.addToCartBtn = this.driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[1]/td[3]/a"));
		
	}
	
	// All page actions as methods	
	
	public void addItemToCart(String productName) {
		for(WebElement row : searchResults) {
			if(row.findElement(By.xpath(prodNamePath)).getText().toUpperCase().matches(productName.toUpperCase())) {
				row.findElement(By.xpath(addToCartPath)).click();
				break;
			}
		}
	}
}

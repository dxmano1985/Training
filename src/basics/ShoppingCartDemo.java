package basics;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverFactory;

public class ShoppingCartDemo {
	
	@Test
	public void shopCartTest() throws Throwable {
		WebDriver driver = DriverFactory.getDriver("chrome");
		String product = "tv";
		driver.get("http://sdettraining.com/online/default.asp");
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//font/table[1]/tbody/tr[1]/td[2]/font[2]/b")).getText().toUpperCase().contains(product.toUpperCase()));
		
		
		WebElement prodTable = driver.findElement(By.xpath("//font/table[1]/tbody"));
		System.out.println("Prod Name: " + prodTable.findElement(By.xpath("tr[1]/td[2]/font[2]/b")).getText());
		System.out.println("Prod Name: " + prodTable.findElement(By.xpath("tr[2]/td[2]/font[2]/b")).getText());
		//System.out.println(driver.findElement(By.xpath("//font/table[1]/tbody/tr[1]/td[3]/font")).getText());
		
		// Assert all the search results are TVs
		List<WebElement> resultTable = driver.findElements(By.xpath("/html/body/font/table[1]/tbody/tr"));
		
		for(WebElement resultRow: resultTable){	
			/*
			if(resultRow.findElement(By.xpath("td[2]/font[2]")).getText().toUpperCase().contains(product.toUpperCase())){
				System.out.println("Listed product is :" + product);
			}else {
				System.out.println("Listed product is NOT:" + product);
			}*/
			
			Assert.assertTrue(resultRow.findElement(By.xpath("td[2]/font[2]")).getText().toUpperCase().contains(product.toUpperCase()));
		}
		
		//Add items to cart
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[1]/td[3]/a")).click();
		
		//Extract Grand Total from Cart
		List<WebElement> cartTable = driver.findElements(By.xpath("/html/body/font/form/table/tbody/tr"));		
		WebElement grandTotalElement = 	cartTable.get(cartTable.size()-1);
		System.out.println("GRAND TOTAL:" + grandTotalElement.findElement(By.xpath("td[2]")).getText());

		//driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to Checkout']")).click();
		driver.findElement(By.xpath("//input[@value='Submit Order']")).click();
		
		// Assert that order placed successfully
		String expectedConfMessage = "Thank you for ordering with us!";
		String confMessage = driver.findElement(By.xpath("html/body")).getText();
		Assert.assertTrue(confMessage.contains(expectedConfMessage));
		
		
		// Extract the confirmation message.
		String pattern = "Order# (.*) safe";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(confMessage);
		m.find();
		String confNumber = m.group(1);
		System.out.println("confNumber: " + confNumber);
		Thread.sleep(3000);
		driver.quit();
	}

}

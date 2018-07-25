package utilities;

import org.openqa.selenium.WebDriver;

public class Windows {
	public static void chooseWindowByTitle(WebDriver driver, String titleParam) {
		for(String window:driver.getWindowHandles()) {
			if(driver.switchTo().window(window).getTitle().contains(titleParam)) {
				break;
			}
			
		}
		
	}

}

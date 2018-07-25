package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	// This function returns WebDriver
	
	public static WebDriver getDriver(String browserType) {	
		String browserExecutablePath = "C:\\Training\\SeleniumTraining\\softwares\\Jars\\";
		
		//System.setProperty("webdriver.gecko.driver", browserExecutablePath + "geckodriver.exe");
		//return new FirefoxDriver();
		//WebDriver driver;

		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			return new ChromeDriver();
			//creatAccountlinkText = "CREATE ACCOUNT";
		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserExecutablePath + "geckodriver.exe");
			return new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", browserExecutablePath + "IEDriverServer.exe");
			return new InternetExplorerDriver();
			//creatAccountlinkText = "CREATE ACCOUNT";
		}else {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			return new ChromeDriver();
		}
		
	}
}

package cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;

public class LDDS {
	// class level instance variable
	WebDriver driver = DriverFactory.getDriver("Chrome");

	@Given("^Freddie logs into to ldss$")
	public void freddie_logs_into_to_ldss() throws Throwable {
		System.out.println("Client logs in");
		driver.get("http://sdettraining.com/ldss/ldss/loan");
	}

	@When("^client enters loan information$")
	public void client_enters_loan_information() throws Throwable {

		// General loan information - 17 fields
		driver.findElement(By.name("ctl00$MainContent$txtLenderLoanNumber")).sendKeys("9283765");
		driver.findElement(By.name("ctl00$MainContent$txtSellerName")).sendKeys("BANK OF AMERICA");
		driver.findElement(By.name("ctl00$MainContent$txtFinancialInstitutionNumber")).sendKeys("BOA123");

		// click "Next"
		driver.findElement(By.name("ctl00$MainContent$LoanButton")).click();

		// Loan Terms - 19 fields
		driver.findElement(By.name("ctl00$MainContent$txtOriginalTerm")).sendKeys("30 years");
		driver.findElement(By.name("ctl00$MainContent$txtOriginalTermPeriod")).sendKeys("20 years");

		// click "Submit"
		driver.findElement(By.name("ctl00$MainContent$Button1")).click();

	}

	@Then("^client receives a confirmation$")
	public void client_receives_a_confirmation() throws Throwable {
		String expectedConfirmation = "Loan Submitted!";
		Assert.assertTrue(driver.getPageSource().contains(expectedConfirmation));
	}

	@Then("^client receives a quote$")
	public void client_receives_a_quote() throws Throwable {

	}

}

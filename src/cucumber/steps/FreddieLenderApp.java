package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FreddieLenderApp {

	@Given("a client logs into the system")
	public void a_client_logs_into_the_system() {
		System.out.println("Client logs in");
	}
		
	@When("the client submits a loan application")
	public void the_client_submits_a_loan_application() {
		System.out.println("the client submits a loan application");
	}
	
	@Then("the client gets a receipt confirmation")
	public void the_client_gets_a_receipt_confirmation() {
		System.out.println("the client gets a receipt confirmation");
	}
	
}

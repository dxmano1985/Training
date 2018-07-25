package testframeworks;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNGParameterization {
  @Test(dataProvider = "usernameTestData")
public void usernameTest(String username, String password) {
	  System.out.println("Executing Test");
  }
  
  @Test(dataProvider = "genericData")
public void genericTest(String mortgageType, double rate, double priniple, String zip) {
	  System.out.println("mortgageType: " + mortgageType);
	  System.out.println("rate: " + rate);
	  System.out.println("priniple: " + priniple);
	  System.out.println("zip: " + zip);
  }
  
  @DataProvider
  private String[][] usernameTestData(){
	  String[][] usernames = { {"tim@testemail.com", "password"},
			  {"lindsey@freddie.com", "lindseypassword"},
			  {"kim@freddie.com", "kimpassword"}
		  
	  };
	  return usernames;
  }
 
  @DataProvider
  private Object[][] genericData(){
	  Object[][] mortgageData = { 
			  new Object[] {"30-Fixed", 4.5, 10000, "74442"},
			  new Object[] {"40-Fixed", 5, 150000, "76422"},
		  
	  };
	  return mortgageData;
  }
 
}

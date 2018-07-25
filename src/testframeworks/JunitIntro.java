package testframeworks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class JunitIntro {

	// Unit test framework 
	// guides the flow of the program (or test) with annotations
	// pass/fail tests with assertions
	
	// Start browser session, initialize settings, connect to data source
	// run setup() before each step
	@Before
	public void setup() {
		System.out.println("Setting up Test");
	}
	
	// execute UI test cases
	@Test
	public void test1() {
		System.out.println("Running up Test1");
		// Assertions: compare two values and will fail if false
		String expectedValue = "success";
		String actualValue = "fail";		
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void test2() {
		System.out.println("Running up Test1");
	}
	
	// close the browser session, generate reports
	//run tearDown() after each test
	@After
	public void tearDown() {
		System.out.println("Closing Test");
		
	}
}

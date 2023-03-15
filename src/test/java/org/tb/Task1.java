package org.tb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {

	@Test(priority=-10)
	public void test1() {
	System.out.println("Test Case 1");
	}// Test Case 2
	
	
	@Test(priority=-8)
	public void test2() {
	System.out.println("Test Case 2");
	}
	
	@Test(priority=-2)
	public void test3() {
	System.out.println("Test Case 3");
	}
	
	@Test(priority=2)
	public void test4() {
	System.out.println("Test Case 4");
	}
	
	@Test(priority=-2)
	public void btest5() {
	System.out.println("Test Case 5");
	}
	
	
	
	@Test
	public void btest6() {
	System.out.println("Test Case 6");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

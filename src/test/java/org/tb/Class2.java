package org.tb;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class2 {

	@Parameters("firstname")
	@Test(priority=6)
	private void firstName(String fname) {
		System.out.println(fname);
	}
	
	@Parameters("lastname")
	@Test(priority=8)
	public void lastName(String lname) {
		System.out.println(lname);
	}
	
	
}

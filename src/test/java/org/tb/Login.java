package org.tb;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	
	
	@Parameters({"Username","Password"})
	@Test(invocationCount=5)
	private void login(String name,String pass) {
		System.out.println(name);
		
		System.out.println(pass);
		
	}

}

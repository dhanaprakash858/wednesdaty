package com.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

	@Parameters("username")
	@Test
	public void user(String name) {
		System.out.println(name);
	}
	@Parameters("password")
	@Test
	public void pass(String pass) {
		System.out.println(pass);
	}
}

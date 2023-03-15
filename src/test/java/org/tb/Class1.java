package org.tb;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class1 {

	@Test
	private void userName() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void password() {
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	private void btnLogin() {
		System.out.println(Thread.currentThread().getId());
	}
	
	
	
}
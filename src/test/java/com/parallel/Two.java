package com.parallel;

import org.testng.annotations.Test;

public class Two {
	
	@Test
	public void test3() {
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void test4() {
		System.out.println(Thread.currentThread().getId());
	}

}

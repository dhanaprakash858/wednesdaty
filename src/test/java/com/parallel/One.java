package com.parallel;

import org.testng.annotations.Test;

public class One {
	
	@Test
	public void test1() {
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		System.out.println(Thread.currentThread().getId());
	}

}

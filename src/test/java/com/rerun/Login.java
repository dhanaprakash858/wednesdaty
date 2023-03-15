package com.rerun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	@Test
	private void test() {
		
		Assert.assertTrue(true, "verify");

		System.out.println("test");
	}

	@Test(retryAnalyzer=ManualRerun.class)
	private void test1() {
		
		Assert.assertTrue(false, "verify");

		System.out.println("test1");
	}






}


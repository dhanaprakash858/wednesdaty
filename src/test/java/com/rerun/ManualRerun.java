package com.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ManualRerun implements IRetryAnalyzer  {

	
	int minCount=0;
	int maxCount=5;
	
	public boolean retry(ITestResult result) {
		
		if (minCount<maxCount) {
			minCount++;
			return true;
		}
		
		
		return false;
	}
	
}

package com.rerun;
                 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPro {

	@DataProvider(name="data")
	public Object[][] dpMethod() {
		
		return new Object[][] {
			{"karthi,1234"},{"raj,1234321"}
		};
		
	}

	@Test(dataProvider="data")
	public void myTest(String value) {
		
		System.out.println("passed: "+value);
	}
}







/*


@DataProvider (name = "data-provider")
public Object[][] dpMethod(){
return new Object[][] {{"Nisa,8783838838"}, {"Lisa,8783838838"}};
}

@Test (dataProvider = "data-provider")
public void myTest (String val) {
   System.out.println("Passed Parameter Is : " + val);
}*/
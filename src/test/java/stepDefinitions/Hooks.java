package stepDefinitions;

import org.junit.AfterClass;


import methods.CommonFunctions;

public class Hooks extends CommonFunctions {
	
	@AfterClass
	public void tearDown() {
		
		closeDriver();

	}

}

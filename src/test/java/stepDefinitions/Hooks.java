package stepDefinitions;

import io.cucumber.java.After;
import methods.CommonFunctions;

public class Hooks extends CommonFunctions {
	
	@After
	public void tearDown() {
		
		closeDriver();

	}

}

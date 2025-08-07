package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import methods.BaseTest;
import methods.CommonFunctions;

public class JobListPage extends CommonFunctions implements BaseTest {
	
	@FindBy (xpath = "//a[@aria-label='IT Product Manager Job ID is 2516837']")
	WebElement listedJob;



	public JobListPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void selectTheListedJob() {
		clickByElement(listedJob);
	}

}

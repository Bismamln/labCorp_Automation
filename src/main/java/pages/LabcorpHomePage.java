package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import methods.BaseTest;
import methods.CommonFunctions;


public class LabcorpHomePage extends CommonFunctions implements BaseTest {

	@FindBy (xpath = "//div[@class='text text-navy body2']//a[contains(@href,'careers')]")
	WebElement careersLink;



	public LabcorpHomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnCareersLink() {
		clickByElement(careersLink);
	}

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import methods.BaseTest;
import methods.CommonFunctions;

public class CareersPage extends CommonFunctions implements BaseTest {
	
	@FindBy (id = "typehead")
	WebElement inputSearchBar;
	
	@FindBy(id = "ph-search-backdrop")
	WebElement searchSubmitButton;
	
	

	public CareersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearchBar() {
		clickByElement(inputSearchBar);
	}

	public void enterJobInSearchBar(String jobText) {
		enterTextByElement(inputSearchBar , jobText);
	}
	
	public void clickToSearchAJob() {
		clickByElement(searchSubmitButton);
	}

}

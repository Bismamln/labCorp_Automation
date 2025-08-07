package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import methods.BaseTest;
import methods.CommonFunctions;

public class JobPage extends CommonFunctions implements BaseTest {
	
	@FindBy (xpath = "//h1[@class='job-title']")
	WebElement jobTitle;
	
	@FindBy (xpath = "//span[@class='au-target job-location']")
	WebElement jobLocation;
	
	@FindBy (xpath = "//span[@class='au-target jobId']")
	WebElement jobId;
	
	@FindBy (xpath = "//div[@class='jd-info au-target']/ul/li[1]")
	WebElement minimumRequiredEducation;
	



	public JobPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String getJobTitle() {
		return getTextByElement(jobTitle);
	}
	
	public String getJobLoaction() {
		return getTextByElement(jobLocation);
	}
	
	public String getJobId() {
		return getTextByElement(jobId);
	}
	
	public String getMinimumRequiredEducation() {
		return getTextByElement(minimumRequiredEducation);
	}

}

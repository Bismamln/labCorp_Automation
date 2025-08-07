package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import environment.DriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.BaseTest;

public class UserStepDefs implements BaseTest{
	
	protected WebDriver driver = DriverUtils.getDefaultDriver();

	
	@Given("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link)
	{
		navigationObj.navigateTo(link);
	}
	
	@And("^I clicks on Careers link")
	public void clicks_on_career_link()
	{
		labCorpHome.clickOnCareersLink();
	}
	
	@And("^Search the job with \"(.*?)\"$")
	public void search_job_by_jobTitle(String jobTitle) throws Exception
	{
		career_page.clickOnSearchBar();
		career_page.enterJobInSearchBar(jobTitle);
	}
	
	@And("^Click to Search a job")
	public void clicks_to_search_a_job()
	{
		career_page.clickToSearchAJob();
	}
	
	@When("^Click on the job")
	public void clicks_on_the_job()
	{
		job_list_page.selectTheListedJob();
	}
	
	@Then("^Verify the Job should contains following details$")
	public void verify_the_job_should_contains_following_details(DataTable jobDetails) throws Throwable {

		
		List<Map<String, String>> data = jobDetails.asMaps(String.class,String.class);
		
		String actualJobTitle = job_page.getJobTitle();
		String actualJobId = job_page.getJobId();
		String actualMinimumEducationRequired = job_page.getMinimumRequiredEducation();
		
		Assert.assertEquals(data.get(0).get("Value"), actualJobTitle);
		Assert.assertEquals(data.get(2).get("Value"), actualJobId);
		Assert.assertEquals(data.get(3).get("Value"), actualMinimumEducationRequired);
		
		
	
		
	}
}

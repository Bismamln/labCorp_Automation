package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.BaseTest;

public class APIStepDefs implements BaseTest{
	
	
	@Given("^User fetch the beeceptor API base URI")
	public void fetch_the_base_URI()
	{
		apiCommons.getBaseURI();
	}
	
	@And("query params for property as {string} and value as {string}")
	public void query_params_for_property_as_and_value_as(String property , String value) throws Exception
	{
		apiCommons.requestWithQueryParams(property, value);
	}
	
	@When("User Send the {string} request with endpoint as {string}")
	public void user_send_the_request_with_endpoint_as(String requestType , String endpoint) throws Exception
	{
		apiCommons.sendRequest(requestType, endpoint);
	}
	
	@Then("Verify the status code to be {int}")
	public void verify_the_status_code_to_be(int expectedStatusCode)
	{
		int actualStatusCode = apiCommons.verifyStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
	
	@Then("^Validate the json schema of \"(.*?)\"$")
	public void validate_the_json_schema_as(String jsonFileName) throws Exception
	{
		String jsonSchema = FileUtils.readFileToString(new File("./src/test/resources/"+jsonFileName),"UTF-8");
		apiCommons.validateJsonSchema(jsonSchema);
	}
	
	@And("get request body as {string}")
	public void get_request_body_as(String jsonRequestBody) throws Exception
	{
		String jsonBody = FileUtils.readFileToString(new File("./src/test/resources/"+jsonRequestBody),"UTF-8");
		apiCommons.getBodyFromJson(jsonBody);
	}
	
	@Then("Validate the response context")
	public void validate_the_response_context(DataTable jobDetails) throws Throwable {

		
		List<Map<String, String>> data = jobDetails.asMaps(String.class,String.class);
	
		for(int i = 0 ; i < data.size(); i++) {
			String jsonPath = data.get(i).get("jsonPath");
			String expectedValue = data.get(i).get("Value");
			System.out.println(expectedValue);
			System.out.println(jsonPath);
			String actualValue = apiCommons.validateJsonResponseBody(jsonPath);
			System.out.println(actualValue);
			Assert.assertEquals(expectedValue, actualValue);
			
			
		}
		
	}
}

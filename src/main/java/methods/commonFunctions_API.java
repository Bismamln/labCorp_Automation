package methods;

import configReader.ReadPropertyFile;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;

import com.sun.tools.javac.util.Assert;


public class commonFunctions_API {

	RequestSpecification request ;
	public static Response response;

	public void getBaseURI() {

		RestAssured.baseURI = ReadPropertyFile.getAPIProperty("baseURI");
		request = RestAssured.given();

	}

	public void getHeaders(String property , String value) {

		request.header(property,value);

	}

	public void getBodyFromJson(String jsonRequestBody) {
		request = request.body(jsonRequestBody);
	}
	
	public void requestWithPathParams(String property , String value) {
		request = request.pathParam(property, value);
	}
	
	public void requestWithQueryParams(String property , String value) {
		request = request.queryParam(property, value);
	}

	public void sendRequest(String requestType , String endPoint) {

		switch(requestType) {
		case "POST" :
			if(endPoint.isEmpty()) {
				response = request.post();
			}else {
			response = request.post(endPoint);
			}
			break;

		case "PUT" :
			if(endPoint.isEmpty()) {
				response = request.put();
			}else {
			response = request.put(endPoint);
			}
			break;
			
		case "PATCH" :
			if(endPoint.isEmpty()) {
				response = request.patch();
			}else {
			response = request.patch(endPoint);
			}
			break;

		case "DELETE" :
			if(endPoint.isEmpty()) {
				response = request.delete();
			}else {
			response = request.delete(endPoint);
			}
			break;
			
		case "GET" :
			if(endPoint.isEmpty()) {
				response = request.get();
			}else {
			response = request.get(endPoint);
			}
			break;
		}

	}
	
	public void validateJsonSchema(String schemaFile) {
		
		request.body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	}

	public int verifyStatusCode() {
		int actualStatusCode = response.statusCode();
		return actualStatusCode;
		
	}
	
	public String validateJsonResponseBody(String jsonPath) {
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 String field = jsonPathEvaluator.getString(jsonPath);
	 return field;
	}





}

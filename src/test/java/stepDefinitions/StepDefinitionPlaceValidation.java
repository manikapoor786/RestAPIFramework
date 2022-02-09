package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.EnumAPIResource;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import java.io.IOException;



public class StepDefinitionPlaceValidation extends Utils {
	RequestSpecification req;
	ResponseSpecification responseSpec;
	RequestSpecification requestSpec;
	Response response;
	TestDataBuild td = new TestDataBuild();
	EnumAPIResource ear;
	static String place_id;

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException
	{
		req = given().spec(requestSpecification()).body(td.addPlacePayLoad(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_something_with_post_http_request(String resource, String method) throws Throwable
	{
		ear= EnumAPIResource.valueOf(resource);
		
		if(method.equalsIgnoreCase("POST"))
		{
			response = req.when().post(ear.getResource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response = req.when().get(ear.getResource());
		}
	}

	@Then("the API call got success with status code {string}")
	public void the_api_call_got_success_with_status_code_200(String strarg) throws Throwable
	{
		assertEquals(response.getStatusCode(), 200);
	}

	@And("{string} in response body is {string}")
	public void something_in_response_body_is_something(String keyValue, String Expectedvalue) throws Throwable
	{
		assertEquals(getJsonPath(response,keyValue), Expectedvalue);
	}

	@Then("verify place_id created maps to previous {string} using {string}")
	public void verify_place_id_created_maps_to_previous_using(String expectedName, String resource) throws Throwable {
		place_id= getJsonPath(response,"place_id");
		req=given().spec(requestSpecification()).queryParam("place_id", place_id).queryParam("key", "qaclick123");
		user_calls_something_with_post_http_request(resource,"GET");
		String actualName= getJsonPath(response,"name");
		assertEquals(actualName, expectedName);
		System.out.println("learning git branching");
	}

	@Given("Delete Place payload")
	public void delete_place_payload() throws IOException {
	    
	    req=given().spec(requestSpecification()).body(td.deletePlacePayload(place_id));
	}




}

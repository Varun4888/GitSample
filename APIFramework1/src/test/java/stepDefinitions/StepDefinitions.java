package stepDefinitions;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

import groovyjarjarantlr.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResourses;
import resources.TestDataBuild;

public class StepDefinitions extends Utils {
	RequestSpecification res;
	ResponseSpecification ResSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();	
	JsonPath js;
	static String place_id;

	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) {
	    ResSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    res = given().spec(new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").build())
	    	    .body(data.AddPlacePayload(name, language, address)).log().all();
	}

	@When("user calls {string} with post http request")
	public void user_calls_with_http_request(String resource, String method) {
	    APIResourses resourseAPI = APIResourses.valueOf(resource);
	    System.out.println(resourseAPI.getResource());

	    if(method.equalsIgnoreCase("Post"))
	    	response = res.when().post(resourseAPI.getResource());
	    else if(method.equalsIgnoreCase("Get"))
	    	response = res.when().post(resourseAPI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer statusCode) {
	    assertEquals(response.getStatusCode(), statusCode.intValue());
	}

	

	@Then("{string} is {string}")
	public void is(String KeyValue, String ExpectedValue) {
	    assertEquals( KeyValue, ExpectedValue);
	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String key, String value) {
	    System.out.println(key + " in the response body is " + value);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) {
	    // Extract place_id from the AddPlaceAPI response
	    place_id = getJsonPath(response, "place_id");
	    res = given().spec(requestSpecification).queryParam("place_id", place_id);
	    user_calls_with_http_request(resource, "GET");
	    
	    String Actualname = getJsonPath(response,"name");
	    assertEquals(Actualname, expectedName);
	    
	}
	
	
	@Given("DeletePlace payload")
	public void delete_place_payload() {
	    // Write code here that turns the phrase above into concrete actions
		res =given().spec(requestSpecification).body(data.deletePlacePayload(place_id));

	    throw new io.cucumber.java.PendingException();
	}

	// Utility method to extract value from JSON response
	public String getJsonPath(Response response, String key) {
	    String resp = response.asString();
	    js = new JsonPath(resp);
	    return js.get(key).toString();
	}
}

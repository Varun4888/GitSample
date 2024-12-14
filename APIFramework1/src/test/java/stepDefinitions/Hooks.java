package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("DeletePlace")
	
	public void beforeScenario()
	{
	StepDefinitions m=new StepDefinitions();
	if(StepDefinitions.place_id==null)
	{
		
		m.add_place_payload_with("Vikas", "Marathi", "Shirdi");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Vikas", "getPlaceAPI");
	}
	

}
}
package stepDefinitions;



import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() throws Throwable
	{
		StepDefinitionPlaceValidation s= new StepDefinitionPlaceValidation();
		if(StepDefinitionPlaceValidation.place_id==null)
		{
		s.add_place_payload("mani", "French", "Asia");
		s.user_calls_something_with_post_http_request("AddPlaceAPI", "POST");
		s.verify_place_id_created_maps_to_previous_using("mani", "getPlaceAPI");
		}
	}
}

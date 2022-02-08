Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "Post" http request
	Then the API call got success with status code "200"
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to previous "<name>" using "getPlaceAPI"

	Examples:
	|name   		 | language  | address 				      |
	|Frontline house | French-IN | 29, side layout, cohen 09  |
	
@DeletePlace @Regression	
Scenario: Verify if Delete Place functionality is working

	Given Delete Place payload
	When user calls "deletePlaceAPI" with "Post" http request
	Then the API call got success with status code "200"
	And "status" in response body is "OK"
Feature: Validating place APIs
@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
   Given Add place Payload with "<name>" "<language>" "<address>"
   When user calls "AddPlaceAPI" with "POST" http request
   Then the API call is success with status code 200
   And "status" in response body "OK"
   And "scope" in the response body is "APP"
   And verify placeID created maps to "<name>" using "getPlaceAPI"
   
   
Examples:
     |   name   | language  | address  |
     |  Krisha  | Marathi   | M.G.Road |
 #   |  Rahul   | German    | Dehu     |

@DeletePlace
 Scenario: Verify if Delete place functionality is working
 
   Given DeletePlace payload
      When user calls "deletePlaceAPI" with "POST" http request
      Then the API call is success with status code 200
      And "status" in response body "OK"
      
      
Feature: Verify User Can Add A Pet To Store

  Scenario: verifying user can a pet into the store
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "add_pet.json"
    When user performs post call
    Then verify status code is 200
    And store "id" to config value "id"
    And verify response body has a field "id" is not null
    Given user wants to call "pet/@id" end point
    When user performs get call
    Then verify status code is 200
    Given user wants to call "pet" end point

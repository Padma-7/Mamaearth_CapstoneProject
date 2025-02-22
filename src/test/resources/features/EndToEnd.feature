Feature:

  @api
  Scenario:
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "add_pet.json"
    When user performs post call
    Then verify status code is 200
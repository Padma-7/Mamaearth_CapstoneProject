Feature:

  #working
  @api
  Scenario: verify user can add a new pet to store
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


  @api
  Scenario: verify user can update a pet in the store with form data
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "add_pet.json"
    When user performs post call
    Then verify status code is 200
    And store "id" to config value "id"
    And verify response body has a field "id" is not null
    Given user wants to call "pet/@id" end point
    And set param "petId" to "id"
    And set param "name" to "pet.new.name"
    And set param "status" to "pet.new.status"
    When user performs post call
    Then verify status code is 200
    Given user wants to call "pet/@id" end point
    When user performs get call
    Then verify status code is 200


  Scenario:verify user can delete a added pet from the store
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "add_pet.json"
    When user performs post call
    Then verify status code is 200
    And store "id" to config value "id"
    And verify response body has a field "id" is not null
    Given user wants to call "pet/@id" end point
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "pet/@id" end point
    When user performs get call
    Then verify status code is 404




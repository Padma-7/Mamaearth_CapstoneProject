Feature:

  Background:
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    #And set request body from json file "add_pet.json"
    And set request body from file "add_pet.json" with random data
    When user performs post call
    Then verify status code is 200
    And verify response matches schema "create_pet_response_schema.json"
    And store "id" to config value "request.id"
    And verify response body has a field "id" is not null
    And verify response body matches request body of create pet

  #working
  @api
  Scenario: verify user can add a new pet to store
    Given user wants to call "/pet/{id}" end point
    And set path param "id" to "request.id"
    When user performs get call
    Then verify status code is 200


  @api
  Scenario Outline: verify user can update a pet in the store with form data
    Given user wants to call "/pet/{id}" end point
    And set path param "id" to "request.id"
    And set param "petId" to "request.id"
    And set param "name" to "<pet.new.name>"
    And set param "status" to "<pet.new.status>"
    When user performs post call
    Then verify status code is 200
    Given user wants to call "/pet/{id}" end point
    And set path param "id" to "request.id"
    When user performs get call
    Then verify status code is 200

    Examples:
     |pet.new.name| |pet.new.status|
      |doggy       ||available     |
    |pinky       ||unavailable   |
     |subbu       ||available     |
     |nancy       ||unavailable   |


  Scenario:verify user can delete a added pet from the store
    Given user wants to call "/pet/{id}" end point
    And set path param "id" to "request.id"
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "/pet/{id}" end point
    And set path param "id" to "request.id"
    When user performs get call
    Then verify status code is 404

    @api
    Scenario: verify user cannot get pet details with id
      Given user wants to call "/pet/89902" end point
      When user performs get call
      Then verify status code is 404



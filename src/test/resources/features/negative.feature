Feature:

  @api
  Scenario: verify user cannot perform order operation with negative or zero quantity
    Given user wants to call "store/order" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "store_order_invalid.json"
    Then verify "quantity" value in file "store_order_invalid.json" is less than 1
    When user performs post call
    Then verify status code is 400

  @api
  Scenario:
    Given user wants to call "store/inventory" end point
    When user performs get call
    Then verify status code is 200
    And store "available" to config value "previous.available.pet"
    Given user wants to call "pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "add_pet.json"
    When user performs post call
    Then verify status code is 200
    Given user wants to call "store/inventory" end point
    When user performs get call
    Then verify status code is 200
    And store "available" to config value "current.available.pet"
    And verify count of "previous.available.pet" with "current.available.pet" after adding a new pet to store


  @api
  Scenario: verify user cannot perform create user operation with empty body
    Given user wants to call "user" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "empty_user.json"
    When user performs post call
    Then verify status code is 400



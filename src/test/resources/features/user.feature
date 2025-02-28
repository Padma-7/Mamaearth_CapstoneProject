Feature:

  Background:
    Given user wants to call "user" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "create_user.json"
    #And set request body from file "create_user.json" with random data
    When user performs post call
    Then verify status code is 200
    And store "username" of request from file "create_user.json" body to config value "username"
    And store "password" of request from file "create_user.json" body to config value "password"

  @api
  Scenario: verify user can create new user
    Given user wants to call "user/{username}" end point
    And set path param "username" to "username"
    When user performs get call
    Then verify status code is 200



  @api
  Scenario: verify user can perform delete operation of the created user
    Given user wants to call "user/{username}" end point
    And set path param "username" to "username"
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "user/{username}" end point
    And set path param "username" to "username"
    When user performs get call
    Then verify status code is 404

  @api
  Scenario: verify user can perform login operation
    Given user wants to call "user/login" end point
    And set param "username" to "username"
    And set param "password" to "password"
    When user performs get call
    Then verify status code is 200


  @api
  Scenario: verify user can perform logout operation on the current logged in user session
    Given user wants to call "user/login" end point
    And set param "username" to "username"
    And set param "password" to "password"
    When user performs get call
    Then verify status code is 200
    Given user wants to call "user/logout" end point
    When user performs get call
    Then verify status code is 200

  @api
  Scenario: verify user can update operation on the created user
    Given user wants to call "user/{username}" end point
    And set path param "username" to "username"
    When user performs get call
    Then verify status code is 200
    Given user wants to call "user/{username}" end point
    And set header "Content-Type" to "application/json"
    And set path param "username" to "username"
    And set request body from json file "update_user.json"
    When user performs put call
    Then verify status code is 200
    Given user wants to call "user/{username}" end point
    And set path param "username" to "username"
    When user performs get call
    Then verify status code is 200













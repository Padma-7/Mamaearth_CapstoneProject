Feature:

  #not completed
  @api
  Scenario:
    Given user wants to call "user/createWithList" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "create_user.json"
    When user performs post call
    Then verify status code is 200

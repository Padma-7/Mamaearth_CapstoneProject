Feature:
  Background:
    Given user wants to call "store/order" end point
    And set header "Content-Type" to "application/json"
    And set request body from json file "store_order.json"
    When user performs post call
    Then verify status code is 200
    And verify response matches schema "store_order_response_schema.json"
    And verify response body has a field "id" is not null
    And store "id" to config value "order.id"


    @api
    Scenario: verify user can place a order
      Given user wants to call "store/order/{id}" end point
      And set path param "id" to "order.id"
      When user performs get call
      Then verify status code is 200


  @api
  Scenario: verify user can delete placed order
    Given user wants to call "store/order/{id}" end point
    And set path param "id" to "order.id"
    And set header "Content-Type" to "application/json"
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "store/order/{id}" end point
    And set path param "id" to "order.id"
    When user performs get call
    Then verify status code is 404

    Scenario: verify user cannot perform create operation without body









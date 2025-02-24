@android
Feature: Verifying Order Placing Functionality

  Background:
    Given user opens the website
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user select first product with keyword "keyword"
    Then verify the title has the keyword "keyword"
    When user add the product to cart
    And clicks on cart icon
    Then verify user is on cart page
    And verify user gets the price summary
    When user clicks on add address button
    Then verify user is on address page

    #working in web
    @web@android
  Scenario: Verify user can place order and checkout
    When user fills address details
    And selects address type as "home"
    And clicks on save address button
    Then verify address is saved
    When user click on proceed to pay
    Then verify user is on payment page



      #working
      @web
  Scenario: Verify user cannot place order with invalid address details
    When user fills invalid address details
    And selects address type as "home"
    And clicks on save address button
    Then verify address is saved
    When user click on proceed to pay
    Then verify user is on payment page
    When user selects cash on delivery
    And clicks on place order button
    Then verify user cannot place order

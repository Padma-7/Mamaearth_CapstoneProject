Feature: Verify Order Placing Functionality

  Scenario: Verify user can place order and checkout
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
    When user fills address details
    And selects address type as "home"
    And clicks on save address button
    Then verify address is saved
    When user click on proceed to pay
    Then verify user is on payment page
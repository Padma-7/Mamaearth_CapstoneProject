@android
#working
Feature: Cart Number Update functionality

  Scenario: Verify the cart number updates based on the action
    Given user opens the website
    Then verify user is on home page
    And verify cart is empty
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user selects the first product
    And clicks on product add to cart
    Then verify cart quantity shows one
    And user goes back to product listing page
    When user increases the quantity of the same product by 1
    Then verify cart quantity has increased by 1
    When user adds 1 different products to cart
    Then verify cart quantity has increased by 1
    When user remove that product
    Then verify cart quantity has decreased

Feature: Verify the cart number updates based on the action
  #working

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on cart icon
    And verify cart is empty
    Then user goes to home page

  Scenario: Verify user adds a product to cart and increases the quantity of the same product but the cart number stays 1
    When user adds the first product to cart
    Then verify added to cart popup is displayed
    When user increases the quantity of the same product by "2"
    Then verify cart quantity shows one

  Scenario: Verify user add different products to cart and cart quantity increases likewise
    When user adds "2" different products to cart
    Then verify cart quantity has updated to "2"

  Scenario: Verify user can add a products to cart and delete product and quantity is updated likewise
    When user adds the first product to cart
    Then verify added to cart popup is displayed
    Then verify cart quantity shows one
    When user remove that product
    When user clicks on cart icon
    And verify cart is empty



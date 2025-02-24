Feature: Verifying product does not stay in cart without login

  #working
  @web @android
  Scenario: user adds a product to cart without login
    Given user opens the website
    Then verify user is on home page
    When user selects the first product from home page
    And clicks on product add to cart

  @web @android
  Scenario: verifying product not in cart when opened again
    Given user opens the website
    Then verify user is on home page
    When user clicks on cart icon
    And verify cart is empty

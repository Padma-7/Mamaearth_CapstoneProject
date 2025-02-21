Feature: Verifying product does not stay in cart without login

  #working
  @web @android
  Scenario: user adds a product to cart without login
    Given user opens the website
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user select first product with keyword "keyword"
    Then verify the title has the keyword "keyword"
    When user add the product to cart

  @web @android
  Scenario: verifying product not in cart when opened again
    Given user opens the website
    Then verify user is on home page
    When user clicks on cart icon
    And verify cart is empty

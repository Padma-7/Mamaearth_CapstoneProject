@android
#not completed
Feature: Validate Total Price in Cart

  Scenario: User adds multiple items to the cart and verifies the total price
    Given user opens the website
    Then verify user is on home page
    When user goes to specific category "specific.category" products
    And clicks on view all button
    Then verify user is on product listing page
    When user selects the first product
    And clicks on product add to cart
    And clicks on cart icon
    And user goes back to product listing page
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user selects the first product
    And clicks on product add to cart
    And clicks on cart icon

    #When user clicks on add to cart button of first item
    #And clicks on cart icon
    #Then verify user is on cart page
    #When user increases the quantity of the product to "4"
    #Then verify the total price
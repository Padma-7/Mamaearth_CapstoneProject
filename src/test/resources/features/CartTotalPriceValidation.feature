Feature: Validate Total Price in Cart
#not completed

  Scenario: User adds multiple items to the cart and verifies the total price
    Given user opens the website
    Then verify user is on home page
    When user goes to baby care products
    And clicks on view all button of baby care products
    Then verify user is on product listing page
    And selects baby body lotion
    When user selects the first product
    Then verify user is on product details page
    And clicks on add to cart button
    And clicks on home icon
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page

    #When user clicks on add to cart button of first item
    #And clicks on cart icon
    #Then verify user is on cart page
    #When user increases the quantity of the product to "4"
    #Then verify the total price
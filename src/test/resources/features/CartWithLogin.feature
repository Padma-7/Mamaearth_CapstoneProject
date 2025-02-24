Feature: Verifying product stays in cart with login

  #working
  @android
  Scenario: user adds a product to cart after login in android
    Given user opens the website
    Then verify user is on home page
    When user click on profile icon
    Then verify user is on profile page
    When user clicks on login link
    Then verify user is on login page
    When user enters valid phone number "login.phone"
    And clicks on continue button
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user login is successful
    When user goes to home page
    When user selects the first product from home page
    Then clicks on product add to cart
    And user gets the product name
    When user click on the profile icon from product page
    And clicks on logout button
    When user click on profile icon
    Then verify user logged out successful
    When user clicks on login link
    When user enters valid phone number "login.phone"
    And clicks on continue button
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user login is successful
    When user goes to home page
    When user search for product "desired.product"
    When user selects the first product
    And user clicks on cart icon from product page
    Then verify product name is displayed there

    #working
  @web
  Scenario: user adds a product to cart after login in web
    Given user opens the website
    Then verify user is on home page
    When user clicks on login icon
    Then verify user is on login page
    When user enters valid phone number "login.phone"
    And clicks on login with otp
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user phone number is present in login page
    And user goes to home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user select first product with keyword "keyword"
    Then verify the title has the keyword "keyword"
    When user add the product to cart
    And user gets the product name
    And clicks on logout link
    Then verify user logged out successfully
    When user clicks on login icon
    Then verify user is on login page
    When user enters valid phone number "login.phone"
    And clicks on login with otp
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user phone number is present in login page
    And user goes to home page
    When user clicks on cart icon
    Then verify product name is displayed there

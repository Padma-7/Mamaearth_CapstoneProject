Feature: Login and Logout Functionality
  #working

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on login icon
    Then verify user is on login page

  Scenario: verify user can login with valid phone number
    When user enters valid phone number "login.phone"
    And clicks on login with otp
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user phone number is present in login page

  Scenario: verify user can logout
    When user enters valid phone number "login.phone"
    And clicks on login with otp
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user phone number is present in login page
    And clicks on logout link
    Then verify user logged out successfully









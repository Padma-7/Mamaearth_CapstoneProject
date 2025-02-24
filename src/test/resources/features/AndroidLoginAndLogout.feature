Feature: Login and Logout Functionality

  #working
  Background:
    Given user opens the website
    Then verify user is on home page
    When user click on profile icon
    Then verify user is on profile page
    When user clicks on login link
    Then verify user is on login page

  Scenario: verify user can login with valid phone number
    When user enters valid phone number "login.phone"
    And clicks on continue button
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user login is successful

  Scenario: verify user can logout
    When user enters valid phone number "login.phone"
    And clicks on continue button
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user login is successful
    And clicks on logout button
    Then verify user is on home page
    When user click on profile icon
    Then verify user is on profile page
    Then verify user logged out successful



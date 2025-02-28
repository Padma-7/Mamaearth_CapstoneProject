@android
#working
Feature: Adding Valid And Invalid Address functionality

  Background:
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
    When selects addresses option
    Then verify user is on address page

  Scenario:Verify user can add address
    When user clicks on + add address button
    Then verify user is on address filling page
    When user fills address details
    And clicks on save address button
    Then verify address is added

  Scenario: Verify user cannot add same address more than once
    When user clicks on + add address button
    Then verify user is on address filling page
    When user fills address details
    And clicks on save address button
    Then verify address is added





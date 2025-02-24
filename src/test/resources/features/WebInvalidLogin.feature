Feature: Verifying Invalid Login Functionality
  #working

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on login icon
    Then verify user is on login page

  Scenario Outline: verify user cannot login with invalid phone number
    When user enters invalid phone number "<login.phone>"
    And clicks on login with otp
    Then verify error message is displayed

    Examples:
      | login.phone |
      | 948065     |
      | 99345678    |
      | 76195138    |
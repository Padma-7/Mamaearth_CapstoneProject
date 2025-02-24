Feature: Verifying Invalid Login Functionality
  #working
  Background:
    Given user opens the website
    Then verify user is on home page
    When user click on profile icon
    Then verify user is on profile page
    When user clicks on login link
    Then verify user is on login page

  Scenario Outline: verify user cannot login with invalid phone number
    When user enters invalid phone number "<login.phone>"
    And clicks on continue button
    Then verify error message is displayed

    Examples:
      | login.phone |
      | 777788      |
      | 52345678    |
      | 76195138    |
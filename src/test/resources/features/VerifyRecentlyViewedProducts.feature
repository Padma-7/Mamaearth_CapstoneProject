@web
Feature: Verifying Recently Viewed Products
  Background:
    Given user opens the website
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user select first product with keyword "keyword"
    Then verify the title has the keyword "keyword"
#working
  @web
  Scenario: verify the viewed product is in the recently in web
    When user clicks on search bar
    Then verify recently viewed is displayed
    And verify the product viewed by user is under recently viewed list

    @android
    Scenario: verify the viewed product is in the recently in android
      When user clicks on cart icon
      Then verify user is on cart page
      Then verify recently viewed is displayed
      And verify the product viewed by user is under recently viewed list

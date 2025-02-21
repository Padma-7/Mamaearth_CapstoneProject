@web
Feature: Verifying Recently Viewed Products
#working
  Scenario: verify the viewed product is in the recently
    Given user opens the website
    Then verify user is on home page
    When user search for product "desired.product"
    Then verify user is on product listing page
    When user select first product with keyword "keyword"
    Then verify the title has the keyword "keyword"
    When user clicks on search bar
    Then verify recently viewed is displayed
    And verify the product viewed by user is under recently viewed list

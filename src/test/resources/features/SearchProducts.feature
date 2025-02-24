Feature: Search Products and verify the results

  #working
  Background:
    Given user opens the website
    Then verify user is on home page

  @android @web
  Scenario: Search for a valid product
    When user search for product "desired.product"
    Then verify user see search results related to "desired.product"

  @web @android
  Scenario: Search for an invalid product
    When user search for product "invalid.product"
    Then verify user see the invalid message

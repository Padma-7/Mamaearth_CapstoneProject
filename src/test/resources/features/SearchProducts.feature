@android @web
#working
Feature: Search Products and Verifying the Results functionality

  Background:
    Given user opens the website
    Then verify user is on home page

  Scenario Outline: Search for a valid product
    When user search for product name "<desired.product>"
    Then verify user see search results related to "<desired.product>"

    Examples:
      | desired.product |
      | face wash       |
      | face cream      |

  Scenario Outline: Search for an invalid product
    When user search for product name "<invalid.product>"
    Then verify user see the invalid message

    Examples:
      | invalid.product |
      | abcd            |
      | xyz             |
      | 12345           |
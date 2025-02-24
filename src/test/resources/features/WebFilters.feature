Feature: Verify Filter Functionality
  #working

  Background:
    Given user opens the website
    Then verify user is on home page

  Scenario: verify products are sorted by price - low to high
    When user clicks on "Ingredient" category
    And selects "Vitamin C" option
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects price low to high
    Then verify products are sorted by price low to high

  Scenario: verify products are sorted by price - high to low
    When user clicks on baby category
    And selects "Baby Shampoo" option
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects price high to low
    Then verify products are sorted by price high to low

  Scenario: verify products are sorted by ratings
    When user clicks on "Ingredient" category
    And selects "Onion" option
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects by rating option
    Then verify products are sorted by ratings

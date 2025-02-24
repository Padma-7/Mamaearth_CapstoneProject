Feature: Verify Filter Functionality
  #working

  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on category icon
    Then verify user is on category page

  Scenario: verify products are sorted by price - low to high
    When user selects specific ingredient "Salicylic Acid"
    And selects "Salicylic Acid cream" under specific ingredient
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects price low to high
    Then verify products are sorted by price low to high

  Scenario: verify products are sorted by price - high to low
    When user selects specific ingredient "Apple Cider"
    And selects "Apple Cider Products" under specific ingredient
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects price high to low
    Then verify products are sorted by price high to low

  Scenario: verify products are sorted by ratings
    When user selects specific ingredient "Onion"
    And selects "Onion Hair Oil" under specific ingredient
    Then verify user is on product listing page
    When user clicks on sort icon
    And selects by rating option
    Then verify products are sorted by ratings





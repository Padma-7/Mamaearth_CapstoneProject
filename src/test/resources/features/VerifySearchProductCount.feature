Feature: Verifying Total Number Of Products

  Scenario: verify total count displayed should match the actual number of products listed
    Given user opens the website
    Then verify user is on home page
    When user clicks on search bar
    Then verify trending searches is displayed
    When user selects "Lipstick" from trending searches
    Then verify user is on product listing page
    #And verify all products contain the trending search keyword "Lipstick"
    And the total count displayed should match the actual number of products listed
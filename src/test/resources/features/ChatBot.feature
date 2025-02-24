Feature: Customer Support Chatbot
  #working web
  Background:
    Given user opens the website
    Then verify user is on home page
    When user clicks on chat icon
    Then verify user is on chat tab
    Then user fills in the details "chatbot.fullName" "chatbot.email" "chatbot.phoneNumber"
    And user clicks on send query
    Then verify chatbot responds with welcome message

  Scenario: Ask a question in chatbot for product recommendation
    When user type in a product recommendation question "chatbot.product.recommendation"
    Then verify chatbot responds with product recommendations for the same
@web
#working
Feature: Verifying user can edit their profile


  Scenario: user edits the information in profile and verifying the changes are saved in web
    Given user opens the website
    Then verify user is on home page
    When user clicks on login icon
    Then verify user is on login page
    When user enters valid phone number "login.phone"
    And clicks on login with otp
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user phone number is present in login page
    #new
    When user click on Edit profile option
    Then change the "profile.credential.key" to "profile.credential.value"
    And save the changes
    Then verify the changes are applied in profile page for "profile.credential.key"


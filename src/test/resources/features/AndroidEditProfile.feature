git Feature: Verifying user can edit their profile

  #working
  Scenario: user edits the information in profile and verifying the changes are saved in android
    Given user opens the website
    Then verify user is on home page
    When user click on profile icon
    Then verify user is on profile page
    When user clicks on login link
    Then verify user is on login page
    When user enters valid phone number "login.phone"
    And clicks on continue button
    Then user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify user login is successful

    #new
    When user click on Edit profile option
    Then change the "profile.credential.key" to "profile.credential.value"
    And save the changes
    Then verify the changes are applied in profile page for "profile.credential.key"
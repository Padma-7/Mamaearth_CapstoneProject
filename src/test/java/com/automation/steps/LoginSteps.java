package com.automation.steps;

import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user enters valid phone number {string}")
    public void userEntersValidPhoneNumber(String phoneNumber) {
        loginPage.enterPhoneNumber(ConfigReader.getConfigValue(phoneNumber));
    }

    @And("clicks on login with otp")
    public void clicksOnLoginWithOtp() {
        loginPage.clickOnLoginWithOTPBtn();
    }

    @Then("user should be redirected to the OTP details page")
    public void userShouldBeRedirectedToTheOTPDetailsPage() {
        Assert.assertTrue(loginPage.isOTPDetailsPageDisplayed());
    }

    @When("user enter otp and click on submit button")
    public void userEnterOtpAndClickOnSubmitButton() {
        loginPage.enterOTP();
    }

    @Then("verify user phone number is present in login page")
    public void verifyUserPhoneNumberIsPresentInLoginPage() {
        Assert.assertTrue(loginPage.isPhoneNumberDisplayed());
    }

    @And("clicks on logout link")
    public void clicksOnLogoutLink() {
        loginPage.clickOnLogoutLink();
    }

    @Then("verify user logged out successfully")
    public void verifyUserLoggedOutSuccessfully() {
        Assert.assertTrue(loginPage.isLoggedOut());
    }

    @Then("verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @When("clicks on continue button")
    public void clicks_on_continue_button() {
        loginPage.clickOnContinueBtn();
    }

    @When("user enters invalid phone number {string}")
    public void userEntersInvalidPhoneNumber(String phoneNumber) {
        loginPage.enterPhoneNumber(phoneNumber);
    }



}

package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProfileSteps extends BaseSteps{

    @Then("verify user is on profile page")
    public void verifyUserIsOnProfilePage() {
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
       // CucumberReportManager.attachScreenshot();

    }

    @Then("verify user login is successful")
    public void verify_user_login_is_successful() {
        Assert.assertFalse(profilePage.isLoginBtnNotDisplayed());
      //  CucumberReportManager.attachScreenshot();

    }


    @When("user clicks on login link")
    public void userClicksOnLoginLink() {
        profilePage.clickLoginIcon();
    }

    @Then("verify user logged out successful")
    public void verifyUserLoggedOutSuccessful() {
        Assert.assertTrue(profilePage.userLogoutSuccessful());
       // CucumberReportManager.attachScreenshot();

    }

    @And("clicks on logout button")
    public void clicksOnLogoutButton() {
        profilePage.clickLogoutIcon();
    }


    @When("selects addresses option")
    public void selectsAddressesOption() {
        profilePage.selectAddresses();
    }
    //new
    @When("user click on Edit profile option")
    public void userClickOnEditProfileOption() {
        profilePage.clickOnEditProfile();
    }

    @Then("change the {string} to {string}")
    public void changeTheTo(String key, String value) {
        profilePage.changeCredentials(ConfigReader.getConfigValue(key),ConfigReader.getConfigValue(value));
    }

    @And("save the changes")
    public void saveTheChanges() {
        profilePage.saveChanges();
    }

    @Then("verify the changes are applied in profile page for {string}")
    public void verifyTheChangesAreAppliedInProfilePage(String key) {
        Assert.assertTrue(profilePage.changesApplied(ConfigReader.getConfigValue(key)));
    }
}

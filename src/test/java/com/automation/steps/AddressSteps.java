package com.automation.steps;

import com.automation.utils.CucumberReportManager;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressSteps extends BaseSteps{
    @Then("verify user is on address page")
    public void verifyUserIsOnAddressPage() {
        Assert.assertTrue(addressPage.isAddressPageDisplayed());
        CucumberReportManager.attachScreenshot();

    }

    @When("user fills address details")
    public void userFillsAddressDetails() {
        addressPage.fillAddressDetails();
    }

    @And("selects address type as {string}")
    public void selectsAddressTypeAs(String addressType) {
        addressPage.selectAddressType(addressType);
    }

    @And("clicks on save address button")
    public void clicksOnSaveAddressButton() {
        addressPage.clickOnSaveAddressButton();
    }

    @Then("verify address is saved")
    public void verifyAddressIsSaved() {
        Assert.assertTrue(addressPage.isAddressSaved());
        CucumberReportManager.attachScreenshot();

    }

    @When("user clicks on + add address button")
    public void userClicksOnAddAddressButton() {
        addressPage.clickOnAddAddressButton();
    }

    @And("verify user is on address filling page")
    public void verifyUserIsOnAddressFillingPage() {
        Assert.assertTrue(addressPage.isAddressFillingPageDisplayed());
        CucumberReportManager.attachScreenshot();

    }

    @Then("verify address is added")
    public void verifyAddressIsAdded() {
        Assert.assertTrue(addressPage.isAddressAdded());
        CucumberReportManager.attachScreenshot();

    }

    @When("user fills invalid address details")
    public void userFillsInvalidAddressDetails() {
        addressPage.fillInvalidAddress();
    }

    @Then("verify address is not added")
    public void verifyAddressIsNotAdded() {
        Assert.assertFalse(addressPage.isAddressAdded());
        CucumberReportManager.attachScreenshot();

    }
}

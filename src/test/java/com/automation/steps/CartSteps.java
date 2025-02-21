package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps extends BaseSteps{

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @And("verify user gets the price summary")
    public void verifyUserGetsThePriceSummary() {
        Assert.assertTrue(cartPage.isPriceSummaryDisplayed());
    }

    @When("user click on proceed to pay")
    public void userClickOnProceedToPay() {
        cartPage.clickOnProceedToPay();
    }

    @When("user clicks on add address button")
    public void userClicksOnAddAddressButton() {
        cartPage.clickOnAddAddressButton();
    }


    @When("user increases the quantity of the product to {string}")
    public void userIncreasesTheQuantityOfTheProductTo(String quantity) {
        cartPage.increaseTheQuantity(quantity);
    }


}

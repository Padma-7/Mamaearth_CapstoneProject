package com.automation.steps;

import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentSteps extends BaseSteps{
    @Then("verify user is on payment page")
    public void verifyUserIsOnPaymentPage() {
        Assert.assertTrue(paymentPage.isPaymentPageDisplayed());
        CucumberReportManager.attachScreenshot();

    }

    @When("user selects cash on delivery")
    public void userSelectsCashOnDelivery() {
        paymentPage.selectCashOnDelivery();
    }

    @And("clicks on place order button")
    public void clicksOnPlaceOrderButton() {
        paymentPage.clickOnPlaceOrderBtn();
    }

    @Then("verify user cannot place order")
    public void verifyUserCannotPlaceOrder() {
        Assert.assertTrue(paymentPage.isConfirmationMsgDisplayed());
        CucumberReportManager.attachScreenshot();

    }
}

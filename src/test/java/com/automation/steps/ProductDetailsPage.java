package com.automation.steps;

import com.automation.pages.common.BasePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsPage extends BaseSteps {


    @And("verify the title has the keyword {string}")
    public void verifyTheTitleHasTheKeyword(String keyword) {
        Assert.assertTrue(productDetailsPage.isTitleWithKeyword(ConfigReader.getConfigValue(keyword)));
    }

    @When("user add the product to cart")
    public void userAddTheProductToCart() {
        productDetailsPage.ClickOnAddToCartBtn();
    }

    @And("clicks on cart icon")
    public void clicksOnCartIcon() {
        productDetailsPage.clickOnCartIcon();
    }

    @Then("verify user is on product details page")
    public void verifyUserIsOnProductDetailsPage() {
        Assert.assertTrue(productDetailsPage.isProductDetailsPageDisplayed());
    }

    @And("clicks on add to cart button")
    public void clicksOnAddToCartButton() {
        productDetailsPage.ClickOnAddToCartBtn();

    }
}

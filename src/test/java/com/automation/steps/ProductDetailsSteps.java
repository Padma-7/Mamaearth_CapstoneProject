package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsSteps extends BaseSteps {


    @And("verify the title has the keyword {string}")
    public void verifyTheTitleHasTheKeyword(String keyword) {
        Assert.assertTrue(productDetailsPage.isTitleWithKeyword(ConfigReader.getConfigValue(keyword)));
    }

    @When("user add the product to cart")
    public void userAddTheProductToCart() {
        productDetailsPage.ClickOnAddToCartBtn1();
    }

    @And("clicks on cart icon")
    public void clicksOnCartIcon() {
        productDetailsPage.clickOnCartIcon();
    }

    @And("clicks on add to cart")
    public void clicksOnAddToCart() {
        productDetailsPage.ClickOnAddToCartBtn1();
    }

    @And("user goes back to product listing page")
    public void userGoesBackToProductListingPage() {
        productDetailsPage.clickOnBackButton();
    }

    @And("clicks on product add to cart")
    public void clicksOnItsAddToCart() {
        productDetailsPage.clickOnProductAddToCartBtn();
    }





    @And("user gets the product name")
    public void userGetsTheProductName() {
        ConfigReader.setConfigValue("productAddedToCart",productDetailsPage.getProductName());
    }

    @When("user click on the profile icon from product page")
    public void userClickOnTheProfileIconFromProductPage() {
        productDetailsPage.clickOnProfileIcon();
    }

    @And("user clicks on cart icon from product page")
    public void userClicksOnCartIconFromProductPage() {
        productDetailsPage.clickOnCartIcon();
    }
}

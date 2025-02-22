package com.automation.steps;

import com.automation.pages.common.BasePage;
import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsPage extends BaseSteps {


    @And("verify the title has the keyword {string}")
    public void verifyTheTitleHasTheKeyword(String keyword) {
        Assert.assertTrue(productDetailsPage.isTitleWithKeyword(ConfigReader.getConfigValue(keyword)));
        CucumberReportManager.attachScreenshot();

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
        CucumberReportManager.attachScreenshot();

    }

    @And("clicks on add to cart button")
    public void clicksOnAddToCartButton() {
        productDetailsPage.ClickOnAddToCartBtn();

    }

    @And("user goes back to product listing page")
    public void userGoesBackToProductListingPage() {
        productDetailsPage.clickOnBackButton();
    }
    @And("clicks on product add to cart")
    public void clicksOnItsAddToCart() {
        productDetailsPage.clickOnProductAddToCartBtn();
    }

    @And("clicks on add to cart")
    public void clicksOnAddToCart() {
        productDetailsPage.ClickOnAddToCartBtn1();
    }

    @And("user clicks on cart icon from product page")
    public void userClicksOnCartIconFromProductPage() {
        productDetailsPage.clickOnCartIcon();
    }

    @And("user gets the product name")
    public void userGetsTheProductName() {
        ConfigReader.setConfigValue("productAddedToCart",productDetailsPage.getProductName());
    }
}

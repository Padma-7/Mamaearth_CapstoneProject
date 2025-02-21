package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingSteps extends BaseSteps{

    @Then("verify user is on product listing page")
    public void verifyUserIsOnProductListingPage() {
        Assert.assertTrue(productListingPage.isProductListingPageDisplayed());
    }

    @When("user select first product with keyword {string}")
    public void userSelectFirstProductWithKeyword(String keyword) {
        productListingPage.clickOnFirstProductWithKeyword(ConfigReader.getConfigValue(keyword));
    }


    @When("user clicks on sort icon")
    public void userClicksOnSortIcon() {
        productListingPage.clickOnSortIcon();
    }

    @And("selects price low to high")
    public void selectsPriceLowToHigh() {
        productListingPage.selectLowToHighOption();
    }

    @Then("verify products are sorted by price low to high")
    public void verifyProductsAreSortedByPriceLowToHigh() {
        Assert.assertTrue(productListingPage.isSortedLowToHigh());
    }

    @And("selects price high to low")
    public void selectsPriceHighToLow() {
        productListingPage.selectHighToLowOption();

    }

    @Then("verify products are sorted by price high to low")
    public void verifyProductsAreSortedByPriceHighToLow() {
        Assert.assertTrue(productListingPage.isSortedHighToLow());

    }

    @And("selects by rating option")
    public void selectsByRatingOption() {
        productListingPage.selectByRateOption();
    }

    @Then("verify products are sorted by ratings")
    public void verifyProductsAreSortedByRatings() {
        Assert.assertTrue(productListingPage.isSortedByRatings());
    }

    @When("user clicks on add to cart button of first item")
    public void userClicksOnAddToCartButtonOfFirstItem() {
        productListingPage.addToCartFirstItem();
    }

    @And("selects baby body lotion")
    public void selectsBabyBodyLotion() {
        productListingPage.selectBabyBodyLotion();
    }

    @When("user selects the first product")
    public void userSelectsTheFirstProduct() {
        productListingPage.selectFirstItem();
    }

    @And("verify all products contain the trending search keyword {string}")
    public void verifyAllProductsContainTheTrendingSearchKeyword(String keyword) {
        Assert.assertTrue(productListingPage.isProductsTitleWithKeyword(keyword));
    }

    @And("the total count displayed should match the actual number of products listed")
    public void theTotalCountDisplayedShouldMatchTheActualNumberOfProductsListed() {
        Assert.assertTrue(productListingPage.isCountEqualsTotalProducts());
    }
}

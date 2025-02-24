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
        //CucumberReportManager.attachScreenshot();

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
       // CucumberReportManager.attachScreenshot();

    }

    @And("selects price high to low")
    public void selectsPriceHighToLow() {
        productListingPage.selectHighToLowOption();

    }

    @Then("verify products are sorted by price high to low")
    public void verifyProductsAreSortedByPriceHighToLow() {
        Assert.assertTrue(productListingPage.isSortedHighToLow());
        //CucumberReportManager.attachScreenshot();


    }

    @And("selects by rating option")
    public void selectsByRatingOption() {
        productListingPage.selectByRateOption();
    }

    @Then("verify products are sorted by ratings")
    public void verifyProductsAreSortedByRatings() {
        Assert.assertTrue(productListingPage.isSortedByRatings());
       // CucumberReportManager.attachScreenshot();

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
      //  CucumberReportManager.attachScreenshot();

    }

    @And("the total count displayed should match the actual number of products listed")
    public void theTotalCountDisplayedShouldMatchTheActualNumberOfProductsListed() {
        Assert.assertTrue(productListingPage.isCountEqualsTotalProducts());
    }

    @Then("verify user see search results related to {string}")
    public void verifyUserSeeSearchResultsRelatedTo(String product) {
        Assert.assertTrue(productListingPage.isSearchResultFound(ConfigReader.getConfigValue(product)));
       // CucumberReportManager.attachScreenshot();

    }
    @Then("verify user see the invalid message")
    public void verifyUserSeeAMessage() {
        Assert.assertTrue(productListingPage.isInvalidMessageDisplayed());
       // CucumberReportManager.attachScreenshot();

    }

    @Then("verify cart quantity has increased by {string}")
    public void verifyCartQuantityHasIncreased(String number) {
        productListingPage.clickOnFirstItem();
        Assert.assertTrue(productDetailsPage.HasCartQtyIncreased(number));
       // CucumberReportManager.attachScreenshot();

        productDetailsPage.clickOnBackButton();
       // CucumberReportManager.attachScreenshot();


    }

    @When("user click on the profile icon from product page")
    public void userClickOnTheProfileIconFromProductPage() {
        productDetailsPage.clickOnProfileIcon();
    }

    @Then("verify cart quantity has decreased")
    public void verifyCartQuantityHasDecreased() {
        productListingPage.clickOnFirstItem();
        Assert.assertTrue(productDetailsPage.HasCartQtyDecreased());
        //CucumberReportManager.attachScreenshot();
        productDetailsPage.clickOnBackButton();
    }


}

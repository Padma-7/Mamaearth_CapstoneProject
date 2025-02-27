package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps{


    @Given("user opens the website")
    public void user_opens_the_website() {
        homePage.openApplication();
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());


    }

    @When("user clicks on login icon")
    public void userClicksOnLoginIcon() {
        homePage.clickOnLoginIcon();
    }

    @When("user click on profile icon")
    public void userClickOnProfileIcon() {
        homePage.clickOnProfileIcon();
    }

    @When("user search for product {string}")
    public void userSearchForProduct(String desiredProduct) {
        homePage.searchForProduct(ConfigReader.getConfigValue(desiredProduct));

    }

    @When("user clicks on chat icon")
    public void userClicksOnChatIcon() {
        homePage.clickOnChatBotIcon();
    }

    @And("selects {string} option")
    public void selectsOption(String ingredientOption) {
        homePage.selectDesiredIngredient(ingredientOption);
    }

    @When("user clicks on all products option")
    public void userClicksOnAllProductsOption() {
        homePage.clickOnAllProductsOption();
    }

    @When("user clicks on {string} category")
    public void userClicksOnCategory(String desiredCategory) {
        homePage.clickOnIngredientCategory();
        //homePage.clickOnCategory(desiredCategory);
    }

    @When("user clicks on category icon")
    public void userClicksOnCategoryIcon() {
        homePage.clickOnCategoryIcon();
    }

    @When("user clicks on baby category")
    public void userClicksOnBabyCategory() {
        homePage.clickOnBabyCategory();
    }

    @When("selects manage address option")
    public void selectsManageAddressOption() {
        homePage.selectManageAddressOption();
    }

    @When("user goes to specific category {string} products")
    public void userGoesToSpecificCategory(String category) {
        homePage.goToSpecificCategory(category);
    }

    @And("clicks on view all button")
    public void clicksOnViewAllButton() {
        homePage.clickOnViewAllBtn();
    }

    @And("clicks on home icon")
    public void clicksOnHomeIcon() {
        homePage.clickOnHomeIcon();
    }

    @When("user clicks on search bar")
    public void userClicksOnSearchBar() {
        homePage.clickOnSearchBar();
    }

    @When("user selects the first product from home page")
    public void userSelectsTheFirstProductFromHomePage() {
        //homePage.userSelectFirstProductFromHomePage();
        homePage.addToCartFirstItem();
    }

    @When("user clicks on cart icon")
    public void userClicksOnCartIcon() {
        productDetailsPage.clickOnCartIcon();
    }



    @When("user adds the first product to cart")
    public void userAddsTheFirstProductToCart() {
        homePage.addToCartFirstItem();
    }

    @Then("verify added to cart popup is displayed")
    public void verifyAddedToCartPopupIsDisplayed() {
        Assert.assertTrue(homePage.isPopUpDisplayed());

    }

    @When("user increases the quantity of the same product by {int}")
    public void userIncreasesTheQuantityOfTheProductTo(int productNumber) {
        homePage.addSameProductToCart(productNumber);
    }

    @Then("verify cart quantity shows one")
    public void verifyCartQuantityShows() {
        Assert.assertTrue(homePage.verifyCartNumberShowsOne());

    }

    @When("user adds {int} different products to cart")
    public void userAddsDifferentProductsToCart(int productNumber) {
        homePage.addProductToCart(productNumber);
    }

    @Then("verify cart quantity has updated to {int}")
    public void verifyCartQuantityHasUpdatedTo(int cartNumber) {
        Assert.assertTrue(homePage.isCartNumberUpdated(cartNumber));


    }

    @When("user remove that product")
    public void userRemoveThatProduct() {
        homePage.removeProductFromCart();
    }

    @Then("verify removed from cart popup is displayed")
    public void verifyRemovedFromCartPopupIsDisplayed() {
        Assert.assertTrue(homePage.isRemovedPopUpDisplayed());
       // CucumberReportManager.attachScreenshot();

    }


    @When("user search for product name {string}")
    public void userSearchForProductName(String product) {
        homePage.searchForProduct(product);
    }
}

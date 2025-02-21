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

    @When("user goes to baby care products")
    public void userGoesToBabyCareProducts() {
        homePage.goToBabyCareProducts();
    }

    @And("clicks on view all button of baby care products")
    public void clicksOnViewAllButtonOfBabyCareProducts() {
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
}

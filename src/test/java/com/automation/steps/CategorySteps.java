package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CategorySteps extends BaseSteps{
    @Then("verify user is on category page")
    public void verifyUserIsOnCategoryPage() {
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed());
    }

    @When("user selects specific ingredient {string}")
    public void userSelectsSpecificIngredient(String ingredient) {
        categoryPage.selectIngredient(ingredient);
    }

    @And("selects {string} under specific ingredient")
    public void selectsUnderSpecificIngredient(String desiredProduct) {
        categoryPage.selectProductUnderIngredient(desiredProduct);
    }
}

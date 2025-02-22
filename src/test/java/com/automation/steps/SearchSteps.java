package com.automation.steps;

import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{

    @Then("verify trending searches is displayed")
    public void verifyTrendingSearchesIsDisplayed() {
        Assert.assertTrue(searchPage.isTrendingSearchesDisplayed());
        CucumberReportManager.attachScreenshot();

    }

    @When("user selects {string} from trending searches")
    public void userSelectsFromTrendingSearches(String desiredSearch) {
        searchPage.selectFromTrendingSearch(desiredSearch);
    }

    @Then("verify recently viewed is displayed")
    public void verifyRecentlyViewedIsDisplayed() {
        Assert.assertTrue(searchPage.isRecentlyViewedDisplayed());
        CucumberReportManager.attachScreenshot();

    }

    @And("verify the product viewed by user is under recently viewed list")
    public void verifyTheProductViewedByUserIsUnderRecentlyViewedList() {
        Assert.assertTrue(searchPage.isViewedProductPresent());
        CucumberReportManager.attachScreenshot();

    }
}

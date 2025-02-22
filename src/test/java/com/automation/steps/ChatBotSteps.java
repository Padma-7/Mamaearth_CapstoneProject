
package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChatBotSteps extends BaseSteps{


    @Then("verify user is on chat tab")

    public void verifyUserIsOnChatTab() {

        Assert.assertTrue(chatBotPage.isUserInChatPage());
        CucumberReportManager.attachScreenshot();


    }

    @Then("user fills in the details {string} {string} {string}")

    public void userFillsInTheDetails(String name, String email, String phone) {

        chatBotPage.fillInTheDetails(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(email), ConfigReader.getConfigValue(phone));

    }

    @And("user clicks on send query")

    public void userClicksOnSendQuery() {

        chatBotPage.clickOnSendQuery();

    }

    @When("user type in a product recommendation question {string}")

    public void userTypeInAProductRecommendationQuestion(String question) {

        chatBotPage.typeInTheQuery(ConfigReader.getConfigValue(question));

    }

    @Then("verify chatbot responds with product recommendations for the same")

    public void verifyChatbotRespondsWithProductRecommendationsForTheSame() {

        Assert.assertTrue(chatBotPage.IsChatBotReplyDisplayed());
        CucumberReportManager.attachScreenshot();


    }

    @Then("verify chatbot responds with welcome message")
    public void verifyChatbotRespondsWithWelcomeMessage() {
        Assert.assertTrue(chatBotPage.isWelcomeTextDisplayed());
        CucumberReportManager.attachScreenshot();

    }
}


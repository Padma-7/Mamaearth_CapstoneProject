package com.automation.steps;

import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;

import static com.automation.utils.RestAssuredUtils.getResponseFieldValue;

public class RequestSteps {

    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set request body from json file {string}")
    public void setRequestBodyFromJsonFile(String fileName) throws FileNotFoundException {
        RestAssuredUtils.setBody(fileName);
    }

    @When("user performs post call")
    public void userPerformsPostCall() {
        RestAssuredUtils.post();
    }


    @And("store {string} to config value {string}")
    public void storeToConfigValue(String jsonPath, String key) {
        RestAssuredUtils.storeResponseFieldValueToConfig(jsonPath, key);
    }

    @And("verify response body has a field {string} is not null")
    public void verifyResponseBodyHasAFieldIsNotNull(String jsonPath) {
        Assert.assertNotNull(getResponseFieldValue(jsonPath));
    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }

    @And("set param {string} to {string}")
    public void setParamTo(String key, String value) {
        RestAssuredUtils.setFormParam(key, value);
    }
}

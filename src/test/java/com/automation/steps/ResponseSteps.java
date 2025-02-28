package com.automation.steps;

import com.automation.pojo.pet.CreatePetPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body matches request body of create pet")
    public void verifyResponseBodyMatchesRequestBodyOfCreatePet() {
        CreatePetPojo requestPojo = (CreatePetPojo) ConfigReader.getObject("create_pet_pojo");
        CreatePetPojo responsePojo = RestAssuredUtils.getResponse().as(CreatePetPojo.class);
        Assert.assertEquals(requestPojo, responsePojo);
    }

    @And("verify response matches schema {string}")
    public void verifyResponseMatchesSchema(String fileName) {
        Response response = RestAssuredUtils.getResponse();
        response.then().assertThat().
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data\\" + fileName));
    }

    @And("verify count of {string} with {string} after adding a new pet to store")
    public void verifyCountOfWithAfterAddingANewPetToStore(String previous, String current) {
        Assert.assertEquals(ConfigReader.getIntConfigValue(previous)+1,ConfigReader.getIntConfigValue(current));
    }
}

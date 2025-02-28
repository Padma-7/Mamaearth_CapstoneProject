package com.automation.steps;

import com.automation.pojo.pet.CreatePetPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;

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
    public void setRequestBodyFromJsonFile(String fileName) throws Exception {
//        String body = RestAssuredUtils.getDataFromJsonFile(fileName);
//        ObjectMapper mapper = new ObjectMapper();
//        CreatePetPojo pojo = mapper.readValue(body, CreatePetPojo.class);
//        ConfigReader.setObject("create_pet_pojo", pojo);
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

    @And("set path param {string} to {string}")
    public void setPathParamTo(String key, String value) {
        RestAssuredUtils.setPathParam(key, ConfigReader.getConfigValue(value));
    }

    @Given("set request body from file {string} with random data")
    public void set_request_body_from_file_with_random_data(String fileName) throws Exception {
        String body = RestAssuredUtils.getDataFromJsonFile(fileName);
        ObjectMapper mapper = new ObjectMapper();
        CreatePetPojo pojo = mapper.readValue(body, CreatePetPojo.class);
        Faker faker = new Faker();
        pojo.setId(faker.idNumber().hashCode());
        pojo.setName(faker.name().username());
        pojo.setPhotoUrls(Arrays.asList(faker.internet().url(), faker.internet().url()));
        ConfigReader.setObject("create_pet_pojo", pojo);
        RestAssuredUtils.setBody(pojo);
    }

    @And("store {string} of request body to config value {string}")
    public void storeOfRequestBodyToConfigValue(String key, String value) throws FileNotFoundException {
        String name=RestAssuredUtils.getDataFromJsonFile(key);
        ConfigReader.setConfigValue(value, name );

    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @And("store {string} of request from file {string} body to config value {string}")
    public void storeOfRequestFromFileBodyToConfigValue(String key, String filename, String value) throws FileNotFoundException {
        String name=RestAssuredUtils.getRequestFieldValue(key,filename);
        ConfigReader.setConfigValue(value, name );
    }

    @Then("verify {string} value in file {string} is less than {int}")
    public void verifyValueInFileIsLessThan(String jsonpath, String filename, int quantity) throws FileNotFoundException {
        String quantityValue =RestAssuredUtils.getRequestFieldValue(jsonpath,filename);
        int num = Integer.parseInt(quantityValue);
        boolean result = num<quantity;
        //System.out.println(result);
        Assert.assertTrue(result);
    }
}

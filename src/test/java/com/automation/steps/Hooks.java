package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    @Before("@web or @android")
    public void setUp() throws IOException {
        ConfigReader.initConfig();
        DriverManager.createDriver();

    }

    @Before("@api")
    public void setUpAPI() throws IOException {
        ConfigReader.initConfig();

        RestAssured.baseURI=ConfigReader.getConfigValue("api.url");
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After("@web or @android")
    public void cleanUp(Scenario scenario)
    {
        WebDriver driver =  DriverManager.getDriver();
        if(true)
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png","screenshot");
        }
        driver.quit();

    }
}


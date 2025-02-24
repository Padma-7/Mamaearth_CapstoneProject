package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ChatBot.feature"},
        glue = "com.automation.steps",
        plugin = {"json:target/cucumber.json", "html:target/cucumber.html",
                "pretty",
                "timeline:test-output-thread/"})

public class TestRunner {
}
